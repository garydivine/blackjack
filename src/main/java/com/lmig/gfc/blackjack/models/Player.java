package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Player {

	private Bank bank;
	private Hand hand;

	public Player(int intialbalance) {
		bank = new Bank(intialbalance);
		hand = new Hand();
	}
	
	public void addCardToHand(ArrayList<Card> deckArray) {
		hand.addCardToHand(deckArray);
		
	}

	public int getBalanceFromBank() {
		return bank.getBalance();
	}

	public Hand getHand() {
		return hand;
	}

}
