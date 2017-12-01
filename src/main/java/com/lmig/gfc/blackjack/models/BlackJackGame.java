package com.lmig.gfc.blackjack.models;

import java.util.ArrayList;  

public class BlackJackGame {

	private Deck deck;
	private Dealer dealer;
	private Player player;
	private boolean handManuallyStopped;

	public BlackJackGame() {
		deck = new Deck();
		dealer = new Dealer();
		player = new Player(500);
	}

	public void beginPlayActions(int betAmount) {
		player.placeBet(betAmount);
		dealInitialCards();
		checkForBlackjacks();
	}

	public void dealInitialCards() {
		player.addCardToHand(deck);
		player.addCardToHand(deck);
		dealer.addCardToHand(deck);
		dealer.addCardToHand(deck);
	}

	public void checkForBlackjacks() {
		if (player.getHand().isBlackjack() || dealer.getHand().isBlackjack() || bothHaveBlackjacks()) {
			handManuallyStopped = true;
			payOut();
		}
	}

	public void continueGame() {
		handManuallyStopped = false;
		player.emptyHand();
		dealer.emptyHand();
	}

	// conditionally evaluate the payout
	public void payOut() {
		if (stopHand() && dealerWinsHand()) {
			player.loseBet();
		} else if (stopHand() && playerWinsHandNoBlackjack()) {
			player.winBetNoBlackjack();
		} else if (stopHand() && playerWinsHandWithBlackjack()) {
			player.winBetWithBlackjack();
		} else if (bothHaveBlackjacks() || standardDraw()) {
			player.draw();
		}
	}

	// stop hand if either participant busts or stop is forced
	public boolean stopHand() {
		return (player.getHand().isBust() || dealer.getHand().isBust() || handManuallyStopped);
	}

	// player wins (without Blackjack) if dealer busts or value is higher than
	// the dealer's
	public boolean playerWinsHandNoBlackjack() {
		return ((dealer.getHand().isBust()) || (player.getHand().getTotal() > dealer.getHand().getTotal()
				&& !player.getHand().isBust() && !player.getHand().isBlackjack()));
	}

	// player wins (with Blackjack) when they have a blackjack and dealer doesn't
	public boolean playerWinsHandWithBlackjack() {
		return (player.getHand().isBlackjack() && !dealer.getHand().isBlackjack());
	}

	public boolean bothHaveBlackjacks() {
		return (player.getHand().isBlackjack() && dealer.getHand().isBlackjack());
	}

	public boolean standardDraw() {
		return (player.getHand().getTotal() == dealer.getHand().getTotal());
	}
	
	// dealer wins if all the other conditions are not met
	public boolean dealerWinsHand() {
		return (!playerWinsHandNoBlackjack() && !playerWinsHandWithBlackjack() && !bothHaveBlackjacks()
				&& !standardDraw()); 
	}

	// game is over when the player has no more money and they have lost their last hand
	public boolean isGameOver() { 
		return (player.getBalance() == 0 && player.getCurrentBet() == 0);
	} 

	public void hit() {
		player.addCardToHand(deck);
		payOut();
	}

	public void stand() {
		while (dealer.getHand().getTotal() <= 16) {
			dealer.addCardToHand(deck);
		}
		handManuallyStopped = true;
		payOut();
	}

	public ArrayList<Card> getPlayersCards() {
		return player.getHand().getHandArray();
	}

	public Card getDealerVisibleCard() {
		return dealer.getHand().getHandArray().get(0);
	}

	public ArrayList<Card> getAllDealerCards() {
		return dealer.getHand().getHandArray();  
	}

	public int getPlayerBalance() {
		return player.getBalance();
	}

	public int getPlayerBet() {
		return player.getCurrentBet();
	}

}
