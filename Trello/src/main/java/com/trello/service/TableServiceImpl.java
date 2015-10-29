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
	
	public void deleteTable(int tableIndex)
	{
		if(tableIndex>=0 && tableIndex<tables.size())
		{
			tables.remove(tableIndex);
		}
	}
	
	public void editTable(int tableIndex, String name)
	{
		if(tableIndex>=0 && tableIndex<tables.size())
		{
			tables.get(tableIndex).setName(name);
		}
	}			
		
	public void addListToTable(int tableIndex, TableList list) {
		tables.get(tableIndex).addList(list);
	}

	public void editList(int tableIndex, int listIndex, String name) {
		tables.get(tableIndex).editList(listIndex, name);
	}
	
	public void deleteList(int tableIndex, int listIndex) {
		tables.get(tableIndex).deleteList(listIndex);
	}
}
