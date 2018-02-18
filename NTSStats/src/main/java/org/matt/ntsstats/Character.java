package org.matt.ntsstats;

//comment

public class Character {
	private int id;
	private String name;
	
	public Character() {
		
	}
	
	public Character(int idP, String nameP) {
		id = idP;
		name = nameP;
	}
	
	public int getId() {
		return id;
	}
	public void setName(String nameP) {
		name = nameP;
	}
	public String getName() {
		return name;
	}
}
