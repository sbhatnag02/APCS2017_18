package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Account;

public class FilteredAccount extends Account{

	private double percentFiltered;
	private int numTransactions;
	private int numFiltered;
	
	public FilteredAccount(Client c) {
		super(c);
	}
	
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
	
	public double percentFiltered() {
		if(numTransactions == 0) {
			return 0.0;
		}else {
			return ((numFiltered/numTransactions) * 100);
		}
	}

}
