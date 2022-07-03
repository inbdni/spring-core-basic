package com.inflearn.springcorebasic.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inflearn.springcorebasic.AutoAppConfig;
import com.inflearn.springcorebasic.member.MemberService;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			AutoAppConfig.class);

		MemberService memberService = applicationContext.getBean(MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
