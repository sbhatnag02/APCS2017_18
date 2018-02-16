package net.mrpaul.apcs.pb050.ps10;

import java.util.Random;
/**
 * Implements Incrementable. Increments the counter by a random number each time
 * @author 409351
 *
 */
public class RandomIncrementer implements Incrementable {

	//Instances vars
	private int counter;
	private Random r;
	
	//Init counter and random object
	public RandomIncrementer() {
		counter = 0;
		r = new Random();
	}
	
	@Override
	/**
	 * Increment counter by random number
	 */
	public void increment() {
		counter += r.nextInt(100) + 1;
	}

	@Override
	/**
	 * return counter value
	 */
	public int getValue() {
		return counter;
	}

}
