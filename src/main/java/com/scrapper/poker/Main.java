package com.scrapper.poker;

import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.scrapper.poker.image.ImageFinder;

public class Main implements Runnable {
	private static int quit = 0;
	
	
	public void run(){  
        String msg = "";
        
        TableHelper tableHelper = new TableHelper();
        tableHelper.addActionObserver();
        

        
        while (true){  
        	try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (msg.equals("Q")) {
            	quit=1;
            	break;
            }
            
            //System.out.println("hello buddy2"); 
        }  
    }  
	
    public static void main(String[] args) throws InterruptedException {
    	
    	
    	Thread mainThread = new Thread(new Main());  
    	mainThread.start();
    	
        //Screen s = new Screen();
        //try {
        	//Pattern base = new Pattern();
        	//base.setFilename("resource/base.png");
        	
        	//Match match = s.find(base);
                //s.click("resource/board_empty.png", 0);
               // s.wait("imgs/spotlight-input.png");
                //s.type(null, "hello world\n", 0);
        	int x = 0;
        	x++;
        	
        	TableHelper tableHelper = new TableHelper();
        	
        	//System.out.println(tableHelper.numberOfPlayers());
        	
        //}
        //catch(FindFailed e){
         //       e.printStackTrace();
        //}
        	
        //boolean keepRunning = true;
        
        //tableHelper.addActionObserver();
        
        while(true) {
        	Thread.sleep(10);  
        	
            if(quit==1) {
            	break;  
            }
            
           // System.out.println("hello buddy-------------------------------------"); 
        }
        	

    }

}
