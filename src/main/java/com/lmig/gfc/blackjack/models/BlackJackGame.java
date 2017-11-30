package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class BlackJackGame {

	private Deck deck;
	private Dealer dealer;
	private Player player;
	private ArrayList<Card> deckArray;
	

	public BlackJackGame() {
		deck = new Deck();
		dealer = new Dealer();
		player = new Player(500);
		deckArray = deck.getDeck();
	}
	
	public void dealInitialCards() {
		player.addCardToHand(deckArray);
		player.addCardToHand(deckArray);
		dealer.addCardToHand(deckArray);
		dealer.addCardToHand(deckArray); 
	}
	
	public void placeBet(int betAmount) {
		player.placeBet(betAmount);
	}
	
	public void hit() {
		player.addCardToHand(deckArray);
	}
	
	public void stand() {
		// add logic
	}
	
	public ArrayList<Card> getPlayersHand() {
		return player.getHand().getHandArray();
	}
	
	public Card getDealerVisibleCard() {
		return dealer.getHand().getHandArray().get(0);
	}

	public int getPlayerBalance() {
		return player.getBalance();
	}
	
}
