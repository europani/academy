package ch02.search;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/search/config.xml");
		SearchClientFactory factory = ctx.getBean(SearchClientFactory.class);
		System.out.println(factory);
		
		SearchClientFactory factory2 = ctx.getBean(SearchClientFactory.class);
		System.out.println("factory == factory2?? " + (factory == factory2));
	}
}
