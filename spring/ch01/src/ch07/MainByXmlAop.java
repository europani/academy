package ch07;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch07.board.NewArticleRequest;
import ch07.board.WriteArticleService;

public class MainByXmlAop {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch07/acQuickStart.xml");
		WriteArticleService writeArticleService = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		ctx.close();
	}
}
