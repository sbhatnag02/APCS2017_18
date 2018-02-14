package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Secretary;

public class LegalSecretary extends Secretary{
	
	@Override
	public double getSalary() {
		return 45000.0;
	}
	
	//New behavior
	public void fileLegalBriefs() {
		 System.out.println("I could file all day!");
	}

}
