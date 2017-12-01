package com.lmig.gfc.blackjack.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class DeckTests {
	
	@Test
  public void removeCardFromDeck_need_to_use_discarded_deck() {
      // Arrange
		Card card = new AceCard(Suits.CLUBS);
		Deck deck = new Deck();
		deck.getDeck().clear();
		deck.getDiscardedDeckArray().add(card);

      // Act
		deck.removeCardFromDeck();

      // Assert
      assertThat(deck.getDeck()).hasSize(0);
      assertThat(deck.getDiscardedDeckArray()).hasSize(1);
      assertThat(deck.getDiscardedDeckArray()).contains(card);
  }
	
	@Test
	  public void removeCardFromDeck_does_not_need_to_use_discarded_deck() {
	      // Arrange
			Card card = new AceCard(Suits.CLUBS);
			Deck deck = new Deck();
			deck.getDeck().clear();
			deck.getDeck().add(card);

	      // Act
			deck.removeCardFromDeck();

	      // Assert
	      assertThat(deck.getDeck()).hasSize(0);
	      assertThat(deck.getDiscardedDeckArray()).hasSize(1);
	      assertThat(deck.getDiscardedDeckArray()).contains(card);
	  }

}
