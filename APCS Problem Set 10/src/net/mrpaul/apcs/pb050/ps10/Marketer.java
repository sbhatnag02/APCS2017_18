package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Employee;

public class Marketer extends Employee{
	
	@Override
	public double getSalary() {
		return 50000.0;
	}
	
	//Added behavior
	public void advertise() {
		System.out.println("Act now, while supplies last!");
	}

}
