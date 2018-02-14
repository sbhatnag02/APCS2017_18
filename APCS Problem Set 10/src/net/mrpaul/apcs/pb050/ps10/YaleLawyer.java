package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Lawyer;

public class YaleLawyer extends Lawyer{
	
	@Override
	public double getSalary() {
		return (super.getSalary() * 1.2);
	}
	
	@Override
	public int getVacationDays(){
		return (super.getVacationDays() + 3);
	}
	
	@Override
	public String getVacationForm() {
		String form = super.getVacationForm();
		return (form+form+form+form);
	}

}
