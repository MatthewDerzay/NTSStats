package org.matt.ntsstats;

public class Tournament {
	private int id;
	private String name;
	private String date;
	
	public Tournament() {
		
	}
	
	public Tournament(int idP, String nameP, String dateP) {
		id = idP;
		name = nameP;
		date = dateP;
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
	public void setDate(String dateP) {
		date = dateP;
	}
	public String getDate() {
		return date;
	}
	
}
