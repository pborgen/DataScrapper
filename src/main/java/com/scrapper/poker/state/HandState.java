package com.scrapper.poker.state;

import java.util.List;

import com.scrapper.poker.model.Player;

public class HandState {

	private Boolean isPrefold = null;
	private Integer numberOfPlayers = null;
	private List<Player> players = null;
	
	public Boolean getIsPrefold() {
		return isPrefold;
	}

	public void setIsPrefold(Boolean isPrefold) {
		this.isPrefold = isPrefold;
	}
}
