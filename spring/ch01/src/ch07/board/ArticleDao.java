package ch07.board;

public interface ArticleDao {
	void insert(Article article);
	
	Article selectById(Integer id);
	
}