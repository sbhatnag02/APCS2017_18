package net.mrpaul.apcs.PB050.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * DiceTest.java
 * Tests methods and data from Dice.java using a JUnit4 test class
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class DiceTest {
	Dice die;
	@Before
	public void setUp() throws Exception {
		die = new Dice(4); //Will return 3 because of off-by-one error
	}

	@After
	public void tearDown() throws Exception {
		die = null;
	}

	@Test
	public void testRoll() {
		//Roll die and get current side
		die.roll();
		int actual = die.getCurrentSide();
		System.out.println(actual);
		int expected = 3;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testRollCounter(){
		//Test roll counter and roll counter
		die.roll();
		die.roll();
		die.roll();
		int numRolls = die.getNumRolls();
		int actual = numRolls;
		int expected = 3;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testNumberCounter(){
		//Test counter for specific number
		die.roll();
		int numThrees = die.getNumRolls(3);
		int actual = numThrees;
		int expected = 1;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testGetPercentage(){
		//Test percentage
		die.roll();
		double percentage = die.getPercentage(3);
		double actual = percentage;
		double expected = 100.0;
		assertEquals(actual, expected, 0.0001);
	}
	
	@Test
	public void testReset(){
		//Test reset
		die.roll();
		die.reset();
		int numRolls = die.getNumRolls();
		int actual = numRolls;
		int expected = 0;
		assertEquals(actual, expected);

	}

}
