package com.inflearn.springcorebasic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = applicationContext.getBean(StatefulService.class);
		StatefulService statefulService2 = applicationContext.getBean(StatefulService.class);

		// Thread A : A 사용자가 10000원 주문
		int userAPrice = statefulService1.order("userA", 10000);

		// Thread B : B 사용자가 20000원 주문
		int userBPrice = statefulService2.order("userB", 20000);

		// Thread A : A 사용자가 주문 금액 조회
		// int price = statefulService1.getPrice();
		// System.out.println("price = " + price);

		// assertThat(statefulService1.getPrice()).isEqualTo(20000);
		assertThat(userAPrice).isEqualTo(10000);
		assertThat(userBPrice).isEqualTo(20000);
	}

	static class TestConfig {

		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}


}
