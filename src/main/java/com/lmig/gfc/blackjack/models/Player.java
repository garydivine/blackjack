package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Player {

	private int balance;
	private Hand hand;

	public Player(int intialBalance) {
		this.balance = intialBalance;
		hand = new Hand();
	}
	
	public void addCardToHand(ArrayList<Card> deckArray) {
		hand.addCardToHand(deckArray);
	}
	
	public void placeBet(int betAmount) {
		balance -= betAmount;
	}

	public int getBalance() {
		return balance;
	}

	public Hand getHand() {
		return hand;
	}

}
