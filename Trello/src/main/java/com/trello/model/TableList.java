package com.trello.model;

public class TableList {
	public String name;

	public TableList(String tableListName) {
		super();
		this.name = tableListName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
