package ch02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] args) {

		BeanFactory ac = new XmlBeanFactory(new FileSystemResource("src/ch02/applicationContext.xml"));
		MessageBeanImpl bean = ac.getBean(MessageBeanImpl.class);
		bean.sayHello();
	}
}
