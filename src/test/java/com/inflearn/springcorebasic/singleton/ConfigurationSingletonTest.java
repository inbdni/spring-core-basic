package com.inflearn.springcorebasic.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inflearn.springcorebasic.AppConfig;
import com.inflearn.springcorebasic.member.MemberRepository;
import com.inflearn.springcorebasic.member.MemberServiceImpl;
import com.inflearn.springcorebasic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void configurationTest() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
		MemberServiceImpl memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);

		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();

		System.out.println("memberRepository = " + memberRepository);
		System.out.println("memberService -> memberRepository = " + memberRepository1);
		System.out.println("orderService -> memberRepository = " + memberRepository2);

		assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}
}
