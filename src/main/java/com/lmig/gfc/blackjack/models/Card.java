package com.lmig.gfc.blackjack.models;

public class Card {

	private String baseCardName;
	private String suit;
	private int value;

	public Card(String baseCardName, String suit, int value) {
		this.baseCardName = baseCardName;
		this.value = value;
		this.suit = suit;
	}

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	public String getbaseCardName() {
		return baseCardName;
	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

}
