package net.mrpaul.apcs.pb050.ps10;

import net.mrpaul.ps10.distribution.Employee;
/**
 * Janitor class that extends employee. Has added behavior to clean
 * @author 409351
 *
 */
public class Janitor extends Employee{
	/**
	 * Overrides superclass to change hours to 80
	 * @return num hours worked
	 */
	@Override
	public int getHours() {
		return 80;
	}
	
	/**
	 * Overrides superclass method to return salary
	 */
	@Override
	public double getSalary() {
		return 30000.0;
	}
	/**
	 * Overrides superclass to return vacation days
	 */
	@Override
	public int getVacationDays() {
		return 5;
	}
	
	//Added behavior
	public void clean() {
		System.out.println("Workin' for the man.");
	}
	
	
	
}
