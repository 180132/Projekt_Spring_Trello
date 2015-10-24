package com.trello.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.trello.model.Table;

public class TableServiceImpl implements TableService{
	
	
	
	private static List<Table> tableList;
	
	static{
		tableList  = new LinkedList<Table>();
	}
	
	
	public List<Table> getTables()
	{
		return tableList;
	}
	
	public void addTable(Table t)
	{
		tableList.add(t);
	}
	
	public void deleteTable(int id)
	{
		if(id>=0 && id<tableList.size())
		{
			tableList.remove(id);
		}
	}
	public void editTable(int id, String name)
	{
		if(id>=0 && id<tableList.size())
		{
			tableList.get(id).setName(name);
		}
	}
}
