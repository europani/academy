package ch04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlWithoutId {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch04/config-without-id.xml");
		String[] beanNames = ctx.getBeanDefinitionNames();
		for (String bn : beanNames) {
			System.out.println(bn);
		}
	}
}
