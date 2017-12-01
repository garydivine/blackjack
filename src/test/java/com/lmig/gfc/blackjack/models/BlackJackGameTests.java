package com.lmig.gfc.blackjack.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BlackJackGameTests {
	
	@Test
	public void playerWinsHandNoBlackjack_dealer_wins_with_blackjack() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new AceCard(Suits.CLUBS);
		Card playerCard1 = new NumberCard(Suits.DIAMONDS, 6);
		Card playerCard2 = new AceCard(Suits.SPADES);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

      // Act

      // Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(false);
	}
	
	@Test
	public void playerWinsHandNoBlackjack_dealer_wins_without_blackjack() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.DIAMONDS, 3);
		Card playerCard1 = new NumberCard(Suits.DIAMONDS, 6);
		Card playerCard2 = new NumberCard(Suits.DIAMONDS, 2);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

      // Act

      // Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(false);
	}
	
	@Test
	public void playerWinsHandNoBlackjack_player_wins_with_blackjack() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.DIAMONDS, 3);
		Card playerCard1 =new AceCard(Suits.SPADES);
		Card playerCard2 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

      // Act

      // Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(false);
	}
	
	@Test
	public void playerWinsHandNoBlackjack_player_wins_without_blackjack() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.DIAMONDS, 3);
		Card dealerCard3 = new AceCard(Suits.SPADES);
		Card playerCard1 = new FaceCard(Suits.CLUBS, Faces.KING);
		Card playerCard2 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getDealerHand().getHandArray().add(dealerCard3);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

      // Act

      // Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(true);
	}


}
