package com.scrapper.poker.observer;

import org.sikuli.script.Region;
import org.sikuli.script.SikuliEventAppear;
import org.sikuli.script.SikuliEventChange;
import org.sikuli.script.SikuliEventObserver;
import org.sikuli.script.SikuliEventVanish;

import com.scrapper.poker.config.Config;
import com.scrapper.poker.model.Player;

public class PlayerCardFinderObserver implements SikuliEventObserver {

	private Player player = null;
	
	public PlayerCardFinderObserver(Player player) {
		this.player = player;
	}
	
	@Override
	public void targetAppeared(SikuliEventAppear e) {
		System.out.println("it hapened!!!! - PlayerCardFinderObserver.targetAppeared");
		
		int xMatch = e.match.getX();
		int yMatch = e.match.getY();
		
		
		int x = xMatch - 35;
		int y = yMatch + 35;
		int w = 120;
		int h = 20;
		
		Region dropdown = new Region(x, y, w, h);
		player.setRegionDropDown(dropdown);
		
		if(Config.activateDynamiccHighLighting ) {
			
		   if (Config.activateDynamiccHighLightingPlayerCardFinderObserver) {
			   e.match.highlight();
		   }
		
		   if (Config.activateDynamiccHighLightingDropDown) {
			   dropdown.highlight();
		   }
		   int ee = 0;
		   ee++;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
