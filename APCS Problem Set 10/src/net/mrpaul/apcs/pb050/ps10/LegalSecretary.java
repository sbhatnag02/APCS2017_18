package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Secretary;
/**
 * Subclass of Secretary, which is a subclass of employee. Has 1 added behavior and 1 overriden behavior
 * @author 409351
 *
 */
public class LegalSecretary extends Secretary{
	
	@Override
	/**
	 * Overrides method from superclass
	 */
	public double getSalary() {
		return 45000.0;
	}
	
	//added behavior
	public void fileLegalBriefs() {
		 System.out.println("I could file all day!");
	}

}
