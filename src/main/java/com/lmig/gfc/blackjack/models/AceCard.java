package com.lmig.gfc.blackjack.models;

public class AceCard extends Card{

	public AceCard(Suits suit) {
		super(suit);
	}

	@Override
	public String getFace() { 
		return "Ace";
	}

	@Override
	public int getValue() {
		return 11;
	}

}
