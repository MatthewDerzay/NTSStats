package org.matt.ntsstats;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TournamentsDAO {
	
	public static void main(String[] args) {
		
	}
	
	public static int addTournament(String name, String date) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("INSERT INTO tournaments (NAME, T_DATE) values ('" + name + "', '" + date + "')");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static ArrayList<Tournament> getAll() {
		ArrayList<Tournament> allTournaments = new ArrayList<Tournament>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tournaments");
			while (rs.next()) {
				allTournaments.add(new Tournament(rs.getInt(1), rs.getString(2), rs.getString(3))); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return allTournaments;
	}
	
	public static Tournament getTournamentInfo(int id) {
		Tournament tournament = new Tournament();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tournaments where ID = " + id);
			while (rs.next()) {
				tournament = new Tournament(rs.getInt(1), rs.getString(2), rs.getString(3)); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return tournament;
	}
	
	public static String betterDate(String date) {
		String betterDate = "";
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));
		
		switch(month) {
		case 1:
			betterDate = "January";
			break;
		case 2:
			betterDate = "February";
			break;
		case 3:
			betterDate = "March";
			break;
		case 4:
			betterDate = "April";
			break;
		case 5:
			betterDate = "May";
			break;
		case 6:
			betterDate = "June";
			break;
		case 7:
			betterDate = "July";
			break;
		case 8:
			betterDate = "August";
			break;
		case 9:
			betterDate = "September";
			break;
		case 10:
			betterDate = "October";
			break;
		case 11:
			betterDate = "November";
			break;
		case 12:
			betterDate = "December";
			break;
		}
		betterDate = betterDate + " " + day + ", " + year;
		
		return betterDate; 
	}
	
	public static String shorten(String stringP) {
		String string = "";
		String[] split = stringP.split(" ");
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
				string = string +  s;
			} else {
				string = string + s.charAt(0);
			}
		}
		
		return string;
	}
	
	public static int updateTournamentName(int id, String name) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE tournaments set NAME = \"" + name + "\" where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updateTournamentDate(int id, String date) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE tournaments set T_DATE = \"" + date + "\" where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
