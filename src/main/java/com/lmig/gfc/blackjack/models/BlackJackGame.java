package com.lmig.gfc.blackjack.models;

public class BlackJackGame {

	private Dealer dealer;
	private Player player;
	private Deck deck;

	public BlackJackGame() {
		dealer = new Dealer();
		player = new Player(500);
		deck = new Deck();
	}

	public int getPlayerBalance() {
		return player.getBalanceFromBank();
	}
}
