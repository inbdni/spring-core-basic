package com.inflearn.springcorebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inflearn.springcorebasic.discount.DiscountPolicy;
import com.inflearn.springcorebasic.discount.FixDiscountPolicy;
 import com.inflearn.springcorebasic.discount.RateDiscountPolicy;
import com.inflearn.springcorebasic.member.MemberRepository;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.member.MemberServiceImpl;
import com.inflearn.springcorebasic.member.MemoryMemberRepository;
import com.inflearn.springcorebasic.order.OrderService;
import com.inflearn.springcorebasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy getDiscountPolicy() {
		// return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

}
