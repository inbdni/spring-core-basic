package com.inflearn.springcorebasic.member;

public interface MemberRepository {

	void save(Member member);

	Member findById(Long memberId);

}
