package com.inflearn.springcorebasic.scan.filter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.context.annotation.FilterType.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

public class ComponentFilterAppConfigTest {

	@Test
	void filterScan() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

		BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
		assertThat(beanA).isNotNull();

		assertThrows(NoSuchBeanDefinitionException.class,
			() -> applicationContext.getBean("beanB", BeanB.class));
	}

	@Configuration
	@ComponentScan(
		includeFilters = @Filter(type = ANNOTATION, classes = MyIncludeComponent.class),
		excludeFilters = @Filter(type = ANNOTATION, classes = MyExcludeComponent.class)
	)
	static class ComponentFilterAppConfig {
	}
}
