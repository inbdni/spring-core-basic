package com.inflearn.springcorebasic.bean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inflearn.springcorebasic.AppConfig;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBeans() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = applicationContext.getBean(beanDefinitionName);
			System.out.println("name = " + beanDefinitionName + ", object = " + bean);
		}
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBeans() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = applicationContext.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + ", object = " + bean);
			}
		}
	}

	@Test
	@DisplayName("인프라 빈 출력하기")
	void findInfraStructureBeans() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
			if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = applicationContext.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + ", object = " + bean);
			}
		}
	}
}
