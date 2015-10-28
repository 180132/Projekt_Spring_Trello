package com.trello.model;

public class Table {
	
	private String name;
	private TableVisibility visibility;
	private boolean starred; //tablice oznaczone jako star sa pokazywane na samej górze.
	
	public enum TableVisibility {
		PRIVATE,
		TEAM,
		PUBLIC
	}

	public Table(String name, TableVisibility visibility) {
		super();
		this.name = name;
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TableVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(TableVisibility visibility) {
		this.visibility = visibility;
	}

	public boolean isStarred() {
		return starred;
	}

	public void setStarred(boolean starred) {
		this.starred = starred;
	}	
}
