package com.scrapper.poker.model;

import org.sikuli.script.Region;

public class Table {

	private Integer numberOfPlayers;
	private Integer maxNumberOfPlayers;
	
	private Region cardsFlop;
	private Region cardTurn;
	private Region cardRiver;
	
	private Region totalPot;
	private Region currentPot;
	
	private Region handNumber;
	
	
	private Region region = null;
	
	public Integer getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(Integer numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public Integer getMaxNumberOfPlayers() {
		return maxNumberOfPlayers;
	}

	public void setMaxNumberOfPlayers(Integer maxNumberOfPlayers) {
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}


	
	
}
