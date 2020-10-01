package ch02.erp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/erp/config.xml");
		ErpClientFactory factory = ctx.getBean(ErpClientFactory.class);
		ErpClient client = factory.create();
		client.connent();
		
		client.close();
	}
	
}
