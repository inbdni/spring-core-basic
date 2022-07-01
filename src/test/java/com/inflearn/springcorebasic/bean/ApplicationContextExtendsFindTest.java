package com.inflearn.springcorebasic.bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inflearn.springcorebasic.discount.DiscountPolicy;
import com.inflearn.springcorebasic.discount.FixDiscountPolicy;
import com.inflearn.springcorebasic.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtendsBeanConfig.class);

	@Test
	@DisplayName("부모 타입으로 조회 시 자식이 여러개면 중복 오류 발생")
	void findBeanByParentTypeDuplicated() {
		assertThrows(NoUniqueBeanDefinitionException.class,
			() -> applicationContext.getBean(DiscountPolicy.class));
	}

	@Test
	@DisplayName("부모 타입으로 조회 시 자식이 여러개면 빈 이름을 지정")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy",
			DiscountPolicy.class);
		assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("특정 자식 타입으로 조회")
	// 지양
	void findBeanByChildType() {
		RateDiscountPolicy rateDiscountPolicy = applicationContext.getBean(RateDiscountPolicy.class);
		assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("부모 타입으로 모두 조회")
	void findAllBeansByParentType() {
		Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(DiscountPolicy.class);
		for (String key : beansOfType.keySet()) {
			System.out.println("key: " + key + ", value: " + beansOfType.get(key));
		}
		System.out.println("beansOfType: " + beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("루트 부모 타입으로 모두 조회 - Object")
	void findAllBeansByRootParentType() {
		Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
		for (String key : beansOfType.keySet()) {
			System.out.println("key: " + key + ", value: " + beansOfType.get(key));
		}
		System.out.println("beansOfType: " + beansOfType);
	}

	@Configuration
	static class ExtendsBeanConfig {

		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}

		@Bean
		public DiscountPolicy fixDisCountPolicy() {
			return new FixDiscountPolicy();
		}

	}
}
