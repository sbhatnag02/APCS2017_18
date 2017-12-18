package net.mrpaul.apcs.pb050.ps08;

public class ArraysPotpourri {
	/**
	 * Finds the last occurrence of a number in an array. If the number isn't found, it returns -1
	 * <p>
	 * @param array Set of data to search
	 * @param desiredElement Number to look for in array
	 * @return The last index the number is found, -1 if not found
	 */
	public static int lastIndexOf(int[] array, int desiredElement) {
		int index = -1;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == desiredElement) {
				index = i;
			}
		}
		
		return index;
	}
	/**
	 * Calculates and returns the range of an array
	 * <p>
	 * @param array
	 * @return
	 */
	public static int range(int[] array) {
		int smallestNumber = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < smallestNumber) {
				smallestNumber = array[i];
			}
		}
		int largestNumber = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > largestNumber) {
				largestNumber = array[i];
			}
		}
		if(array.length == 1) {
			return 1;
		}else {
			return (largestNumber - smallestNumber) + 1;
		}
	}
	/**
	 * Counts the number of elements that fall within the range of the two inputs
	 * <p>
	 * @param array Data set
	 * @param min
	 * @param max
	 * @return The number of array elements between the min and max
	 */
	public static int countInRange(int[] array, int min, int max) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= min && array[i] <= max) {
				count++;
			}
		}
		return count;
	}
	/**
	 * Determines if an array is sorted in ascending numerical order. Returns true if it is, false if otherwise
	 * <p>
	 * @param array Data set to look through
	 * @return true if it is sorted, false if it is not
	 */
	public static boolean isSorted(int[] array) {
		if(array.length == 1) {
			return true;
		}else {
			int prev = array[0];
			boolean sorted = true;
			for(int i = 1; i < array.length; i++) {
				if(array[i] < prev) {
					sorted = false;
				}else {
					prev = array[i];
				}
			}
			if(!sorted) {
				return false;
			}else {
				return true;
			}
		}
	
	}
	
	public static double stdev(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		double average = sum/array.length;
		double sumDif = 0;
		for (int i = 0; i < array.length; i++) {
			sumDif += Math.pow((array[i] - average), 2);
		}
		return Math.sqrt(sumDif/(array.length-1));
	}
	
	public static boolean isUnique(int[] array) {
		boolean unique = true;
		for (int i = 0; i < array.length; i++) {
		  for (int j = i+ 1; j < array.length; j++) {
		    if (j != i && array[j] == array[i]) {
		    	unique = false;
		    }
		  }
		}
		return unique;
	}
	
}
