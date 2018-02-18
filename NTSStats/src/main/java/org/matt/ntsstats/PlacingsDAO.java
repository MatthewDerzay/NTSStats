package org.matt.ntsstats;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlacingsDAO {
	
	public static void main(String[] args) {
		 
	}

	public static int addPlacing(int playerId, int tournament_Id, int placing) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("INSERT INTO placings (PLAYER_ID, TOURNAMENT_ID, PLACING) values (" 
					+ playerId + ", " + tournament_Id + ", " + placing + ")");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static ArrayList<Placing> getAll() {
		ArrayList<Placing> allPlacings = new ArrayList<Placing>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from placings");
			while (rs.next()) {
				allPlacings.add(new Placing(rs.getInt(1), rs.getInt(2), rs.getInt(3))); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return allPlacings;
	}
	
	public static Placing getPlacingInfo(int player, int tournament) {
		Placing placing = new Placing();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from placings where PLAYER_ID = " + player 
					+ " and TOURNAMENT_ID = " + tournament);
			while (rs.next()) {
				placing = new Placing(rs.getInt(1), rs.getInt(2), rs.getInt(3)); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return placing;
	}
	
	public static String betterPlacing(int number) {
		String placing;
		
		switch(number) {
		case 1: 
		case 21:
			placing = number + "st";
			break;
		case 2:
		case 22:
			placing = number + "nd";
			break;
		case 3:
		case 23:
			placing = number + "rd";
			break;
		default:
			placing = number + "th";
		}
		
		return placing;
	}
	
	public static ArrayList<Placing> getTournamentPlacings(int id) {
		ArrayList<Placing> tournamentPlacings = new ArrayList<Placing>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from placings where TOURNAMENT_ID = " + id);
			while (rs.next()) {
				tournamentPlacings.add(new Placing(rs.getInt(1), rs.getInt(2), rs.getInt(3))); 
			}
			tournamentPlacings.sort((p1, p2) -> p1.getPlacing().compareTo(p2.getPlacing()));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return tournamentPlacings;
	}
	
	public static int updatePlayer(int oldPlayer, int tournament, int newPlayer) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE placings set PLAYER_ID = " + newPlayer + " where PLAYER_ID = " 
					+ oldPlayer + " and TOURNAMENT_ID = " + tournament);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updateTournament(int player, int oldTournament, int newTournament) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE placings set TOURNAMENT_ID = " + newTournament + " where PLAYER_ID = " 
					+ player + " and TOURNAMENT_ID = " + oldTournament);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updatePlacing(int player, int tournament, int placing) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE placings set PLACING = " + placing + " where PLAYER_ID = " 
					+ player + " and TOURNAMENT_ID = " + tournament);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
