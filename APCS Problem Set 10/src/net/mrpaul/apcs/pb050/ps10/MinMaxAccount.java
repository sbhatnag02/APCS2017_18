package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.BankingAccount;

public class MinMaxAccount extends BankingAccount{
	
	private int maxBalance;
	private int minBalance;
	
	public MinMaxAccount(Startup s) {
		super(s);
		maxBalance = super.getBalance();
		minBalance = super.getBalance();
	}
	
	@Override
	public void debit(Debit d) {
		super.debit(d);
		if(super.getBalance() < minBalance) {
			minBalance = super.getBalance();
		}
	}
	
	@Override
	public void credit(Credit c) {
		super.credit(c);
		if(super.getBalance() > maxBalance) {
			maxBalance = super.getBalance();
		}
	}
	
	public int getMin() {
		return minBalance;
		
	}
	
	public int getMax() {
		return maxBalance;
	}

}
