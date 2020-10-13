package ch07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ch07.anno.AopConfig;
import ch07.anno.NoAopConfig;
import ch07.member.MemberService;
import ch07.member.MemberServiceImpl;

public class MainByXmlAop2 {

	public static void main(String[] args) {
		useNoAop();
		useAop();

	}

	private static void useNoAop() {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(NoAopConfig.class);
		
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		System.out.println(ms instanceof MemberService);	// true
		System.out.println(ms instanceof MemberServiceImpl);	// true
		
		System.out.println(ms.getClass().getName());
		ctx.close();
	}

	private static void useAop() {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		System.out.println(ms instanceof MemberService);	// true
		System.out.println(ms instanceof MemberServiceImpl);	// false
		
		System.out.println(ms.getClass().getName());
		ctx.close();
	}

}
