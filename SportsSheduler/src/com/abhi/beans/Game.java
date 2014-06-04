package com.abhi.beans;

public class Game {
	private String gameName;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	@Override
	public String toString() {
		return "Game [gameName=" + gameName + "]";
	}
	
}
