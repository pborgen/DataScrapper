package com.scrapper.poker.image;

import java.util.ArrayList;
import java.util.List;

public enum ImageFinder {
	ACTION_BET("resource/action_bet.png"),
	ACTION_CHECK("resource/action_check.png"),
	ACTION_FOLD("resource/action_fold.png"),
	ACTION_NEWLY_SEATED("resource/action_newly_seated.png"),
	ACTION_POST_BB("resource/action_post_bb.png"),
	ACTION_POST_SB("resource/action_post_sb.png"),
	ACTION_WINDOW_LEFT("resource/action_window_left.png"),
	ACTION_WINDOW_RIGHT("resource/action_window_right.png"),
	BOARD_EMPTY("resource/board_empty.png"),
	SEAT_1("resource/seat_1.png"),
	SEAT_2("resource/seat_2.png"),
	SEAT_3("resource/seat_3.png"),
	SEAT_4("resource/seat_4.png"),
	SEAT_5("resource/seat_5.png"),
	SEAT_6("resource/seat_6.png"),
	SEAT_7("resource/seat_7.png"),
	SEAT_8("resource/seat_8.png"),
	SEAT_9("resource/seat_9.png"),
	CARD_HIDDEN_CENTER("resource/card_hidden_center.png"),
	CARD_SYMBOLE_BASE("resource/card_symbole_base.png"),
	BASE("resource/base.png");
	
	String imagePath;
	
	ImageFinder(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String imagePath() {
		return this.imagePath;
	}
	
	public static List<ImageFinder> retreiveSeats() {
		List<ImageFinder> seats = new ArrayList<>();
	
		seats.add(SEAT_1);
		seats.add(SEAT_2);
		seats.add(SEAT_3);
		seats.add(SEAT_4);
		seats.add(SEAT_5);
		seats.add(SEAT_6);
//		seats.add(SEAT_7);
//		seats.add(SEAT_8);
//		seats.add(SEAT_9);
		
		return seats;
	}
	
}
