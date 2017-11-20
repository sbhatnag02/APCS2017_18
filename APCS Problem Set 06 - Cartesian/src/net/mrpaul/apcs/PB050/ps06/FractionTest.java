package net.mrpaul.apcs.PB050.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * FractionTest.java
 * Test methods and data from Fraction.java in JUnit4 Test Class
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class FractionTest {
	Fraction original, testFraction;
	@Before
	public void setUp() throws Exception {
		original = new Fraction(1, 2);
		testFraction = new Fraction();
	}

	@After
	public void tearDown() throws Exception {
		original = null; testFraction = null;
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetDenominator(){
		//Test illegal action of setting denominator to 0
		testFraction.setDenominator(0);
	}
	
	@Test
	public void testMultiply() {
		//Test 1/2 * 1/2
		testFraction.setNumerator(1); testFraction.setDenominator(2);
		testFraction = original.multiply(testFraction);
		String actual = testFraction.toString();
		String expected = "1/4";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testDivide(){
		//test 1/2 divided by 1/2
		testFraction.setNumerator(1); testFraction.setDenominator(2);
		testFraction = original.divide(testFraction);
		String actual = testFraction.toString();
		String expected = "2/2";
		assertEquals(actual, expected);
	}
	
	@Test
	public void  testAdd(){
		//test 1/2 + 2/4
		testFraction.setNumerator(2); testFraction.setDenominator(4);
		testFraction = original.add(testFraction);
		String actual = testFraction.toString();
		String expected = "8/8";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testSubtract(){
		//test 1/2 - 2/4
		testFraction.setNumerator(2); testFraction.setDenominator(4);
		testFraction = original.subtract(testFraction);
		String actual = testFraction.toString();
		String expected = "0/8";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testReduce(){
		//reduce 2/4 to 1/2
		testFraction.setNumerator(2); testFraction.setDenominator(4);
		testFraction = testFraction.reduce();
		String actual = testFraction.toString();
		String expected = "1/2";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testReciprocal(){
		//reciprocal of 1/2
		testFraction = original.getReciprocal();
		String actual = testFraction.toString();
		String expected = "2/1";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testDoubleEquivalent(){
		//reciprocal of 1/2
		double actual = original.getDoubleEquivalent();
		double expected = 0.5;
		assertEquals(actual, expected, 0.0);
	}
	

}
