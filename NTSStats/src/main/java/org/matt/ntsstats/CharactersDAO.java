package org.matt.ntsstats;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CharactersDAO {

	public static int addCharacter(String name) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("INSERT INTO characters (CHAR_NAME) values ('" + name + "')");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static ArrayList<Character> getAll() {
		ArrayList<Character> allCharacters = new ArrayList<Character>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from characters");
			while (rs.next()) {
				allCharacters.add(new Character(rs.getInt(1), rs.getString(2))); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return allCharacters;
	}
	
	public static Character getCharacterInfo(int id) {
		Character character = new Character();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from characters where ID = " + id);
			while (rs.next()) {
				character = new Character(rs.getInt(1), rs.getString(2)); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return character;
	}
	
	public static int updateCharacterName(int id, String name) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE characters set CHAR_NAME = \"" + name + "\" where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
