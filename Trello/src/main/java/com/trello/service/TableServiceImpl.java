package com.trello.service;

import java.util.LinkedList;
import java.util.List;

import com.trello.model.Card;
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
	
	public void addCardToList(int tableIndex, int listIndex, Card card) {
		tables.get(tableIndex).addCard(listIndex, card);
	}
	
	public void editCard(int tableIndex, int listIndex, int cardIndex, String name) {
		tables.get(tableIndex).editCard(listIndex, cardIndex, name);
	}
	
	public void deleteCard(int tableIndex, int listIndex, int cardIndex) {
		tables.get(tableIndex).deleteCard(listIndex, cardIndex);
	}
}
