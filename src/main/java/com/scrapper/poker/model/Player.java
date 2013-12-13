package com.scrapper.poker.model;

import org.sikuli.script.Region;

public class Player {

	private Integer number = null;
	private Region regionDropDown;
	private Region regionNumber;
	private Region regionCards;
	private Region regionSymboleOfCards;
	
	private Region regionStack;
	private Region regionBetLocation;
	private Boolean isSittingOnLeftSideOfTable;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Region getRegionDropDown() {
		return regionDropDown;
	}
	public void setRegionDropDown(Region regionDropDown) {
		this.regionDropDown = regionDropDown;
	}
	public Region getRegionNumber() {
		return regionNumber;
	}
	public void setRegionNumber(Region regionNumber) {
		this.regionNumber = regionNumber;
	}
	public Region getRegionCards() {
		return regionCards;
	}
	public void setRegionCards(Region regionCards) {
		this.regionCards = regionCards;
	}
	public Region getRegionStack() {
		return regionStack;
	}
	public void setRegionStack(Region regionStack) {
		this.regionStack = regionStack;
	}
	public Region getRegionBetLocation() {
		return regionBetLocation;
	}
	public void setRegionBetLocation(Region regionBetLocation) {
		this.regionBetLocation = regionBetLocation;
	}
	public Boolean getIsSittingOnLeftSideOfTable() {
		return isSittingOnLeftSideOfTable;
	}
	public void setIsSittingOnLeftSideOfTable(Boolean isSittingOnLeftSideOfTable) {
		this.isSittingOnLeftSideOfTable = isSittingOnLeftSideOfTable;
	}
	public Region getRegionSymboleOfCards() {
		return regionSymboleOfCards;
	}
	public void setRegionSymboleOfCards(Region regionSymboleOfCards) {
		this.regionSymboleOfCards = regionSymboleOfCards;
	}


}
