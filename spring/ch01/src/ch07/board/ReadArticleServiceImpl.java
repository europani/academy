package ch07.board;

public class ReadArticleServiceImpl implements ReadArticleService {

	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public Article read(Integer id) {
		System.out.printf("ReadArticlServiceImpl.read(%d) 호출됨\n", id);
		return articleDao.selectById(id);
	}

}
