package com.inflearn.springcorebasic;

import com.inflearn.springcorebasic.discount.DiscountPolicy;
import com.inflearn.springcorebasic.discount.FixDiscountPolicy;
import com.inflearn.springcorebasic.member.MemberRepository;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.member.MemberServiceImpl;
import com.inflearn.springcorebasic.member.MemoryMemberRepository;
import com.inflearn.springcorebasic.order.OrderService;
import com.inflearn.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
	}

	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	private DiscountPolicy getDiscountPolicy() {
		return new FixDiscountPolicy();
	}

}
