package com.inflearn.springcorebasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.order.Order;
import com.inflearn.springcorebasic.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();
		// OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
		System.out.println("price = " + order.calculatePrice());
	}
}
