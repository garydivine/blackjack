package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;

import com.lmig.gfc.blackjack.models.Card.Suit;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();

	public Deck() {
		populateDeck();
		shuffleDeck();
	}

	private void populateDeck() {
		for (Suit suit : Suit.values()) {
			deck.add(new Card("2", suit.toString(), 2));
			deck.add(new Card("3", suit.toString(), 3));
			deck.add(new Card("4", suit.toString(), 4));
			deck.add(new Card("5", suit.toString(), 5));
			deck.add(new Card("6", suit.toString(), 6));
			deck.add(new Card("7", suit.toString(), 7));
			deck.add(new Card("8", suit.toString(), 8));
			deck.add(new Card("9", suit.toString(), 9));
			deck.add(new Card("10", suit.toString(), 10));
			deck.add(new Card("KING", suit.toString(), 10));
			deck.add(new Card("QUEEN", suit.toString(), 10));
			deck.add(new Card("JACK", suit.toString(), 10));
			deck.add(new Card("ACE", suit.toString(), 111));
		}

		// Print cards out to console for debugging purposes
		/*
		 * for (Card card: deck) { System.out.println(card.getName() + " of " +
		 * card.getSuit()); }
		 */
	}

	private void shuffleDeck() {
		Collections.shuffle(deck);

		// Print cards out to console for debugging purposes
		for (Card card : deck) {
			System.out.println(card.getbaseCardName() + " of " + card.getSuit());
		}
	}

}
