package net.mrpaul.apcs.pb050.ps08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArraysPotpourriTest {

	int[] array1 = new int[7];
	int[] array2 = new int[6];
	int[] array3 = new int[6];
	int[] array4 = new int[4];
	
	@Before
	public void setUp() throws Exception {
		array1[0] = 75;
		array1[1] = 85;
		array1[2] = 102;
		array1[3] = 99;
		array1[4] = 101;
		array1[5] = 85;
		array1[6] = 99;
		
		array2[0] = 8;
		array2[1] = 3;
		array2[2] = 5;
		array2[3] = 7;
		array2[4] = 2;
		array2[5] = 4;
		
		array3[0] = 15;
		array3[1] = 22;
		array3[2] = 8;
		array3[3] = 19;
		array3[4] = 31;
		array3[5] = 16;
		
		array4[0] = 0;
		array4[1] = 10;
		array4[2] = 12;
		array4[3] = 17;
	}

	@After
	public void tearDown() throws Exception {
		array1 = null;
		array2 = null;
		array3 = null;
	}

	//Test lastIndexOf method in ArraysPotpouri.java
	@Test
	public void testLastIndexOf() {
		assertEquals(ArraysPotpourri.lastIndexOf(array1, 85), 5);
		assertEquals(ArraysPotpourri.lastIndexOf(array1, 99), 6);
		assertEquals(ArraysPotpourri.lastIndexOf(array1, 3), -1);
		assertEquals(ArraysPotpourri.lastIndexOf(array1, 75), 0);
	}
	
	@Test
	public void testRange() {
		assertEquals(ArraysPotpourri.range(array1), 28);
		assertEquals(ArraysPotpourri.range(array2), 7);
		assertEquals(ArraysPotpourri.range(array3), 24);
	}
	
	@Test
	public void testCountInRange() {
		assertEquals(ArraysPotpourri.countInRange(array1, 100, 105), 2);
		assertEquals(ArraysPotpourri.countInRange(array2, 3, 6), 3);
		assertEquals(ArraysPotpourri.countInRange(array3, 12, 25), 4);
	}
	
	@Test
	public void testIsSorted() {
		assertTrue(ArraysPotpourri.isSorted(array4));
		assertFalse(ArraysPotpourri.isSorted(array1));
		assertFalse(ArraysPotpourri.isSorted(array2));
	}
	
	@Test
	public void testMode() {
		
	}

}
