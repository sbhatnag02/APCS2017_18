package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Lawyer;
/**
 * Subclass of lawyer, which is a subclass of employee
 * @author 409351
 *
 */
public class YaleLawyer extends Lawyer{
	
	@Override
	/**
	 * Override method to return a different salary
	 */
	public double getSalary() {
		return (super.getSalary() * 1.2);
	}
	
	@Override
	/**
	 * Override method to return a different amount of vacation days
	 */
	public int getVacationDays(){
		return (super.getVacationDays() + 3);
	}
	
	@Override
	public String getVacationForm() {
		String form = super.getVacationForm();
		return (form+form+form+form);
	}

}
