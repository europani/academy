package ch07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch07.board.NewArticleRequest;
import ch07.board.ReadArticleService;
import ch07.board.WriteArticleService;
import ch07.member.MemberRequest;
import ch07.member.MemberService;
import ch07.member.UpdateInfo;

public class MainByXmlAop3 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch07/orderTest.xml");
		WriteArticleService writeArticleService = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		System.out.println("=====================");
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		System.out.println("---- 첫번째 read()");
		readArticleService.read(1);
		System.out.println("---- 두번째 read()");
		readArticleService.read(1);
				
		ctx.close();
	}
}
