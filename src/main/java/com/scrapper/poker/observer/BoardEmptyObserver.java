package com.scrapper.poker.observer;

import org.sikuli.script.SikuliEventAppear;
import org.sikuli.script.SikuliEventChange;
import org.sikuli.script.SikuliEventObserver;
import org.sikuli.script.SikuliEventVanish;

public class BoardEmptyObserver implements SikuliEventObserver {

	@Override
	public void targetAppeared(SikuliEventAppear e) {
		System.out.println("it hapened!!!! - targetAppeared");
		
	}

	@Override
	public void targetVanished(SikuliEventVanish e) {
		System.out.println("it hapened!!!! - targetVanished");
		
	}

	@Override
	public void targetChanged(SikuliEventChange e) {
		System.out.println("it hapened!!!! - targetChanged");
		
	}

}
