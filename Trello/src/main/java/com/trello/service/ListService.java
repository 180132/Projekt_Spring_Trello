package com.trello.service;

import java.util.List;
import com.trello.model.TableList;

public interface ListService {
	public List<TableList> getLists();
	public void addList(TableList t);
	public void deleteList(int id);
	public void editList(int id, String name);
}
