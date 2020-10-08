package ch07.board;

import java.util.HashMap;
import java.util.Map;

public class MemoryArticleDao implements ArticleDao {
	private int articleNo = 0;
	private Map<Integer, Article> articleMap = new HashMap<Integer, Article>();

	@Override
	public void insert(Article article) {
		System.out.println("MemoryArticleDao.insert() 실행");
		articleNo++;
		article.setId(articleNo);
		articleMap.put(articleNo, article);
	}

	@Override
	public Article selectById(Integer id) {
		return articleMap.get(id);
	}
	
}
