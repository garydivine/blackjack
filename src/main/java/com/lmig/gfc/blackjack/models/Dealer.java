package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Dealer {
	
	private Hand hand;
	
	public Dealer() {
		hand = new Hand();
	}
	
	public void addCardToHand(ArrayList<Card> deckArray) {
		hand.addCardToHand(deckArray);
		
	}
	
	public void emptyDeck(ArrayList<Card> deckArray) {
		hand.emptyDeck(deckArray);
	}

	public Hand getHand() {
		return hand;
	}

}
