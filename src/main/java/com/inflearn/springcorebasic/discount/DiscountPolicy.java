package com.inflearn.springcorebasic.discount;

import com.inflearn.springcorebasic.member.Member;

public interface DiscountPolicy {

	int discount(Member member, int price);

}
