package ch01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] args) {

		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("src/ch01/applicationContext.xml"));
		IMessageBean bean1 = (IMessageBean) bf.getBean("messageBean");
		bean1.sayHello("spring");

		/*
		 * ApplicationContext fauctory = new
		 * GenericXmlApplicationContext("classpath:src/ch01/applicationContext.xml");
		 * MessageBean bean = (MessageBean) factory.getBean(MessageBean.class);
		 * bean.sayHello("spring");
		 */

	}
}
