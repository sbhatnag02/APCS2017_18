package net.mrpaul.apcs.pb050.ps10;
/**
 * Implements incrementable. Increments the counter by 1 each time
 * @author 409351
 *
 */
public class SequentialIncrementer implements Incrementable {

	//Instance variable
	private int counter;
	
	//Init counter
	public SequentialIncrementer() {
		counter = 0;
	}
	
	@Override
	/**
	 * Increase counter by 1
	 */
	public void increment() {
		counter++;

	}

	@Override
	/**
	 * return the value of the counter
	 */
	public int getValue() {
		return counter;
	}

}
