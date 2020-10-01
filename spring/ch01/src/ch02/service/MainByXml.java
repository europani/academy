package ch02.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/service/config.xml");

		UserRepository ur = (UserRepository) ctx.getBean("userRepository");
		User u = ur.findUserById("madvirus");
		System.out.println(u);

		AuthenticationService authSvc = ctx.getBean(AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "2");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "3");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "4");

		try {
			authSvc.authenticate("bkchoi2", "12341");
		} catch (UserNotFoundException e) {}
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");
		authSvc.authenticate("bkchoi", "5678");

	}

	private static void runAuthAndCatchAuthEx(AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException e) {
		}
	}
}
