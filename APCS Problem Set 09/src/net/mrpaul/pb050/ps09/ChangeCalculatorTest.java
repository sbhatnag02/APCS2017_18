package net.mrpaul.pb050.ps09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeCalculatorTest {
	
	int[] coinSet1 = new int[3];
	int[] coinSet2 = new int[3];

	@Before
	public void setUp() throws Exception {
		coinSet1[0] = 1;
		coinSet1[1] = 4;
		coinSet1[2] = 6;
	}

	@After
	public void tearDown() throws Exception {
		coinSet1 = null;
	}

	@Test
	public void testRecursiveMinChange() {
		//Coin set 1 -- Recursive minChange
		assertEquals(ChangeCalculator.recursiveMinChange(4, coinSet1), 1);
		assertEquals(ChangeCalculator.recursiveMinChange(5, coinSet1), 2);
		assertEquals(ChangeCalculator.recursiveMinChange(8, coinSet1), 2);
	}
	
	@Test
	public void testDynamicMinChange() {
		//Coin set 1 -- Dynamic minChange
		assertEquals(ChangeCalculator.dynamicMinChange(8, coinSet1), 2);
		assertEquals(ChangeCalculator.dynamicMinChange(4, coinSet1), 1);
		assertEquals(ChangeCalculator.dynamicMinChange(9, coinSet1), 3);
		assertEquals(ChangeCalculator.dynamicMinChange(19, coinSet1), 4);
		assertEquals(ChangeCalculator.dynamicMinChange(30, coinSet1), 5);

	}

}
