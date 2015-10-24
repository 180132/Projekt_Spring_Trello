package com.trello.service;

import java.util.List;

import com.trello.model.Table;

public interface TableService {
	public List<Table> getTables();
	public void addTable(Table t);
	public void deleteTable(int id);
	public void editTable(int id, String name);
}
