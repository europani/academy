package ch08;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaOfProp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigByProp.class);
		ctx.close();
	}
}
