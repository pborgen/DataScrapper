package com.scrapper.poker.observer;

import org.sikuli.script.SikuliEventAppear;
import org.sikuli.script.SikuliEventChange;
import org.sikuli.script.SikuliEventObserver;
import org.sikuli.script.SikuliEventVanish;

import com.scrapper.poker.config.Config;
import com.scrapper.poker.model.Player;

public class PlayerDropdownFinderObserver implements SikuliEventObserver {

	private boolean hasValue = false;
	private Player player = null;
	
	public PlayerDropdownFinderObserver(Player player) {
		this.player = player;
	}
	
	@Override
	public void targetAppeared(SikuliEventAppear e) {
		System.out.println("it hapened!!!! - targetAppeared");
		
		setHasValue(true);
		
		
		if (Config.activateDynamiccHighLighting &&
			Config.activateDynamiccHighLightingPlayerDropdownFinderObserver) {
			
			e.match.highlight();
		}
		
	}

	/**
	 * Not used
	 */
	@Override
	public void targetVanished(SikuliEventVanish e) {
		System.out.println("it hapened!!!! - targetVanished");
		
	}

	/**
	 * Not used
	 */
	@Override
	public void targetChanged(SikuliEventChange e) {
		System.out.println("it hapened!!!! - targetChanged");
		
	}

	public boolean isHasValue() {
		return hasValue;
	}

	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
