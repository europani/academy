package ch08;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainByJavaOfEnv {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConfigOfEnv.class);
		ctx.refresh();
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		String javaVersion = env.getProperty("java.version");
		String dbUser = env.getProperty("db.user");
		System.out.printf("java version is %s\n", javaVersion);
		System.out.printf("dbUser is %s\n", dbUser);
	}
}
