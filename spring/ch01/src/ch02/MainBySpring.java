package ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBySpring {
	public static void main(String[] args) {
		String configLocation = "classpath:ch02/applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		Project project = (Project) ctx.getBean("sampleProject");
		project.build();
		ctx.close();
	}
}
