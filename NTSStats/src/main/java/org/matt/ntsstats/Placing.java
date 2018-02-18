package org.matt.ntsstats;

public class Placing {
	private int player;
	private int tournament;
	private Integer placing;
	
	public Placing() {
		
	}
	
	public Placing(int playerP, int tournamentP, int placingP) {
		player = playerP;
		tournament = tournamentP;
		placing = placingP;
	}
	
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int playerP) {
		player = playerP;
	}
	public Integer getTournament() {
		return tournament;
	}
	public void setTournament(int tournamentP) {
		tournament = tournamentP;
	}
	public Integer getPlacing() {
		return placing;
	}
	public void setPlacing(int placingP) {
		placing = placingP;
	}
}
