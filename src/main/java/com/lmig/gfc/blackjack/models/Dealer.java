package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Dealer {

	private Hand hand;

	public Dealer() {
		hand = new Hand();
	}

	public void addCardToHand(ArrayList<Card> deckArray, ArrayList<Card> discardedCards) {
		hand.addCardToHand(deckArray, discardedCards);

	}

	public void emptyHand() {
		hand.emptyHand();
	}

	public Hand getHand() {
		return hand;
	}

}
