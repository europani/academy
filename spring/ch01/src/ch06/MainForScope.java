package ch06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForScope {
	public static void main(String[] args) {
//		useXml();
		useJava();
	}
	private static void useXml() {
		System.out.println("==== XML Meta ====");
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06/config-for-scope.xml");
		WorkScheduler scheduler = ctx.getBean("workScheduler", WorkScheduler.class);
		scheduler.makeAndRunWork();
		ctx.close();
	
	}

	private static void useJava() {
		System.out.println("==== Java Meta ====");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigForScope.class);
		WorkScheduler scheduler = ctx.getBean("workScheduler", WorkScheduler.class);
		scheduler.makeAndRunWork();
		ctx.close();
	}
}
