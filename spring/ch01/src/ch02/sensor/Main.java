package ch02.sensor;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.springframework.context.ApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/sensor/config.xml");
		Monitor monitor = ctx.getBean(Monitor.class);
		System.out.println(monitor);
		
	}
}
