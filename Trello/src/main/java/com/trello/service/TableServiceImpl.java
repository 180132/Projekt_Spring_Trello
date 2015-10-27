package com.trello.service;

import java.util.LinkedList;
import java.util.List;
import com.trello.model.Table;

public class TableServiceImpl implements TableService{
	private static List<Table> tables;
	private ListService listService = new ListServiceImpl();
	
	static {
		tables  = new LinkedList<Table>();
	}
	
	
	public List<Table> getTables()
	{
		return tables;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
	}
	
	public void deleteTable(int id)
	{
		if(id>=0 && id<tables.size())
		{
			tables.remove(id);
		}
	}
	public void editTable(int id, String name)
	{
		if(id>=0 && id<tables.size())
		{
			tables.get(id).setName(name);
		}
	}
}
