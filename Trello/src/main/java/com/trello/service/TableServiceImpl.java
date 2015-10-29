package com.trello.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trello.model.Table;
import com.trello.model.TableList;

public class TableServiceImpl implements TableService{
	private List<Table> tables;
	
	TableServiceImpl() {
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
		
	public void addListToTable(int tableId, TableList list) {
		tables.get(tableId).addList(list);
	}

	public void editList(int tableId, int listId, String name) {
		tables.get(tableId).editList(listId, name);
	}
	
	public void deleteList(int tableId, int listId) {
		tables.get(tableId).deleteList(listId);
	}
}
