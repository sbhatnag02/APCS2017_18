package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Employee;

public class Janitor extends Employee{

	@Override
	public int getHours() {
		return 80;
	}
	
	@Override
	public double getSalary() {
		return 30000.0;
	}
	
	@Override
	public int getVacationDays() {
		return 5;
	}
	
	//Added behavior
	public void clean() {
		System.out.println("Workin' for the man.");
	}
	
	
	
}
