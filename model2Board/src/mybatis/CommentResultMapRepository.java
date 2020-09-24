package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommentResultMapRepository {
	private final String namespace = "CommentResultMapMapper";

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
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return (Comment) sqlsession.selectOne(namespace + ".selectCommentByPrimaryKey", commentNo);
		} finally {
			sqlsession.close();
		}
	}

	public Comment selectCommentByPrimaryKeyAssociation(Long commentNo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return (Comment) sqlsession.selectOne(namespace + ".selectCommentByPrimaryKeyAssociation", commentNo);
		} finally {
			sqlsession.close();
		}
	}

	public CommentUser selectCommentByPrimaryKeyAssociation2(Long commentNo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return (CommentUser) sqlsession.selectOne(namespace + ".selectCommentByPrimaryKeyAssociation2", commentNo);
		} finally {
			sqlsession.close();
		}
	}

	public Comment selectCommentByPrimaryKeyCollection(Long commentNo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return (Comment) sqlsession.selectOne(namespace + ".selectCommentByPrimaryKeyCollection", commentNo);
		} finally {
			sqlsession.close();
		}
	}
	
	public static void main(String[] args) {
		CommentResultMapRepository c = new CommentResultMapRepository();
		System.out.println(c.selectCommentByPrimaryKey(2L));

		System.out.println(c.selectCommentByPrimaryKeyAssociation(1L));
		System.out.println(c.selectCommentByPrimaryKeyAssociation2(1L));
		System.out.println(c.selectCommentByPrimaryKeyCollection(1L));
		
		
	}
}
