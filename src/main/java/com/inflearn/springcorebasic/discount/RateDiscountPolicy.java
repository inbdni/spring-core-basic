package com.inflearn.springcorebasic.discount;

import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercemt = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercemt / 100;
		} else {
			return 0;
		}
	}

}
