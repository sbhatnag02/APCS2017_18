package net.mrpaul.apcs.pb050.ps08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit Test class for ArraysPotpourri.java. Tests each of the methods that are in ArraysPotpourri.java
 * @author Sarthak Bhatnagar
 *
 */
public class ArraysPotpourriTest {

	int[] array1 = new int[7];
	int[] array2 = new int[6];
	int[] array3 = new int[6];
	int[] array4 = new int[4];
	int[] array5 = new int[1];
	int[] array6 = new int[5];
	
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
		
		array5[0] = 1;
		
		array6[0] = 5;
		array6[1] = 5;
		array6[2] = 6;
		array6[3] = 7;
		array6[4] = 9;
	}

	@After
	public void tearDown() throws Exception {
		array1 = null;
		array2 = null;
		array3 = null;
		array4 = null;
		array5 = null;
		array6 = null;
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
		assertEquals(ArraysPotpourri.mode(array1), 85);
		assertEquals(ArraysPotpourri.mode(array6), 5);
	}
	
	@Test
	public void testStdev() {
		assertEquals(ArraysPotpourri.stdev(array1), 10.531, 0.2);
		assertEquals(ArraysPotpourri.stdev(array2), 2.316, 0.2);
		assertEquals(ArraysPotpourri.stdev(array4), 7.135, 0.2);
	}
	
	@Test
	public void testKthLargest() {
		assertEquals(ArraysPotpourri.kthLargest(array1, 2), 99);
		assertEquals(ArraysPotpourri.kthLargest(array2, 1), 7);
		assertEquals(ArraysPotpourri.kthLargest(array3, 3), 16);
		assertEquals(ArraysPotpourri.kthLargest(array4, 2), 10);
	}
	
	@Test
	public void testMinGap() {
		assertEquals(ArraysPotpourri.minGap(array4), 2);
		assertEquals(ArraysPotpourri.minGap(array2), -5);
		assertEquals(ArraysPotpourri.minGap(array5), 0);
	}
	
	@Test
	public void testPercentEven() {
		assertEquals(ArraysPotpourri.percentEven(array5) , 0, 0.001);
		assertEquals(ArraysPotpourri.percentEven(array2) , 50.0, 0.001);
		assertEquals(ArraysPotpourri.percentEven(array4) , 75.0, 0.001);
		assertEquals(ArraysPotpourri.percentEven(array3) , 50.0, 0.001);
	}
	
	@Test
	public void testIsUnique() {
		assertFalse(ArraysPotpourri.isUnique(array1));
		assertTrue(ArraysPotpourri.isUnique(array2));
		assertTrue(ArraysPotpourri.isUnique(array3));
		assertTrue(ArraysPotpourri.isUnique(array4));
	}
	
	@Test
	public void testPriceIsRight() {
		assertEquals(ArraysPotpourri.priceIsRight(array2, 5), 5);
		assertEquals(ArraysPotpourri.priceIsRight(array3, 17), 16);
	}
	
	@Test
	public void testLongestSortedSequence() {
		assertEquals(ArraysPotpourri.longestSortedSequence(array1), 3);
		assertEquals(ArraysPotpourri.longestSortedSequence(array2), 3);
		assertEquals(ArraysPotpourri.longestSortedSequence(array3), 3);
		assertEquals(ArraysPotpourri.longestSortedSequence(array4), 4);
	}
	
	@Test
	public void testContains() {
		int[] list1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] list2 = {1, 2, 1};
		int[] list3 = {4, 8, 6};
		assertTrue(ArraysPotpourri.contains(list1, list2));
		assertTrue(ArraysPotpourri.contains(list1, list3));
		list1 = null;
		list2 = null;
		list3 = null;
	}
	
	@Test
	public void testCollapse() {
		int[] list1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] collapsed1 = {7, 3, 5, 3, 8};
		int[] list2 = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
		int[] collapsed2 = {9,17,17,8,19};
		assertArrayEquals(ArraysPotpourri.collapse(list1), collapsed1);
		assertArrayEquals(ArraysPotpourri.collapse(list2), collapsed2);
		list1 = null;
		collapsed1 = null;
		list2 = null;
		collapsed2 = null;
	}
	
	@Test
	public void testAppend() {
		int[] appendarr1 = {1,2,3};
		int[] appendarr2 = {4,5,6};
		int[] combinedArr1 = {1,2,3,4,5,6};
		int[] combinedArr2 = {4,5,6,1,2,3};
		assertArrayEquals(ArraysPotpourri.append(appendarr1, appendarr2), combinedArr1);
		assertArrayEquals(ArraysPotpourri.append(appendarr2, appendarr1), combinedArr2);
		appendarr1 = null;
		combinedArr1 = null;
		appendarr2 = null;
		combinedArr2 = null;
	}
	
	@Test
	public void testVowelCount() {
		int[] vowelArray1 = {1, 1, 1, 1, 1};
		int[] vowelArray2 = {1, 3, 3, 1, 0};
		int[] vowelArray3 = {0, 6, 0, 2, 0};
		assertArrayEquals(ArraysPotpourri.vowelCount("aeiou"), vowelArray1);
		assertArrayEquals(ArraysPotpourri.vowelCount("i think, therefore i am"), vowelArray2);
		assertArrayEquals(ArraysPotpourri.vowelCount("hello there everyone"), vowelArray3);
		vowelArray1 = null;
		vowelArray2 = null;
		vowelArray3 = null;
	}
	

}
