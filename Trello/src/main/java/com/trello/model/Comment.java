package com.trello.model;

import java.util.Date;

public class Comment {
	public String text;
	public Date creationDate;
	
	public Comment(String text, Date creationDate) {
		super();
		this.text = text;
		this.creationDate = creationDate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
