package com.inflearn.springcorebasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inflearn.springcorebasic.AppConfig;
import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;
import com.inflearn.springcorebasic.member.MemberService;

public class OrderServiceTest {

	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void createOrder() {
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
