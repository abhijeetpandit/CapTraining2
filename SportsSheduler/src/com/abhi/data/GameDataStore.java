package com.abhi.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.abhi.beans.Day;
import com.abhi.beans.Game;
import com.abhi.beans.Player;

public class GameDataStore {
	private List<Day> days = new ArrayList<>();
	private List<Game> games = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	
	private Map<Game, List<Player>> gamePlayerMap;
	private Map<Game, List<Day>> gameDayMap;
	
	
	public void generateDumyData() {
		Day day1 = new Day("1-1-2025");
		Day day2 = new Day("2-1-2025");
		Day day3 = new Day("3-1-2025");
		Day day4 = new Day("4-1-2025");
		Day day5 = new Day("5-1-2025");
		
		days.add(day1);
		days.add(day2);
		days.add(day3);
		days.add(day4);
		days.add(day5);
		
		Game game1 = new Game("Cricket");
		Game game2 = new Game("Football");
		Game game3 = new Game("Hockey");
		Game game4 = new Game("Boxing");
		
		games.add(game1);
		games.add(game2);
		games.add(game3);
		games.add(game4);
		
		Player player1 = new Player("Abhijeet");
		Player player2 = new Player("Sachin");
		Player player3 = new Player("Virat");
		Player player4 = new Player("Dhoni");
		Player player5 = new Player("John");
		Player player6 = new Player("Mike");
		Player player7 = new Player("Tyson");
		Player player8 = new Player("Constantine");
		Player player9 = new Player("Kapil");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		players.add(player6);
		players.add(player7);
		players.add(player8);
		players.add(player9);
		
		
		
	}
}
