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
		if (getPlayerHand().isBlackjack() || getDealerHand().isBlackjack() || bothHaveBlackjacks()) {
			handManuallyStopped = true;
			determinePayOut();
		}
	}

	// stop hand if either participant busts or stop is forced
	// method also relied on by UI
	public boolean stopHand() {
		return (getPlayerHand().isBust() || getDealerHand().isBust() || handManuallyStopped);
	}

	// player wins (without Blackjack) if dealer busts or value is higher than
	// the dealer's
	public boolean playerWinsHandNoBlackjack() {
		return ((getDealerHand().isBust()) || (getPlayerHand().getTotal() > getDealerHand().getTotal()
				&& !getPlayerHand().isBust() && !getPlayerHand().isBlackjack()));
	}

	// player wins (with Blackjack) when they have a blackjack and dealer doesn't
	public boolean playerWinsHandWithBlackjack() {
		return (getPlayerHand().isBlackjack() && !getDealerHand().isBlackjack());
	}

	public boolean bothHaveBlackjacks() {
		return (getPlayerHand().isBlackjack() && getDealerHand().isBlackjack());
	}

	public boolean standardDraw() {
		return ((getPlayerHand().getTotal() == getDealerHand().getTotal()) && !bothHaveBlackjacks());
	}
	
	// dealer wins if all the other conditions are not met
	public boolean dealerWinsHand() {
		return (!playerWinsHandNoBlackjack() && !playerWinsHandWithBlackjack() && !bothHaveBlackjacks()
				&& !standardDraw()); 
	}
	
	// conditionally evaluate the payout
		public void determinePayOut() { 
			if (dealerWinsHand()) {
				player.loseBet();
			} else if (playerWinsHandNoBlackjack()) { 
				player.winBetNoBlackjack();
			} else if (playerWinsHandWithBlackjack()) {
				player.winBetWithBlackjack();
			} else if (bothHaveBlackjacks() || standardDraw()) {
				player.draw();
			}
		}

	public void hit() {
		player.addCardToHand(deck);
		if (stopHand()) {
			determinePayOut();
		}
	}

	public void stand() { 
		while (dealer.getHand().getTotal() <= 16) {
			dealer.addCardToHand(deck);
		}
		handManuallyStopped = true;
		determinePayOut();
	}
	
	public boolean isEligibleForDoubleDown() {
		return player.getHand().getHandArray().size() == 2; 
	}
	
	public void doubleDown() {
		player.doubleBet();
		player.addCardToHand(deck);
		
		// does the dealer get to draw like usual in this scenario?
		
		//handManuallyStopped = true;
		//determinePayOut(); 
		
		stand();
	}
	
	// game is over when the player has no more money and they have lost their last hand
	public boolean isGameOver() {
		return (player.getBalance() == 0 && player.getCurrentBet() == 0);
	} 
	
	public void continueGame() {
		handManuallyStopped = false;
		player.emptyHand();
		dealer.emptyHand();
	}
	
	public Hand getPlayerHand() {
		return player.getHand();
	}
	
	public Hand getDealerHand() {
		return dealer.getHand();
	}

	public ArrayList<Card> getAllPlayersCards() {
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
