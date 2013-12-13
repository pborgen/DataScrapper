package com.scrapper.poker;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.scrapper.poker.config.Config;
import com.scrapper.poker.image.ImageFinder;
import com.scrapper.poker.model.Player;
import com.scrapper.poker.model.Table;
import com.scrapper.poker.observer.BoardEmptyObserver;
import com.scrapper.poker.observer.PlayerDropdownFinderObserver;
import com.scrapper.poker.region.RegionFinder;

public class TableHelper {

	private Table table = null;
	private List<Region> observedRegions = new ArrayList<>();
	private RegionFinder regionFinder = new RegionFinder();
	
	
	public void addActionObserver()  {
    	
    	Pattern base = new Pattern();
    	base.setFilename(ImageFinder.BOARD_EMPTY.imagePath());
    	
    	
    	Region region = retrieveTable();
    	
    	/* Create the table */
    	setTable(new Table());
    	getTable().setRegion(region);
    	
    	getTable().setRegion(region);
    	
    	
    	getTable().getRegion().highlight();
    	
    	getTable().getRegion().onAppear(base, new BoardEmptyObserver());
    	getTable().getRegion().onVanish(base, new BoardEmptyObserver());
    	
    	getTable().getRegion().observe(Double.MAX_VALUE);
    	
    	
    	/* Add obserser to all players action dropdown */
    	List<Player> players = regionFinder.findPlayerRegions(getTable());
    	
    	int x = 0;
    	x++;
    	/* Hand Start (Look for SB flag) */
    	
    	
    	/* Players at start of hand */
    	
    	/* order of players */
    	
    	/* SB */
    	
    	/* BB */
    	
    	/* Flop */
    	
    	/* Turn */
    	
    	/* River */
    	
    	/* Check */
    	
    	/* Bet */
    	
    	/* Call */
    	
    	/* Fold */
    	
    	/* All in */
    	
    	/* Hand end */
    	
    	System.out.println("End -- addActionObserver");
    }
    
	
	/**
	 * Get the number of players
	 * 
	 * @return int
	 */
    private int numberOfPlayers() {
    	
    	Screen screen = new Screen();
    	
    	int playersFound = 0;
    	
    	List<ImageFinder> seats = ImageFinder.retreiveSeats();
    	
    	for (ImageFinder seat : seats) {
    		Pattern base = new Pattern();
        	base.setFilename(seat.imagePath());
        	
        	try {
				Match match = screen.find(base);
				
				if(match != null) {
					playersFound++;
				}
				
			} catch (FindFailed e) {
				e.printStackTrace();
			}
    	}
    	
    	return playersFound;
    }
    
    private void gatherPlayerInfo() {
    	
    }
    
    /**
     * Populate all player regions where a observation is nessary 
     * 
     * Example: The Player card region. The Player dropdown region.
     * 
     * 
     * @param players
     * @return List<Player> 
     */

    

    
    /**
     * Get the table
     * 
     * @return Region
     */
    private Region retrieveTable() {
    	Region region = null;
    	
    	Screen screen = new Screen();
    	
    	Pattern base = new Pattern();
    	base.setFilename(ImageFinder.BASE.imagePath());
    	
    	Match match = null;
    	
    	try {
			match = screen.find(base);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
    	
    	Location location = match.getTarget();
    	int x = location.getX() - 595;
    	int y = location.getY() - 60;
    	int w = 0  + 635;
    	int h = 0  + 470;
    	
    	region = new Region(x, y, w, h);
    	
    	
    	region.highlight();
    	
    	return region;
    }
    
    public Table getTable() {
		return table;
	}


	public void setTable(Table table) {
		this.table = table;
	}
}
