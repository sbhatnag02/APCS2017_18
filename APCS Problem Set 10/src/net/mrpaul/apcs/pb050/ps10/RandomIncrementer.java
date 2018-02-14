package net.mrpaul.apcs.pb050.ps10;

import java.util.Random;

public class RandomIncrementer implements Incrementable {

	private int counter;
	private Random r;
	
	public RandomIncrementer() {
		counter = 0;
		r = new Random();
	}
	
	@Override
	public void increment() {
		counter += r.nextInt(100) + 1;
	}

	@Override
	public int getValue() {
		return counter;
	}

}
