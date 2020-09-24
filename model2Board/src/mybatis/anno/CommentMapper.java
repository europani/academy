package mybatis.anno;

import java.util.Date;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import mybatis.Comment;

public interface CommentMapper {
	@Select("SELECT comment_no, user_id, comment_content, reg_date FROM tcomment"
			+ " WHERE comment_no = #{commentNo}")
	@Results({
		@Result(column = "comment_no", property = "commentNo", jdbcType = JdbcType.BIGINT, id = true),
		@Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
		@Result(column = "reg_date", property = "regDate", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "comment_content", property = "commentContent", jdbcType = JdbcType.LONGVARCHAR)
	})
	Comment selectCommentByPrimaryKey(Long commentNo);
	
	@Insert("INSERT INTO tcomment(comment_no, user_id, comment_content, reg_date)"
			+ " VALUES (#{commentNo}, #{userId}, #{commentContent}, #{regDate})")
	Integer insertComment(Comment comment);
	
	@Delete("DELETE FROM tcomment WHERE comment_no = #{commentNo}")
	Integer deleteComment(Long commentNo);
	
	@Select("SELECT comment_no, user_id, comment_content, reg_date FROM tcomment"
			+ " WHERE comment_no = #{commentNo}")
	@ConstructorArgs({ @Arg(column = "comment_no", javaType = Long.class, jdbcType = JdbcType.BIGINT, id = true),
		@Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
		@Arg(column = "reg_date", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
		@Arg(column = "comment_content", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)})
	Comment selectCommentByPrimarykeyConstructor2(Long commentNo);
	
}
