package mybatis;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable{
	private Long commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
	private User user;
	private List<Reply> replies;
	
	public Comment() {}
	
	public Comment(Long commentNo, String userId, Date regDate, String commentContent) {
		super();
		this.commentNo = commentNo;
		this.userId = userId;
		this.regDate = regDate;
		this.commentContent = commentContent;
	}
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", userId=" + userId + ", regDate=" + regDate + ", commentContent="
				+ commentContent + ", user=" + user + ", replies=" + replies + "]";
	}

}
