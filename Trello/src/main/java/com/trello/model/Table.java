package com.trello.model;

import java.util.ArrayList;
import java.util.List;

public class Table {	
	private String name;
	private TableVisibility visibility;
	private boolean starred; //tablice oznaczone jako star sa pokazywane na samej górze.
	private ArrayList<TableList> lists;
	
	public enum TableVisibility {
		PRIVATE,
		TEAM,
		PUBLIC
	}

	public Table(String name, TableVisibility visibility) {
		super();
		this.name = name;
		this.visibility = visibility;
		this.lists = new ArrayList<TableList>();
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

	public void addList(TableList list) {
		lists.add(list);
	}

	public void editList(int listId, String name) {
		lists.get(listId).setName(name);
	}
	
	public void deleteList(int listId) {
		lists.remove(listId);
	}
}
