package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Account;
/**
 * Subclass of account that can process "0" transactions. Added behavior that keeps track of filtered transactions
 * @author 409351
 *
 */
public class FilteredAccount extends Account{
	//Instance vars to keep track of percent filtered
	private double percentFiltered;
	private int numTransactions;
	private int numFiltered;
	
	/**
	 * Constructor (uses superclass's constructor)
	 * @param c
	 */
	public FilteredAccount(Client c) {
		super(c);
	}
	/**
	 * Override process method to keep track of number of transactions
	 */
	@Override
	public boolean process(Transaction t) {
		if(!(t.value() == 0)) {
			numTransactions++;
			return super.process(t);
		}else {
			numTransactions++;
			numFiltered++;
			return true;
		}
	}
	/**
	 * Added behavior that keeps track of number of transactions that have been filtered
	 * @return % of filtered transactions
	 */
	public double percentFiltered() {
		if(numTransactions == 0) {
			return 0.0;
		}else {
			return ((numFiltered/numTransactions) * 100);
		}
	}

}
