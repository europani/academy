package ch07.board;

public class WriteArticleServiceImpl implements WriteArticleService{

	private ArticleDao articleDao;
	
	public WriteArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void write(NewArticleRequest newArticleReq) {
		System.out.println("WriteArticleSericeImpl.write() 호출");
		Article article = toArticle(newArticleReq);
		articleDao.insert(article);
	}

	private Article toArticle(NewArticleRequest newArticleReq) {
		return new Article(
				newArticleReq.getWriterName(),
				newArticleReq.getTitle(),
				newArticleReq.getContent());
	}
}
