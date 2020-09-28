package ch02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] args) {

		BeanFactory ac = new XmlBeanFactory(new FileSystemResource("src/ch02/applicationContext.xml"));
		MessageBean bean = ac.getBean(MessageBean.class);
		bean.sayHello();
		
	}
}