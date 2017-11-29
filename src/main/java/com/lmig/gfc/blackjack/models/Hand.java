package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> handArray;
	
	public Hand(){
		handArray = new ArrayList<Card>();
	}
	
	public void addCardToHand(ArrayList<Card> deck) {  
		Card card = deck.get(0);
		handArray.add(card);
		deck.remove(0);
	}
	
	public int getTotal() {
		int sum = 0;
		for (Card card: handArray) {
			sum += card.getValue();
		}
		return sum;
		
		// implement the Ace value logic in here
	}

	public ArrayList<Card> getHandArray() {
		return handArray;
	}
	
	
	
	
	
	

}
