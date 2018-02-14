package net.mrpaul.apcs.pb050.ps10;

public class SequentialIncrementer implements Incrementable {

	private int counter;
	
	public SequentialIncrementer() {
		counter = 0;
	}
	
	@Override
	public void increment() {
		counter++;

	}

	@Override
	public int getValue() {
		return counter;
	}

}
