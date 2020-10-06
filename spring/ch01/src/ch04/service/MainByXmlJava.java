package ch04.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.sensor.Sensor;
import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;

public class MainByXmlJava {
	public static void main(String[] args) {
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch04/service/config-java.xml");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigWithXmlImport.class);
		useBean(ctx);
	}
	
	public static void useBean(AbstractApplicationContext ctx) {
		AuthenticationService authSvc = ctx.getBean(AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		
		Sensor sensor1 = ctx.getBean("sensor1", Sensor.class);
		System.out.println(sensor1);
		
		ctx.close();
	}
	

}
