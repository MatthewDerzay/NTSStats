package org.matt.ntsstats;

public class Player {
	private String lastName;
	private String firstName;
	private int id;
	private int main;
	private int secondary;
	private int tertiary;
	
	public Player() {
		
	}
	
	public Player(int idP, String lastNameP, String firstNameP, int mainP, int secondaryP, int tertiaryP) {
		id = idP;
		lastName = lastNameP;
		firstName = firstNameP;
		main = mainP;
		secondary = secondaryP;
		tertiary = tertiaryP;
	}
	
	public int getId() {
		return id;
	}
	public void setLastName(String lastNameP) {
		lastName = lastNameP;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstNameP) {
		firstName = firstNameP;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setMain(int mainP) {
		main = mainP;
	}
	public int getMain() {
		return main;
	}
	public void setSecondary(int secondaryP) {
		secondary = secondaryP;
	}
	public int getSecondary() {
		return secondary;
	}
	public void setTertiary(int tertiaryP) {
		tertiary = tertiaryP;
	}
	public int getTertiary() {
		return tertiary;
	}
}
