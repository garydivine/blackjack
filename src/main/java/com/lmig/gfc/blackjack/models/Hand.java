package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private ArrayList<Card> handArray;
	
	public Hand(){
		handArray = new ArrayList<Card>();
	}
	
	public void addCardToHand(ArrayList<Card> deck, ArrayList<Card> discardedCards) {  
		Card card = deck.get(0);
		handArray.add(card);
		try {
			Card removedCard = deck.remove(0);
		} catch (IndexOutOfBoundsException ioobe) {
			Collections.shuffle(discardedCards);
			deck.addAll(discardedCards);
			discardedCards.clear();
			Card removedCard = deck.remove(0);
			discardedCards.add(removedCard);
			
		}
	}
	
	public void emptyHand() {  
		handArray.clear();
	}
	
	public int getTotal() {
		ArrayList<Card> aceArray = new ArrayList<Card>();
		ArrayList<Card> nonAceArray = new ArrayList<Card>();
		
		// loop to populate aceArray and nonAceArray
		for (Card card : handArray) {
			if (card.getFace() == "ACE") {
				aceArray.add(card);
			} else {
				nonAceArray.add(card);
			}
		}
		
		// determining sum of nonAceArray
		int sum = 0;
		for (Card card: nonAceArray) {
			sum += card.getValue();
		}
		
		// establishing what the values for be for Aces and adding to sum
		if (!aceArray.isEmpty()) {
			for (Card ace: aceArray) {
				if (sum + 11 > 21) {
					sum = sum + 1;
				} else {
					sum = sum + 11;
				}
				
			}
		}

		return sum; 
	}
	
	public boolean isBust() {
		return getTotal() > 21;
	}
	
	public boolean isBlackjack() {
		return ((handArray.get(0).getFace() == "ACE" && handArray.get(1).getValue() == 10) || (handArray.get(0).getValue() == 10 && handArray.get(1).getFace() == "ACE"));
	}

	public ArrayList<Card> getHandArray() {
		return handArray;
	}
	
	
	
	
	
	

}
