package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Dealer {

	private Hand hand;

	public Dealer() {
		hand = new Hand();
	}

	public void addCardToHand(Deck deck) {
		hand.addCardToHand(deck);
	}

	public void emptyHand() {
		hand.emptyHand();
	}

	public Hand getHand() {
		return hand;
	}

}
