package ch05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForLifecycle {
	public static void main(String[] args) {
//		useXml();
		useJava();
	}

	private static void useXml() {
		System.out.println("===== XML Meta ====");
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch05/config-for-lifecycle.xml");
		ctx.close();
	}
	private static void useJava() {
		System.out.println("===== Java Meta ====");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigForLifecycle.class);
		ctx.close();
	}
}
