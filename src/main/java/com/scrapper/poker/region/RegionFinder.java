package com.scrapper.poker.region;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;

import com.scrapper.poker.config.Config;
import com.scrapper.poker.image.ImageFinder;
import com.scrapper.poker.model.Player;
import com.scrapper.poker.model.Table;
import com.scrapper.poker.observer.PlayerCardFinderObserver;
import com.scrapper.poker.observer.PlayerDropdownFinderObserver;

public class RegionFinder {

	public List<Player> findPlayerRegions(Table table) {
		List<Player> players = initStaticPlayerRegions(table);
		
		players = initPlayerRegionsByObserving(players);
		
		return players;
	}
	
    /**
     * Start populating the Player objects.
     * Populate all the player region information that is static on the screen.
     * 
     * Example: The player number
     * 
     * @param table
     * @return List<Player>
     */
    private  List<Player> initStaticPlayerRegions(Table table) {

    	List<Player> players = new ArrayList<>();
    	
    	Region region = table.getRegion();
    	
    	int xCenterOfTable = region.getCenter().getX();
    	
    	List<ImageFinder> seats = ImageFinder.retreiveSeats();
    	
    	for (ImageFinder seat : seats) {
    		Pattern playerNumber = new Pattern();
    		playerNumber.setFilename(seat.imagePath());
        	
        	try {
				Match match = region.find(playerNumber);
				
				if (Config.activateStaticHighLighting &&
					Config.activateStaticHighLightingPlayerNumberr) {
					
					match.highlight();
				}
				
				
				if(match != null) {
					Location bottomLeft = match.getBottomLeft();
					int xBottomLeft = bottomLeft.getX();
					
					
					Region regionCenterOfCards = null;
					Boolean isSittingOnLeftSideOfTable = null;
					Player player = new Player();
					
//					/* Player drop down */
//					int xLeftDropdownRegion = 0;
//			    	int yLeftDropdownRegion = 0;
//			    	int wLeftDropdownRegion = 0;
//			    	int hLeftDropdownRegion = 0;
//			    	
//			    	/* center of player cards */
//					int xCardsCenterRegion = 0;
//					int yCardsCenterRegion = 0;
//					int wCardsCenterRegion = 0;
//					int hCardsCenterRegion = 0;
					
					/* card symbole region */
					int xCardsSymboleRegion = 0;
					int yCardsSymboleRegion = 0;
					int wCardsSymboleRegion = 0;
					int hCardsSymboleRegion = 0;
					
					/* Set the player number */
					player.setNumber(retrievePlayerNumber(seat.imagePath()));
					
					/* Are we to the left or right or center */
					if (xCenterOfTable - xBottomLeft > 0) {
						
						/* is left of center */
						isSittingOnLeftSideOfTable = true;
						
						/* Find left corner */
						int xBottonCenter = match.getCenter().getX();
						
//						/* We create a region around the left side of the drop down 
//						 * Going to use this to match the left side of the drop down
//						 */
//						xLeftDropdownRegion = xBottonCenter - 20;
//				    	yLeftDropdownRegion = match.getBottomLeft().getY() + 6;
//				    	wLeftDropdownRegion = 30;
//				    	hLeftDropdownRegion = 20;
//				    	
//				    	Region regionLeftSideDropdown =
//								new Region(xLeftDropdownRegion, yLeftDropdownRegion, wLeftDropdownRegion, hLeftDropdownRegion);
//				    	
//						xCardsCenterRegion = xBottonCenter + 30;
//						yCardsCenterRegion = match.getBottomLeft().getY() - 40;
//						wCardsCenterRegion = 25;
//						hCardsCenterRegion = 20;
						
						/* card symbole region */
						xCardsSymboleRegion = xBottonCenter + 10;
						yCardsSymboleRegion = match.getBottomLeft().getY() - 40;
						wCardsSymboleRegion = 30;
						hCardsSymboleRegion = 30;
						
						//player.setRegionLeftSideDropDown(regionLeftSideDropdown);
						
//						if (Config.activateStaticHighLighting) {
//							if (Config.activateStaticHighLightingDropdownCorner) {
//								regionLeftSideDropdown.highlight();
//							}
//						}

					} else {
						/* Is right of center */
						isSittingOnLeftSideOfTable = false;
						
						/* Find left corner */
						int xBottonCenter = match.getCenter().getX();
						
//						/* We create a region around the left side of the drop down 
//						 * Going to use this to match the left side of the drop down
//						 */
//						xLeftDropdownRegion = xBottonCenter;
//				    	yLeftDropdownRegion = match.getBottomLeft().getY() + 6 ;
//				    	wLeftDropdownRegion = 30;
//				    	hLeftDropdownRegion = 20;
//				    	
//				    	Region regionRightSideDropdown =
//								new Region(xLeftDropdownRegion, yLeftDropdownRegion, wLeftDropdownRegion, hLeftDropdownRegion);
//				    	
//						xCardsCenterRegion = xBottonCenter - 75;
//						yCardsCenterRegion = match.getBottomLeft().getY() - 42;
//						wCardsCenterRegion = 25;
//						hCardsCenterRegion = 20;

						/* card symbole region */
						xCardsSymboleRegion = xBottonCenter - 75;
						yCardsSymboleRegion = match.getBottomLeft().getY() - 42;
						wCardsSymboleRegion = 30;
						hCardsSymboleRegion = 30;
						
//						player.setRegionRightSideDropDown(regionRightSideDropdown);
//						
//						if (Config.activateStaticHighLighting) {
//							if (Config.activateStaticHighLightingDropdownCorner) {
//								regionRightSideDropdown.highlight();
//							}
//						}
					}
			    	
					Region regionCardSymbole =
							new Region(xCardsSymboleRegion, yCardsSymboleRegion, wCardsSymboleRegion, hCardsSymboleRegion);
			    	
				
					//regionCenterOfCards = new Region(xCardsCenterRegion, yCardsCenterRegion, wCardsCenterRegion, hCardsCenterRegion);
					
					if (Config.activateStaticHighLighting) {
//						if (Config.activateStaticHighLightingHoleCardCenter) {
//							regionCenterOfCards.highlight();	
//						}
						
						if (Config.activateStaticHighLightingPlayerCardSymbole) {
							regionCardSymbole.highlight();
						}
						
					}
					
			    	player.setRegionNumber(match);
			    	player.setIsSittingOnLeftSideOfTable(isSittingOnLeftSideOfTable);
			    	player.setRegionSymboleOfCards(regionCardSymbole);
			    	
			    	players.add(player);
				}
				
			} catch (FindFailed e) {
				System.out.println("Could not find player with number = " + seat.imagePath());
				e.printStackTrace();
			}
    	}
    	
    	return players;
    }
    
	/**
	 * Populate all regions associated with a player
	 * 
	 * @param players
	 * @return List<Player>
	 */
    private List<Player> initPlayerRegionsByObserving(List<Player> players) {
    	
    	players = findHoleCardLocation(players);
    	
    	return players;
    }
    
    private List<Player> findHoleCardLocation(List<Player> players) {
    	
    	for (Player player : players) {
    		Region region = player.getRegionSymboleOfCards();
    		
    		Pattern pattern = new Pattern();
    		
    		pattern.setFilename(ImageFinder.CARD_SYMBOLE_BASE.imagePath());
    		
    		PlayerCardFinderObserver playerCardCenterFinderObserver = new PlayerCardFinderObserver(player);
    		
    		region.onAppear(pattern, playerCardCenterFinderObserver);
    		region.observeInBackground(320);
    	}
    	
    	return players;
    }
    
    
//    /**
//     * Find the player dropdown region
//     * 
//     * @param players
//     * @return List<Player>
//     */
//    private List<Player> findDropdownRegions(List<Player> players) {
//    	List<PlayerDropdownFinderObserver> playerDropdownFinderObserverList = new ArrayList<>();
//    	
//    	for (Player player : players) {
//    		Region region = null;
//    		
//    		Pattern pattern = new Pattern();
//    		PlayerDropdownFinderObserver playerDropdownFinderObserver = new PlayerDropdownFinderObserver(player);
//			playerDropdownFinderObserverList.add(playerDropdownFinderObserver);
//        	
//    		/* Get the left or right side of the dropdown*/
//    		if (player.getIsSittingOnLeftSideOfTable()) {
//    			region = player.getRegionLeftSideDropDown();
//    			
//    			pattern.setFilename(ImageFinder.ACTION_WINDOW_LEFT.imagePath());
//    		} else {
//    			region = player.getRegionRightSideDropDown();
//    			
//    			pattern.setFilename(ImageFinder.ACTION_WINDOW_RIGHT.imagePath());
//    		}
//    		
//    		if (region == null) {
//    			int x = 0;
//    			x++;
//    		}
//    		
//    		region.onAppear(pattern, playerDropdownFinderObserver);
//    		region.observeInBackground(120);
//    		
//    	}
//    	
//    	return players;
//    }
    
    
    /**
     * Get the player number from the image path.
     * Image end in the player number
     * 
     * @param imagePath
     * @return Integer
     */
    private Integer retrievePlayerNumber(String imagePath) {
    	
    	imagePath = imagePath.substring(0, imagePath.indexOf("."));
    	
    	/* Image Path end in _Number*/
    	int underscore = imagePath.indexOf("_");
    	String numberString = imagePath.substring(underscore + 1);
    	
    	return Integer.getInteger(numberString);
    }
}
