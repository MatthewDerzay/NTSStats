package org.matt.ntsstats;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayersDAO {
	
	public static void main(String[] args) {
		
	}
	
	public static int addPlayer(String lastName, String firstName, int main, int secondary, int tertiary) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("INSERT INTO players (LAST_NAME, FIRST_NAME, MAIN_ID, SECONDARY_ID, "
					+ "TERTIARY_ID) values ('" + lastName + "', '" + firstName + "', " + main + ", "
					+ secondary + ", " + tertiary + ")");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static ArrayList<Player> getAll() {
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from players");
			while (rs.next()) {
				allPlayers.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), 
						rs.getInt(6))); 
			}
			allPlayers.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
			allPlayers.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return allPlayers;
	}
	
	public static Player getPlayerInfo(int id) {
		Player player = new Player();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from players where ID = " + id);
			while (rs.next()) {
				player = new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), 
						rs.getInt(6)); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return player;
	}
	
	public static ArrayList<Placing> getPlayerResults(int id) {
		ArrayList<Placing> playerResults = new ArrayList<Placing>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from placings where PLAYER_ID = " + id);
			while (rs.next()) {
				playerResults.add(new Placing(rs.getInt(1), rs.getInt(2), rs.getInt(3))); 
			}
			playerResults.sort((p1, p2) -> p1.getTournament().compareTo(p2.getTournament()));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return playerResults;
	}
	
	public static ArrayList<String> listMains(int id) {
		Player player = PlayersDAO.getPlayerInfo(id);
		ArrayList<String> list = new ArrayList<String>();
		if(player.getMain() != 0) {
			Character character = CharactersDAO.getCharacterInfo(player.getMain());
			list.add(character.getName());
		}
		if(player.getSecondary() != 0) {
			Character character = CharactersDAO.getCharacterInfo(player.getSecondary());
			list.add(character.getName());
		}
		if(player.getTertiary() != 0) {
			Character character = CharactersDAO.getCharacterInfo(player.getTertiary());
			list.add(character.getName());
		}
		return list;
	}
	
	public static int updatePlayerFirstName(int id, String name) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE players set FIRST_NAME = \"" + name + "\" where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updatePlayerLastName(int id, String name) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE players set LAST_NAME = \"" + name + "\" where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updatePlayerMain(int id, int main) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE players set MAIN_ID = " + main + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updatePlayerSecondary(int id, int secondary) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE players set SECONDARY_ID = " + secondary + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updatePlayerTertiary(int id, int tertiary) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE players set TERTIARY_ID = " + tertiary + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
