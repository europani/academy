package ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;

public class MainByConfig {

	public static void main(String[] args) {
		useSingleClass();
		useMultipleClass();
	}
	
	private static void useSingleClass() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigUser.class);
		useBean(ctx);
	}

	private static void useBean(ApplicationContext ctx) {
		AuthenticationService authSvc = ctx.getBean(AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}
	
	private static void useMultipleClass() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigUser1.class, ConfigUser2.class);
		useBean(ctx);
	}

}