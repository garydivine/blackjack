package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck { 

	private ArrayList<Card> deckArray = new ArrayList<Card>();
	private ArrayList<Card> discardedDeckArray = new ArrayList<Card>();;

	public Deck() {
		populateDeck();
		shuffleDeck();
	}

	private void populateDeck() {
		// Add Face Cards
		for (Faces face : Faces.values()) {
			for (Suits suit : Suits.values()) {
				deckArray.add(new FaceCard(suit, face));
			}
		}

		// Add Ace Cards
		for (Suits suit : Suits.values()) {
			deckArray.add(new AceCard(suit));
		}

		// Add Number Cards
		for (int i = 2; i <= 10; i += 1) {
			for (Suits suit : Suits.values()) {
				deckArray.add(new NumberCard(suit, i));
			}
		}

		/*
		 * // Print cards out to console for debugging purposes for (Card card :
		 * deckArray) { System.out.println(card.getFace() + " of " + card.getSuit()); }
		 */
	}

	private void shuffleDeck() {
		Collections.shuffle(deckArray);

		/*
		 * // Print cards out to console for debugging purposes for (Card card :
		 * deckArray) { System.out.println(card.getFace() + " of " + card.getSuit()); }
		 */
	}

	public ArrayList<Card> getDeck() {
		return deckArray;
	}

	public ArrayList<Card> getDiscardedDeckArray() {
		return discardedDeckArray;
	}

}
