package mybatis.anno;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.Comment;

public class CommentAnnoRepository {
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
	
	public Comment selectCommentByPrimaryKey(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByPrimaryKey(commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer insertComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			Integer result = sqlSession.getMapper(CommentMapper.class).insertComment(comment);
			if (result == 1) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer deleteComment(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			Integer result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentNo);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Comment selectCommentByPrimarykeyConstructor2(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByPrimarykeyConstructor2(commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public static void main(String[] args) {
		CommentAnnoRepository c = new CommentAnnoRepository();
		System.out.println(c.selectCommentByPrimaryKey(1L));
		
//		Comment comment = new Comment(9L, "user9", new Date(), "tega");
//		System.out.println(c.insertComment(comment));
//		System.out.println(c.deleteComment(8L));
	
		System.out.println(c.selectCommentByPrimarykeyConstructor2(2L));
	}
}
