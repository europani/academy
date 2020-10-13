package ch07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ch07.anno.QuickStartConfig;
import ch07.board.NewArticleRequest;
import ch07.board.ReadArticleService;
import ch07.board.WriteArticleService;
import ch07.member.MemberRequest;
import ch07.member.MemberService;
import ch07.member.UpdateInfo;

public class MainByXmlAop {

	public static void main(String[] args) {
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch07/acQuickStart.xml");
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch07/acQuickStart2.xml");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(QuickStartConfig.class);
		WriteArticleService writeArticleService = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		System.out.println("=====================");
		MemberService memberService = ctx.getBean(MemberService.class);
		MemberRequest memberRequest = new MemberRequest("id", "name", "pw");
		memberService.regist(memberRequest);
				
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("newName");
		memberService.update("madvirus", updateInfo);
		
		System.out.println("=====================");
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(1);
		
		ctx.close();
	}
}
