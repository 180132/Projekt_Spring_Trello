package com.trello.model;

import java.util.ArrayList;

import com.trello.model.Table.TableVisibility;


public class History {
	private ArrayList<String> activities;
	
	public enum ActivityType {
		TABLE_ADDITION,
		LIST_ADDITION,
		CARD_ADDITION,
		TABLE_EDITION,
		LIST_EDITION,
		CARD_EDITION,
		TABLE_DELETION,
		LIST_DELETION,
		CARD_DELETION
	}
	
	public ArrayList<String> getActivities() {
		return activities;
	}
	
	public void deleteActivity(int index) {
		activities.remove(index);
	}

	public void addActivity(ActivityType tableAddition, String name, TableVisibility visibility) {
		// TODO Auto-generated method stub
		
	}

	public void addActivity(ActivityType tableDeletion, String name) {
		// TODO Auto-generated method stub
		
	}

	public void addActivity(ActivityType tableEdition, String name, String name2) {
		// TODO Auto-generated method stub
		
	}

	public void addActivity(ActivityType listEdition, String name, String name2, String name3) {
		// TODO Auto-generated method stub
		
	}

	public void addActivity(ActivityType cardEdition, String name, String name2, String name3, String name4) {
		// TODO Auto-generated method stub
		
	}
}