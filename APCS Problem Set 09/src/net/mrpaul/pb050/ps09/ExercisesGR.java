package net.mrpaul.pb050.ps09;
/**
 * ExercisesGR.java
 * Warm up exercises for problem set 09
 * @author Sarthak Bhatnagar
 * 1/9/18
 */
public class ExercisesGR {
	/**
	 * Create a new array, filled with values of 1. Length of array is entered by the user
	 * <p>
	 * @param length
	 * @return new int array with user-desired length
	 */
	public static int[] fillOne(int length) {
		int[] array = new int[length];
		for(int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
		return array;
	}
	/**
	 * Reverses an array entered by the user (last value becomes first, etc)
	 * <p>
	 * @param array
	 * @return new int array which has been reversed from the array entered as a param
	 */
	public static int[] reverse(int[] array) {
		int[] reverse = new int[array.length];
		for(int i = 0; i < reverse.length; i++) {
			reverse[i] = array[(array.length-1) - i];
		}
		return reverse;
	}
	/**
	 * Inserts int i between every 3 elements of the array. int i is the first element of the new array, and will repeat after every 3 elements
	 * from the original array
	 * <p>
	 * @param A
	 * @param i
	 * @return a new array with int i inserted after every 3 elements
	 */
	public static int[] insertBetweenTriads(int[] A, int i) {
		int triads = A.length/3;
		int[] triadArray = new int[A.length + triads + 1];
		triadArray[0] = i;
		System.out.println(triadArray[0]);
		int iCount = 1;
		for(int j = 1; j < triadArray.length; j++) {
			if((j) % 4 == 0) {
				triadArray[j] = i;
				iCount++;				
			}else {
				triadArray[j] = A[j-iCount];
			}
		}
		return triadArray;
	}
	
}
