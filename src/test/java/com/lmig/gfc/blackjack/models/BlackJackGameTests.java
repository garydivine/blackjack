package com.lmig.gfc.blackjack.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BlackJackGameTests {

	@Test
	public void dealer_wins_hand_with_blackjack() {
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
		assertThat(bjg.playerWinsHandWithBlackjack()).isEqualTo(false);
		assertThat(bjg.bothHaveBlackjacks()).isEqualTo(false);
		assertThat(bjg.standardDraw()).isEqualTo(false);
		assertThat(bjg.dealerWinsHand()).isEqualTo(true);

	}

	@Test
	public void dealer_wins_hand_without_blackjack() {
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
		assertThat(bjg.playerWinsHandWithBlackjack()).isEqualTo(false);
		assertThat(bjg.bothHaveBlackjacks()).isEqualTo(false);
		assertThat(bjg.standardDraw()).isEqualTo(false);
		assertThat(bjg.dealerWinsHand()).isEqualTo(true);
	}

	@Test
	public void player_wins_hand_with_blackjack() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.DIAMONDS, 3);
		Card playerCard1 = new AceCard(Suits.SPADES);
		Card playerCard2 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

		// Act

		// Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(false);
		assertThat(bjg.playerWinsHandWithBlackjack()).isEqualTo(true);
		assertThat(bjg.bothHaveBlackjacks()).isEqualTo(false);
		assertThat(bjg.standardDraw()).isEqualTo(false);
		assertThat(bjg.dealerWinsHand()).isEqualTo(false);
	}

	@Test
	public void player_wins_hand_without_blackjack() {
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
		assertThat(bjg.playerWinsHandWithBlackjack()).isEqualTo(false);
		assertThat(bjg.bothHaveBlackjacks()).isEqualTo(false);
		assertThat(bjg.standardDraw()).isEqualTo(false);
		assertThat(bjg.dealerWinsHand()).isEqualTo(false);
	}

	@Test
	public void draw_without_blackjacks() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.DIAMONDS, 3);
		Card dealerCard3 = new NumberCard(Suits.DIAMONDS, 7);
		Card playerCard1 = new FaceCard(Suits.CLUBS, Faces.KING);
		Card playerCard2 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getDealerHand().getHandArray().add(dealerCard3);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

		// Act

		// Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(false);
		assertThat(bjg.playerWinsHandWithBlackjack()).isEqualTo(false);
		assertThat(bjg.bothHaveBlackjacks()).isEqualTo(false);
		assertThat(bjg.standardDraw()).isEqualTo(true);
		assertThat(bjg.dealerWinsHand()).isEqualTo(false);
	}

	@Test
	public void draw_with_blackjacks() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new AceCard(Suits.SPADES);
		Card playerCard1 = new AceCard(Suits.CLUBS);
		Card playerCard2 = new FaceCard(Suits.DIAMONDS, Faces.JACK);
		bjg.getDealerHand().getHandArray().add(dealerCard1);
		bjg.getDealerHand().getHandArray().add(dealerCard2);
		bjg.getPlayerHand().getHandArray().add(playerCard1);
		bjg.getPlayerHand().getHandArray().add(playerCard2);

		// Act

		// Assert
		assertThat(bjg.playerWinsHandNoBlackjack()).isEqualTo(false);
		assertThat(bjg.playerWinsHandWithBlackjack()).isEqualTo(false);
		assertThat(bjg.bothHaveBlackjacks()).isEqualTo(true);
		assertThat(bjg.standardDraw()).isEqualTo(false);
		assertThat(bjg.dealerWinsHand()).isEqualTo(false);
	}

	@Test
	public void isGameOver_draw() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		bjg.beginPlayActions(500);
		bjg.getAllDealerCards().clear();
		bjg.getAllPlayersCards().clear();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new FaceCard(Suits.DIAMONDS, Faces.JACK);
		Card playerCard1 = new FaceCard(Suits.DIAMONDS, Faces.QUEEN);
		Card playerCard2 = new FaceCard(Suits.CLUBS, Faces.JACK);
		bjg.getAllDealerCards().add(dealerCard1);
		bjg.getAllDealerCards().add(dealerCard2);
		bjg.getAllPlayersCards().add(playerCard1);
		bjg.getAllPlayersCards().add(playerCard2);

		// Act

		// Assert
		assertThat(bjg.isGameOver()).isEqualTo(false);

	}

	@Test
	public void isGameOver_dealer_wins() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		bjg.beginPlayActions(500);
		bjg.getAllDealerCards().clear();
		bjg.getAllPlayersCards().clear();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.CLUBS, 8);
		Card playerCard1 = new FaceCard(Suits.DIAMONDS, Faces.QUEEN);
		Card playerCard2 = new NumberCard(Suits.CLUBS, 6);
		bjg.getAllDealerCards().add(dealerCard1);
		bjg.getAllDealerCards().add(dealerCard2);
		bjg.getAllPlayersCards().add(playerCard1);
		bjg.getAllPlayersCards().add(playerCard2);

		// Act
		bjg.determinePayOut();

		// Assert
		assertThat(bjg.isGameOver()).isEqualTo(true);

	}

	@Test
	public void isGameOver_player_wins() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		bjg.beginPlayActions(500);
		bjg.getAllDealerCards().clear();
		bjg.getAllPlayersCards().clear();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.CLUBS, 8);
		Card playerCard1 = new NumberCard(Suits.CLUBS, 10);
		Card playerCard2 = new NumberCard(Suits.CLUBS, 9);
		bjg.getAllDealerCards().add(dealerCard1);
		bjg.getAllDealerCards().add(dealerCard2);
		bjg.getAllPlayersCards().add(playerCard1);
		bjg.getAllPlayersCards().add(playerCard2);

		// Act
		bjg.determinePayOut();

		// Assert
		assertThat(bjg.isGameOver()).isEqualTo(false);

	}

	@Test
	public void isGameOver_game_not_over_yet() {
		// Arrange
		BlackJackGame bjg = new BlackJackGame();
		bjg.beginPlayActions(300);
		bjg.getAllDealerCards().clear();
		bjg.getAllPlayersCards().clear();
		Card dealerCard1 = new FaceCard(Suits.DIAMONDS, Faces.KING);
		Card dealerCard2 = new NumberCard(Suits.CLUBS, 8);
		Card playerCard1 = new NumberCard(Suits.CLUBS, 10);
		Card playerCard2 = new NumberCard(Suits.CLUBS, 9);
		bjg.getAllDealerCards().add(dealerCard1);
		bjg.getAllDealerCards().add(dealerCard2);
		bjg.getAllPlayersCards().add(playerCard1);
		bjg.getAllPlayersCards().add(playerCard2);

		// Act
		bjg.determinePayOut();

		// Assert
		assertThat(bjg.isGameOver()).isEqualTo(false);

	}

}
