package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		MessageBean bean = (MessageBean)ac.getBean("messageBean", MessageBean.class);
		bean.sayHello("spring");
	}
}
  