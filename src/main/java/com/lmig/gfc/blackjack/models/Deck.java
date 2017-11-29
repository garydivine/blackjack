package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deckArray = new ArrayList<Card>();

	public Deck() {
		populateDeck();
		//shuffleDeck();
	}
	
	private void populateDeck() {
		// Add Face Cards
		for (Faces face : Faces.values()) {
			for (Suits suit : Suits.values()) {
				deckArray.add(new FaceCard(suit, face));
			}
		}
		
		// Add Ace Cards
		
		// Add Number Cards
		
		
		// Print cards out to console for debugging purposes
		for (Card card : deckArray) {
			System.out.println(card.getbaseCardName() + " of " + card.getSuit());
		}
	}
		

//	Rework since we refactored
//	private void populateDeck() {
//		for (Suits suit : Suits.values()) {
//			deckArray.add(new Card("2", suit.toString(), 2));
//			deckArray.add(new Card("3", suit.toString(), 3));
//			deckArray.add(new Card("4", suit.toString(), 4));
//			deckArray.add(new Card("5", suit.toString(), 5));
//			deckArray.add(new Card("6", suit.toString(), 6));
//			deckArray.add(new Card("7", suit.toString(), 7));
//			deckArray.add(new Card("8", suit.toString(), 8));
//			deckArray.add(new Card("9", suit.toString(), 9));
//			deckArray.add(new Card("10", suit.toString(), 10));
//			deckArray.add(new Card("KING", suit.toString(), 10));
//			deckArray.add(new Card("QUEEN", suit.toString(), 10));
//			deckArray.add(new Card("JACK", suit.toString(), 10));
//			deckArray.add(new Card("ACE", suit.toString(), 111));
//		}

		// Print cards out to console for debugging purposes
		/*
		 * for (Card card: deckArray) { System.out.println(card.getName() + " of " +
		 * card.getSuit()); }
		 */
//	}

	private void shuffleDeck() {
		Collections.shuffle(deckArray);

		// Print cards out to console for debugging purposes
		for (Card card : deckArray) {
			System.out.println(card.getbaseCardName() + " of " + card.getSuit());
		}
	}

	public ArrayList<Card> getDeck() {
		return deckArray;
	}

}
