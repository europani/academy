package ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;

public class MainByConfigPac {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("ch03");
		
		AuthenticationService authSvc = ctx.getBean(AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}

}
