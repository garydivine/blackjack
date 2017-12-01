package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Player {

	private int balance;
	private Hand hand;
	private int currentBet;

	public Player(int intialBalance) {
		this.balance = intialBalance;
		hand = new Hand();
	}
	
	public void addCardToHand(ArrayList<Card> deckArray, ArrayList<Card> discardedCards) {
		hand.addCardToHand(deckArray, discardedCards);
	}
	
	public void emptyHand() {
		hand.emptyHand();
	}
	
	public void placeBet(int betAmount) {
		this.currentBet = betAmount;
		balance = balance - betAmount;
	}
	
	public void loseBet() { 
		currentBet = 0;
	}
	
	public void winBetNoBlackjack() {
		balance = balance + (currentBet * 2);
		currentBet = 0;
	}
	
	public void winBetWithBlackjack() {
		balance = balance + (int)((double)(currentBet) * 1.5);
		currentBet = 0;
	}
	
	public void draw() {
		balance = balance + currentBet;
		currentBet = 0;
	}

	public int getBalance() {
		return balance;
	}

	public Hand getHand() {
		return hand;
	}

	public int getCurrentBet() {
		return currentBet;
	}

}
