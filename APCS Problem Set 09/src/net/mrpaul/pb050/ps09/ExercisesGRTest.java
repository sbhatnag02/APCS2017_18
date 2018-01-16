package net.mrpaul.pb050.ps09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercisesGRTest {
	int[] testArr1 = {1, 2, 5, 7, 3, 5};
	int[] testArr2 = {5, 3, 7, 5, 2, 1};
	int[] testArr3 = {4, 3, 2, 5, 6, 7};
	int[] testArr4 = {7, 6, 5, 2, 3, 4};
	int[] testArr5 = {4, 12, 7, 76, 4, 53};
	int[] testArr6 = {53, 4, 76, 7, 12, 4};
	int[] testArr7 = {3, 6, 2, 4, 3};
	
	int[] triad1 = {10, 1, 2, 5, 10, 7, 3, 5, 10};
	int[] triad2 = {0, 5, 3, 7, 0, 5, 2, 1, 0};
	int[] triad3 = {20, 3, 6, 2, 20, 4, 3};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		testArr1 = null; testArr2 = null; testArr3 = null;
		testArr4 = null; testArr5 = null; testArr6 = null;
		testArr7 = null; triad1 = null; triad2 = null;
		triad3 = null;
	}

	@Test
	public void testFillOne() {
		int[] array1 = {1, 1, 1};
		int[] array2 = {1};
		int[] array3 = {1, 1, 1, 1, 1};
		assertArrayEquals(ExercisesGR.fillOne(3), array1);
		assertArrayEquals(ExercisesGR.fillOne(1), array2);
		assertArrayEquals(ExercisesGR.fillOne(5), array3);
		array1 = null; array2 = null; array3 = null;
	}
	
	@Test
	public void testReverse() {
		assertArrayEquals(ExercisesGR.reverse(testArr1), testArr2);
		assertArrayEquals(ExercisesGR.reverse(testArr3), testArr4);
		assertArrayEquals(ExercisesGR.reverse(testArr5), testArr6);
	}
	
	@Test
	public void testInsertBetweenTriads() {
		assertArrayEquals(ExercisesGR.insertBetweenTriads(testArr1, 10), triad1);
		assertArrayEquals(ExercisesGR.insertBetweenTriads(testArr2, 0), triad2);
		assertArrayEquals(ExercisesGR.insertBetweenTriads(testArr7, 20), triad3);
	}

}
