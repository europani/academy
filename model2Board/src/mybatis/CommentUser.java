package mybatis;

import java.io.Serializable;

public class CommentUser implements Serializable {
	private Comment comment;
	private User user;
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "CommentUser [comment=" + comment + ", user=" + user + "]";
	}
	
}
