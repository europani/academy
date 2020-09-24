package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardMybatisDAO extends AbstractMybatis {
	private String namespace = "Board";
	HashMap<String, Object> map = new HashMap<String, Object>();

	public List<BoardDTO> boardAllList() {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".boardAllList");
		} finally {
			sqlsession.close();
		}
	}

	public int getArticleCount(String boardid, String category, String sentence) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			map.clear();
			map.put("boardid", boardid);
			map.put("category", category);
			map.put("sentence", sentence);
			return sqlsession.selectOne(namespace + ".getArticleCount", map);
		} finally {
			sqlsession.close();
		}
	}

	public List<BoardDTO> getArticles(int start, int end, String boardid, String category, String sentence) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			map.clear();
			map.put("start", start);
			map.put("end", end);
			map.put("boardid", boardid);
			map.put("category", category);
			map.put("sentence", sentence);
			return sqlsession.selectList(namespace + ".getArticles", map);
		} finally {
			sqlsession.close();
		}
	}

	public BoardDTO getArticle(int num, String boardid, boolean readcount) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			map.clear();
			map.put("num", num);
			map.put("boardid", boardid);

			BoardDTO article = new BoardDTO();
			int result = 0;
			if (readcount) {
				result = sqlsession.update(namespace + ".addReadCount", map);
			}
			article = sqlsession.selectOne(namespace + ".getArticle", map);
			sqlsession.commit();
			return article;
		} finally {
			sqlsession.close();
		}
	}

	public void insertArticle(BoardDTO article, String boardid) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();

		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();

		try {
			int number = sqlsession.selectOne(namespace + ".insertArticle_new");
			if (number != 0) {
				number = number + 1;
			} else {
				number = 1;
			}
			if (num != 0) {
				map.clear();
				map.put("ref", ref);
				map.put("re_step", re_step);
				map.put("boardid", boardid);
				int result = sqlsession.update(namespace + ".insertArticle_update", map);
				if (result > 0) {
					sqlsession.commit();
				}
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
			article.setNum(number);
			article.setRef(ref);
			article.setRe_step(re_step);
			article.setRe_level(re_level);
			article.setBoardid(boardid);
			
			int result = sqlsession.insert(namespace + ".insertArticle_insert", article);
			if (result > 0) {
				sqlsession.commit();
				System.out.println("insert OK!");
			}

		} finally {
			sqlsession.close();
		}
	}
	
	public int updateArticle(BoardDTO article, String boardid) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			String dbpasswd = sqlsession.selectOne(namespace + ".update_passwd", article);
			if (dbpasswd.equals(article.getPasswd())) {
				result = sqlsession.update(namespace + ".update_update", article);
				if (result != 0) {
					sqlsession.commit();
					System.out.println("update OK!");
				}
			}
			return result;
		} finally {
			sqlsession.close();
		}
	}
	
	public int deleteArticle(String num, String inputPasswd, String boardid) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
	
		try {
			map.clear();
			map.put("num", num);
			map.put("boardid", boardid);
			String dbpasswd = sqlsession.selectOne(namespace + ".delete_passwd", map);
			if (dbpasswd.equals(inputPasswd)) {
				result = sqlsession.delete(namespace + ".delete_delete", num);
				if (result != 0) {
					sqlsession.commit();
					System.out.println("delete OK!");
				}
			}
			return result;
		} finally {
			sqlsession.close();
		}
	}

}
