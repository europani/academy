package ch07.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch07.board.ArticleDao;
import ch07.board.MemoryArticleDao;
import ch07.board.ReadArticleServiceImpl;
import ch07.board.WriteArticleServiceImpl;
import ch07.member.MemberServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class QuickStartConfig {

	@Bean
	public ProfilingAspect performanceTraceAspect() {
		return new ProfilingAspect();
	}
	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}
	@Bean
	public ArticleCacheAspect cache() {
		return new ArticleCacheAspect();
	}
	@Bean
	public ArticleDao articleDao() {
		return new MemoryArticleDao();
	}
	@Bean
	public WriteArticleServiceImpl writeArticleService() {
		return new WriteArticleServiceImpl(articleDao());
	}
	@Bean
	public MemberServiceImpl memberService() {
		return new MemberServiceImpl();
	}
	@Bean
	public ReadArticleServiceImpl readArticleService() {
		ReadArticleServiceImpl svc = new ReadArticleServiceImpl();
		svc.setArticleDao(articleDao());
		return svc;
	}
	

}
