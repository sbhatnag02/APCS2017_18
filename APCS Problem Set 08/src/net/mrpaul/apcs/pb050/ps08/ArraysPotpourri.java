package net.mrpaul.apcs.pb050.ps08;

public class ArraysPotpourri {

	public static int lastIndexOf(int[] array, int desiredElement) {
		int index = -1;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == desiredElement) {
				index = i;
			}
		}
		
		return index;
	}
	
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
	
	public static int countInRange(int[] array, int min, int max) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= min && array[i] <= max) {
				count++;
			}
		}
		return count;
	}
	
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
	
}
