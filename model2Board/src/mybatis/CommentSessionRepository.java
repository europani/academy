package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommentSessionRepository {
	private final String namespace = "CommentMapper";
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Comment> selectComment() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".selectComment");		// CommentMapper.selectComment
		} finally {
			sqlSession.close();
		}
	}
	
	public Comment selectCommentByPrimaryKey(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".selectCommentByPrimaryKey", commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".selectCommentByCondition", condition);
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer insertComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			int result = sqlSession.insert(namespace + ".insertComment", comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer updateComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			int result = sqlSession.update(namespace + ".updateComment", comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer deleteComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			int result = sqlSession.delete(namespace + ".deleteComment", comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer updateCommentIf(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			int result = sqlSession.update(namespace + ".updateCommentIf", comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer updateCommentTrim(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			int result = sqlSession.update(namespace + ".updateCommentTrim", comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Comment selectCommentByConditionIf(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".selectCommentByConditionIf", condition);
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer insertCommentKey(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			int result =  sqlSession.insert(namespace + ".insertCommentKey", comment);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByConditionChoose(Map<String, Object> condition) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".selectCommentByConditionChoose",  condition);
		} finally {
			sqlsession.close();
		}
	}
	
	public List<Comment> selectCommentByConditionForeach(Map<String, Object> condition) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".selectCommentByConditionForeach",  condition);
		} finally {
			sqlsession.close();
		}
	}
	
	public List<Comment> selectOgnlStaticMethod() {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".selectOgnlStaticMethod");
		} finally {
			sqlsession.close();
		}
	}
	
	public List<Comment> selectOgnlStaticField() {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".selectOgnlStaticField");
		} finally {
			sqlsession.close();
		}
	}
	
	public List<Comment> selectOgnlMethod2(Map<String, Object> condition) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".selectOgnlMethod2", condition);
		} finally {
			sqlsession.close();
		}
	}
	
	
	public static void main(String[] args) {
		CommentSessionRepository c = new CommentSessionRepository();
		System.out.println(c.selectComment());
		System.out.println(c.selectCommentByPrimaryKey(2L));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentNo", 3L);
		System.out.println(c.selectCommentByCondition(map));
	
		Comment comment = new Comment();
		
	/*	comment.setCommentNo(7L);
		comment.setCommentContent("sample_content");
		comment.setRegDate(new Date());
		comment.setUserId("sample user_Id");
		System.out.println(c.insertComment(comment));
	*/
		
	/*	comment.setCommentNo(7L);
		comment.setCommentContent("update_content");
		c.updateComment(comment);
	*/	
	/*	comment.setCommentNo(7L);
		c.deleteComment(comment);
	*/	
		comment.setCommentNo(7L);
		comment.setCommentContent("sample_content");
		comment.setRegDate(new Date());
		System.out.println(c.updateCommentTrim(comment));
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("commentNo", 2l);
		map2.put("userId", "user1");
		System.out.println(c.selectCommentByConditionIf(map2));
		
	/*	comment.setUserId("user7");
		comment.setCommentContent("test");
		comment.setRegDate(new Date());
		System.out.println(c.insertCommentKey(comment));
	*/
		
		User u = new User();
		u.setUserId("user1");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("commentNo", 1l);
		map3.put("user", u);
		System.out.println(c.selectCommentByConditionChoose(map3));
		
		System.out.println("-----");
		Long[] commentNos = {1l, 7l, 4l};
		map3.clear();
		map3.put("commentNos", commentNos);
		System.out.println(c.selectCommentByConditionForeach(map3));
		
		System.out.println(c.selectOgnlStaticMethod());
		System.out.println(c.selectOgnlStaticField());
	
		map3.clear();
		map3.put("userId", "user1");
		System.out.println(c.selectOgnlMethod2(map3));
	}
}
