package ch07.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch07.member.MemberService;
import ch07.member.MemberServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
}
