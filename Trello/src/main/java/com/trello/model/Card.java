package com.trello.model;

public class Card {
	private String name;
	private String description;
		
	public Card(String cardName) {
		super();
		this.name = cardName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}