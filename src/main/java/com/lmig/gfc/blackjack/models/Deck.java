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
	}

	private void shuffleDeck() {
		Collections.shuffle(deckArray);
	}

	public Card removeCardFromDeck() {
		Card removedCard;

		// making sure we get a new card off the deck
		try {
			removedCard = deckArray.remove(0);
			discardedDeckArray.add(removedCard);
		} catch (IndexOutOfBoundsException ioobe) {
			deckArray.addAll(discardedDeckArray);
			shuffleDeck();
			discardedDeckArray.clear();
			removedCard = deckArray.remove(0);
			discardedDeckArray.add(removedCard);
		}
		return removedCard;
	}

	public ArrayList<Card> getDeck() {
		return deckArray;
	}

	public ArrayList<Card> getDiscardedDeckArray() {
		return discardedDeckArray;
	}

}
