package com.inflearn.springcorebasic.bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inflearn.springcorebasic.AppConfig;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("빈 타입으로 조회")
	void findBeanByType() {
		MemberService memberService = applicationContext.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회")
	// 좋은 코드는 아님, 구현이 아닌 역할(인터페이스)에 의존하도록 해야 함
	void findBeanByImplType() {
		MemberService memberService = applicationContext.getBean(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("빈 이름으로 조회 실패")
	void findBeanByNameFailed() {
		assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("xxx", MemberService.class));
	}
}
