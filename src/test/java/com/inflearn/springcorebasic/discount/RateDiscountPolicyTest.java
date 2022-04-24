package com.inflearn.springcorebasic.discount;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다")
	void vip_discount() {
		// given
		Member member = new Member(1L, "memberVIP", Grade.VIP);

		// when
		int discount = discountPolicy.discount(member, 10000);

		// then
		assertThat(discount).isEqualTo(1000);
	}

	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
	void basic_discount() {
		// given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);

		// when
		int discount = discountPolicy.discount(member, 10000);

		// then
		assertThat(discount).isEqualTo(0);
	}

}
