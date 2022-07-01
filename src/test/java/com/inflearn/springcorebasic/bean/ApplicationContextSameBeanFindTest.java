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

import com.inflearn.springcorebasic.member.MemberRepository;
import com.inflearn.springcorebasic.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	@Test
	@DisplayName("타입으로 조회 시 같은 타입이 여러개면 중복 오류 발생")
	void findBeanByTypeDuplicated() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(MemberRepository.class));
	}

	@Test
	@DisplayName("타입으로 조회 시 같은 타입이 여러개면 빈 이름을 지정")
	void findBeanByName() {
		MemberRepository memberRepository1 = applicationContext.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository1).isInstanceOf(MemberRepository.class);
	}

	@Test
	@DisplayName("특정 타입의 빈을 모두 조회")
	void findAllBeansByType() {
		Map<String, MemberRepository> beansOfType = applicationContext.getBeansOfType(MemberRepository.class);
		for (String key : beansOfType.keySet()) {
			System.out.println("key: " + key + ", value: " + beansOfType.get(key));
		}
		System.out.println("beansOfType: " + beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2);
	}

	@Configuration
	static class SameBeanConfig {

		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}

		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}

	}
}
