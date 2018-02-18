package org.matt.ntsstats;

public class Set {
	private int id;
	private int player1;
	private int player2;
	private int winner;
	private int tournament;
	
	public Set() {
		
	}
	
	public Set(int idP, int player1P, int player2P, int winnerP, int tournamentP) {
		id = idP;
		player1 = player1P;
		player2 = player2P;
		winner = winnerP;
		tournament = tournamentP;
	}
	
	public int getId() {
		return id;
	}
	public void setPlayer1(int player1P) {
		player1 = player1P;
	}
	public int getPlayer1() {
		return player1;
	}
	public void setPlayer2(int player2P) {
		player2 = player2P;
	}
	public int getPlayer2() {
		return player2;
	}
	public void setWinner(int winnerP) {
		winner = winnerP;
	}
	public int getWinner() {
		return winner;
	}
	public void setTournament(int tournamentP) {
		tournament = tournamentP;
	}
	public Integer getTournament() {
		return tournament;
	}
}
