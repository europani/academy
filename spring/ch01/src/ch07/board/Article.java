package ch07.board;

import java.util.Date;

public class Article {
	private Integer id;
	private String writeName;
	private String title;
	private String content;
	private Date creationTime;
	
	public Article(String writeName, String title, String content) {
		this.writeName = writeName;
		this.title = title;
		this.content = content;
		this.creationTime = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	
	
	

}
