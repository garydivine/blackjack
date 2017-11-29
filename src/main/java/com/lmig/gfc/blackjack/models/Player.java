package com.lmig.gfc.blackjack.models;

public class Player {

	private Bank bank;

	public Player(int intialbalance) {
		bank = new Bank(intialbalance);
	}

	public int getBalanceFromBank() {
		return bank.getBalance();
	}

}
