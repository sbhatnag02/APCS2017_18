package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.BankingAccount;
/**
 * Subclass fo BankingAccount that keeps track of the highest and lowest balance
 * @author 409351
 *
 */
public class MinMaxAccount extends BankingAccount{
	//Instance variables to keep track of maximum and minimum balance
	private int maxBalance;
	private int minBalance;
	
	/**
	 * Uses constructor from super class. Inits instance variables to keep track of max and min balance
	 * @param s
	 */
	public MinMaxAccount(Startup s) {
		super(s);
		maxBalance = super.getBalance();
		minBalance = super.getBalance();
	}
	
	@Override
	/**
	 * Overrides method from superclass to keep track of min balance
	 */
	public void debit(Debit d) {
		super.debit(d);
		if(super.getBalance() < minBalance) {
			minBalance = super.getBalance();
		}
	}
	
	@Override
	/**
	 * Overrides method from superclass to keep track of max balance
	 */
	public void credit(Credit c) {
		super.credit(c);
		if(super.getBalance() > maxBalance) {
			maxBalance = super.getBalance();
		}
	}
	//Added behavior to return min balance
	public int getMin() {
		return minBalance;
		
	}
	//Added behavior to return max balance
	public int getMax() {
		return maxBalance;
	}

}
