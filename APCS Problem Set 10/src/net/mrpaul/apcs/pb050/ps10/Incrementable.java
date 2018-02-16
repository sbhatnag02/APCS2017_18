package net.mrpaul.apcs.pb050.ps10;
/**
 * Interface for Incrementable objects. Behaviors are to increment and return the value of the counter
 * @author 409351
 *
 */
public interface Incrementable {

	/**
	 * Increments counter
	 */
	public void increment();
	/**
	 * Returns the value of the counter
	 * @return value of counter
	 */
	public int getValue();
	
}
