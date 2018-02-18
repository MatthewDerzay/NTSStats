package org.matt.ntsstats;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SetsDAO {
	
	public static void main(String[] args) {
		
	}
	
	public static int addSet(int player1, int player2, int winner, int tournament) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("INSERT INTO sets (PLAYER1_ID, PLAYER2_ID, WINNER, "
					+ "TOURNAMENTS_ID) values (" + player1 + ", " + player2 + ", " + winner + ", "
					+ tournament + ")");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static ArrayList<Set> getAll() {
		ArrayList<Set> allSets = new ArrayList<Set>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sets");
			while (rs.next()) {
				allSets.add(new Set(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5))); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return allSets;
	}
	
	public static Set getSetInfo(int id) {
		Set set = new Set();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sets where ID = " + id);
			while (rs.next()) {
				set = new Set(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)); 
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return set;
	}
	
	public static int[] playerRecord(int id) {
		ArrayList<Set> sets = new ArrayList<Set>();
		int[] record = new int[2];
		int wins = 0;
		int loses = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sets where PLAYER1_ID = " + id + " or PLAYER2_ID = " + id);
			while (rs.next()) {
				sets.add(new Set(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5))); 
			}
			for(int i = 0; sets.size() > i; i++) {
				if(sets.get(i).getWinner() == id) {
					wins++;
				} else {
					loses++;
				}
			}
			record[0] = wins;
			record[1] = loses;
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return record;
	}
	
	public static ArrayList<String> playerWins(int id) {
		ArrayList<Set> sets = new ArrayList<Set>();
		ArrayList<Integer> opponents = new ArrayList<Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> complete = new ArrayList<String>();
		boolean exist = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sets where PLAYER1_ID = " + id + " or PLAYER2_ID = " + id);
			while (rs.next()) {
				sets.add(new Set(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5))); 
			}
			for(int i = 0; sets.size() > i; i++) {
				exist = false;
				if(sets.get(i).getWinner() == id) {
					if(sets.get(i).getPlayer1() == id) {
						for(int j = 0; opponents.size() > j; j++) {
							if(sets.get(i).getPlayer2() == opponents.get(j)) {
								Integer number = count.get(j) + 1;
								count.set(j, number);
								exist = true;
								break;
							}
						}
						if(exist == false) {
							opponents.add(sets.get(i).getPlayer2());
							count.add(1);
						}
					} else {
						for(int j = 0; opponents.size() > j; j++) {
							if(sets.get(i).getPlayer1() == opponents.get(j)) {
								Integer number = count.get(j) + 1;
								count.set(j, number);
								exist = true;
								break;
							}
						}
						if(exist == false) {
							opponents.add(sets.get(i).getPlayer1());
							count.add(1);
						}
					}
				}
			}
			for(int i = 0; opponents.size() > i; i++) {
				Player player = PlayersDAO.getPlayerInfo(opponents.get(i));
				if(count.get(i) == 1) {
					complete.add(player.getFirstName() + " " + player.getLastName());
				} else {
					complete.add(player.getFirstName() + " " + player.getLastName() + " x" + count.get(i));
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return complete;
	}
	
	public static ArrayList<String> playerLoses(int id) {
		ArrayList<Set> sets = new ArrayList<Set>();
		ArrayList<Integer> opponents = new ArrayList<Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> complete = new ArrayList<String>();
		boolean exist = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sets where PLAYER1_ID = " + id + " or PLAYER2_ID = " + id);
			while (rs.next()) {
				sets.add(new Set(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5))); 
			}
			for(int i = 0; sets.size() > i; i++) {
				exist = false;
				if(sets.get(i).getWinner() != id) {
					if(sets.get(i).getPlayer1() == id) {
						for(int j = 0; opponents.size() > j; j++) {
							if(sets.get(i).getPlayer2() == opponents.get(j)) {
								Integer number = count.get(j) + 1;
								count.set(j, number);
								exist = true;
								break;
							}
						}
						if(exist == false) {
							opponents.add(sets.get(i).getPlayer2());
							count.add(1);
						}
					} else {
						for(int j = 0; opponents.size() > j; j++) {
							if(sets.get(i).getPlayer1() == opponents.get(j)) {
								Integer number = count.get(j) + 1;
								count.set(j, number);
								exist = true;
								break;
							}
						}
						if(exist == false) {
							opponents.add(sets.get(i).getPlayer1());
							count.add(1);
						}
					}
				}
			}
			for(int i = 0; opponents.size() > i; i++) {
				Player player = PlayersDAO.getPlayerInfo(opponents.get(i));
				if(count.get(i) == 1) {
					complete.add(player.getFirstName() + " " + player.getLastName());
				} else {
					complete.add(player.getFirstName() + " " + player.getLastName() + " x" + count.get(i));
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return complete;
	}
		
	public static int winPercentage(int[] record) {
		double totalSets = record[0] + record[1];
		int winPerc = (int)(((double)record[0] / totalSets) * 100);
		return winPerc;
	}
	
	public static ArrayList<String> versusRecord(int id1, int id2) {
		ArrayList<Set> sets = new ArrayList<Set>();
		ArrayList<Integer> p1Wins = new ArrayList<Integer>();
		ArrayList<Integer> p2Wins = new ArrayList<Integer>();
		ArrayList<Integer> tId = new ArrayList<Integer>();
		ArrayList<String> complete = new ArrayList<String>();
		int p1Total = 0;
		int p2Total = 0;
		boolean exist = false;
		
		if(id1 == id2) {
			complete.add("You played yourself");
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from sets where (PLAYER1_ID = "+ id1 + " and PLAYER2_ID = " + id2 +") or (PLAYER1_ID = " + id2 + " and PLAYER2_ID = " + id1 + ")");
				while (rs.next()) {
					sets.add(new Set(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
				}
				sets.sort((p1, p2) -> p1.getTournament().compareTo(p2.getTournament()));
				for(int i = 0; sets.size() > i; i++) {
					exist = false;
					if(sets.get(i).getWinner() == id1) {
						for(int j = 0; tId.size() > j; j++) {
							if(sets.get(i).getTournament() == tId.get(j)) {
								p1Wins.set(j, p1Wins.get(j) + 1);
								exist = true;
								break;
							}
						}
						if(exist == false) {
							p1Wins.add(1);
							p2Wins.add(0);
							tId.add(sets.get(i).getTournament());
						}
					} else {
						for(int j = 0; tId.size() > j; j++) {
							if(sets.get(i).getTournament() == tId.get(j)) {
								p2Wins.set(j, p2Wins.get(j) + 1);
								exist = true;
								break;
							}
						}
						if(exist == false) {
							p1Wins.add(0);
							p2Wins.add(1);
							tId.add(sets.get(i).getTournament());
						}
					}
				}
				for(int i = 0; tId.size() > i; i++) {
					Tournament tournament = TournamentsDAO.getTournamentInfo(tId.get(i));
					p1Total = p1Total + p1Wins.get(i);
					p2Total = p2Total + p2Wins.get(i);
					complete.add(p1Wins.get(i) + " - " + TournamentsDAO.shorten(tournament.getName()) + " - " + p2Wins.get(i));
				}
				complete.add(p1Total + " - All Time - " + p2Total);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return complete;
	}
	
	public static int updateSetPlayer1(int id, int player) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE sets set PLAYER1_ID = " + player + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updateSetPlayer2(int id, int player) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE sets set PLAYER2_ID = " + player + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updateSetWinner(int id, int player) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE sets set WINNER = " + player + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static int updateSetTournament(int id, int tournament) {
		int result = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Gizmo2011");
			
			Statement stmt = con.createStatement();
			result = stmt.executeUpdate("UPDATE sets set TOURNAMENTS_ID = " + tournament + " where ID = " + id);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
