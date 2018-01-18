package net.mrpaul.pb050.ps09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDynamicFibonacci() {
		assertEquals(Fibonacci.dynamicFibonacci(0), 0);
		assertEquals(Fibonacci.dynamicFibonacci(2), 1);
		assertEquals(Fibonacci.dynamicFibonacci(3), 2);
		assertEquals(Fibonacci.dynamicFibonacci(5), 5);
		assertEquals(Fibonacci.dynamicFibonacci(7), 13);
	}

}
