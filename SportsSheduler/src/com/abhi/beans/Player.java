package com.abhi.beans;

public class Player {
	private String playerName;

	
	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + "]";
	}
}
