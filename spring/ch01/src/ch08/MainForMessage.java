package ch08;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForMessage {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch08/message-config.xml");
		
		System.out.println(ctx.getMessage("hello", null, Locale.getDefault()));
		System.out.println(ctx.getMessage("welcome", new String[] {"최범균", "aaaa"}, Locale.getDefault()));
		System.out.println(ctx.getMessage("hello", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("welcome", new String[] { "madvirus"}, Locale.ENGLISH));
		ctx.close();
	}
}
