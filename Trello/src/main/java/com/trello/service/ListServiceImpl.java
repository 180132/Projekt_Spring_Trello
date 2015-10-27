package com.trello.service;

import java.util.LinkedList;
import java.util.List;

import com.trello.model.TableList;

public class ListServiceImpl implements ListService{
	private static List<TableList> Lists;
	
	static {
		Lists  = new LinkedList<TableList>();
	}
		
	public List<TableList> getLists() {
		return Lists;
	}
	
	public void addList(TableList t) {
		Lists.add(t);
	}
	
	public void deleteList(int id) {
		if(id>=0 && id<Lists.size())
		{
			Lists.remove(id);
		}
	}
	
	public void editList(int id, String name) {
		if(id>=0 && id<Lists.size())
		{
			Lists.get(id).setName(name);
		}
	}
}
