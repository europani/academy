package ch07.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch07.member.MemberService;
import ch07.member.MemberServiceImpl;

@Configuration
public class NoAopConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
}
