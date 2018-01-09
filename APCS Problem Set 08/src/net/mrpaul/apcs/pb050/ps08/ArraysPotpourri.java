package net.mrpaul.apcs.pb050.ps08;

import java.util.Arrays;
import java.util.Collections;
/**
 * ArraysPotpourri.java -- Different exercises that manipulate arrays in different ways
 * @author Sarthak Bhatnagar
 *
 */
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
			if(array[i] == desiredElement) { //Check for desired element
				index = i; //if true, save the current position in local variabel
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
			//Find the smallest number
			if(array[i] < smallestNumber) {
				smallestNumber = array[i];
			}
		}
		int largestNumber = array[0];
		//find the largest number
		for(int i = 1; i < array.length; i++) {
			if(array[i] > largestNumber) {
				largestNumber = array[i];
			}
		}
		//If the array has only one element, return 1
		if(array.length == 1) {
			return 1;
		}else { //Otherwise find the difference of the largest and smallest number
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
			//Check if element is in range
			if(array[i] >= min && array[i] <= max) {
				//If in range, increase counter by one
				count++;
			}
		}
		//return counter
		return count;
	}
	/**
	 * Determines if an array is sorted in ascending numerical order. Returns true if it is, false if otherwise
	 * <p>
	 * @param array Data set to look through
	 * @return true if it is sorted, false if it is not
	 */
	public static boolean isSorted(int[] array) {
		//If array length is one, return true, otherwise check to see if array is sorted
		if(array.length == 1) {
			return true;
		}else {
			int prev = array[0];
			boolean sorted = true;
			//Check if array is sorted in ascending order
			for(int i = 1; i < array.length; i++) {
				if(array[i] < prev) {
					sorted = false;
				}else {
					prev = array[i];
				}
			}
			//return true or false, depending on whether or not it is sorted
			if(!sorted) {
				return false;
			}else {
				return true;
			}
		}
	
	}
	/**
	 * Find mode of a set of elements, passed in by an array
	 * <p>
	 * @param array
	 * @return the mode of the data set (array)
	 */
	public static int mode(int[] array) {
	    int mode = array[0];
	    int maxCount = 0;
	    //Iterate through each element of the array
	    for (int i = 0; i < array.length; i++) {
	        int currentElement = array[i];
	        int count = 1;
	        //check to see how many times element occurs, and whether it occurs the most
	        for (int j = 0; j < array.length; j++) {
	            if (array[j] == currentElement) {
	            		count++;
	            	}
	            //if it occurs the most, save the number of occurrences and the number itself
	            if (count > maxCount) {
	                mode = currentElement;
	                maxCount = count;
	            }
	        }
	    }
	    //return mode
	    return mode;
	}
	/**
	 * Calculates the standard deviation of all elements in an integer array
	 * <p>
	 * @param array
	 * @return standard deviation
	 */
	public static double stdev(int[] array) {
		int sum = 0;
		//get sum
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		//get average
		double average = sum/array.length;
		double sumDif = 0;
		//Calculate standard deviation
		for (int i = 0; i < array.length; i++) {
			sumDif += Math.pow((array[i] - average), 2);
		}
		//return square root of the sum of differences
		return Math.sqrt(sumDif/(array.length-1));
	}
	/**
	 * Find the kth largest element in the array
	 * <p>
	 * @param array
	 * @param k
	 * @return
	 */
	public static int kthLargest(int[] array, int k) {
		//Sort the array in numerical order
		Arrays.sort(array);
		//Return the desired element
		return array[array.length - 1 - k];
	}
	/**
	 * Determines the minimum 'gap' between adjacent values in the array. The gap is the difference between the adjacent elements
	 * <p>
	 * @param array
	 * @return the minGap, in the form of an integer. If the array length is less than 2, it will return 0	
	 */
	public static int minGap(int [] array) {
		if(!(array.length < 2)) { //Check if array has more than one element
			int difference = 0;
			int[] differences = new int[array.length-1]; 
			for(int i = 0; i < array.length-1; i++) { //Store differences of elements in an array
				differences[i] = array[i+1] - array[i];
			}
			int minGap = differences[0];
			for(int i = 0; i < differences.length; i++) { //look through array for smallest difference
				if(differences[i] < minGap) {
					minGap = differences[i];
				}
			}
			//return smallest difference
			return minGap;
		}else {
			return 0;
		}
	}
	/**
	 * Determines the percent of the elements in an array that are even
	 * <p>
	 * @param array
	 * @return the percent of even elements in the array as a double
	 */
	public static double percentEven(int[] array) {
		int numEven = 0;
		int totalElements = array.length;
		if(totalElements > 0) { //If array isn't empty
			for(int i = 0; i < array.length; i++) {
				if(array[i] % 2 == 0) {
					numEven++; //Increase counter for each even number
				}
			}
			double percent = ((double)numEven/totalElements) * 100; //Find percent of even numbers and return the value
			return percent;
		}else {
			return 0.0;
		}
	}	
	/**
	 * Determines whether an array is unique or not. A unique array is an array in which no values repeat. It will return true
	 * if the array is unique, or false if it isn't unique
	 * <p>
	 * @param array
	 * @return true if unique, false if not unique
	 */
	public static boolean isUnique(int[] array) {
		boolean unique = true;
		for (int i = 0; i < array.length; i++) {//Iterate through each element
		  for (int j = i+ 1; j < array.length; j++) {//check if the current element repeats in the array again
		    if (j != i && array[j] == array[i]) {
		    		unique = false;
		    }
		  }
		}
		return unique;
	}
	/**
	 * Based on a user input, the method will find the element in the array that is closest to the input, but also smaller than the input
	 * <p>
	 * @param array -- Numbers to look through and compare to user input
	 * @param price -- User guess
	 */
	public static int priceIsRight(int[] array, int price){
        int closestNum = -1;
        int biggestNumber = 0;
        for (int i = 0; i < array.length; i++) {
        		if (array[i] > biggestNumber) {
        			biggestNumber = array[i];
        		}
        }
        //Set smallestDif to the biggest number so it is guaranteed to get replaced. 
        int smallestDiff = biggestNumber + 1;
        for (int i = 0; i < array.length; i++){
            int currentElement = array[i];
            if (currentElement <= price){  //Check to see if current element is greater than guess
                int diff = price - currentElement; //Find the difference
                if (diff < smallestDiff){ //If the calculated difference is smaller than the smallest difference, set the current element to the best bid
                    smallestDiff = diff;
                    closestNum = currentElement;
                }
            }
        }
        return closestNum;
    }
	/**
	 * This method finds the longest consecutive subsequence inside an array, and returns that value
	 * <p>
	 * @param array
	 * @return The longest consecutive sequence
	 */
	public static int longestSortedSequence(int[] array) {
		//Initialize counters
		int[] longestCounts = new int[array.length];
		int currentLongestCount = 0;
		int longestCountIndex = 0;
		//Iterate through each element in the array
		for(int i = 0; i < array.length; i++) {
			if(i < array.length-1 && array[i] <= array[i+1]) {//If it's ascending, increase counter
				currentLongestCount++;
			}
			else {//if it stops ascending, store the longest count in array and reset counter
				longestCounts[i] = currentLongestCount;
				longestCountIndex++;
				currentLongestCount = 0;
			}
		}
		int longestCount = 0;
		//search through array to find longest sequence
		for(int i = 0; i < longestCounts.length; i++) {
			if(longestCounts[i] > longestCount) {
				longestCount = longestCounts[i];
			}
		}
		//return the longest sequence
		return (longestCount+1);
	}
	/**
	 * Checks to see if elements in array two are in array one
	 * <p>
	 * @param array1
	 * @param array2
	 * @return true if the elements in array 2 are in array 1, false otherwise
	 */
	public static boolean contains(int[] array1, int[] array2) {
		//Sort arrays
		boolean contains = true;
		Arrays.sort(array1);
		Arrays.sort(array2);
		int containCount = 0;
		
		for(int i = 0; i < array2.length; i++) {//Iterate through each element in array2
			for(int j = 0;  j < array1.length; j++) {
				if(array2[i] == array1[j]) {//See if current element in array 2 exists in array one
					containCount++;
					break;
				}
			}
		}
		//Check if number of similar elements match length of array 2
		if(containCount == array2.length) {
			contains = true;
		}else {
			contains = false;
		}
		return contains;
	}
	/**
	 * Collapses an array such that every pair of elements in the array are summed and stored in a new array
	 * <p>
	 * @param array
	 * @return a new int array with the sum of each pair
	 */
	public static int[] collapse(int[] array) {
		int[] collapsedArray;
		if(array.length % 2 == 0) {//If even, create array that's half the size of the original
			collapsedArray = new int[array.length/2];
			int collapseCount = 0;
			for(int i = 0; i < array.length-1; i+=2) {//iterate through each pair of elements
				collapsedArray[collapseCount] = array[i] + array[i+1]; //collapse the array
				collapseCount++;
			}
		}else {//If odd, create array half the size of the original plus 1
			collapsedArray = new int[array.length/2 + 1];
			int collapseCount = 0;
			for(int i = 0; i < array.length-1; i+=2) {//iterate through each pair of elements
				collapsedArray[collapseCount] = array[i] + array[i+1];//collapse the array
				collapseCount++;
			}
			collapsedArray[collapseCount] = array[array.length-1];//add the last element
		}
		//return the new, collapsed array
		return collapsedArray;
	}
	/**
	 * This methods appends one list onto another. List2 will be added to the end of list 1
	 * <p>
	 * @param list1
	 * @param list2
	 * @return An integer array, which combines the elements of list1 and list2
	 */
	public static int[] append(int[] list1, int[] list2) {
		//create new array with size to hold elements of array1 and array2
		int[] combinedArray = new int[list1.length + list2.length];
		//add elements of first array
		for(int i = 0; i < list1.length; i++) {
			combinedArray[i] = list1[i];
		}
		int startingIndex = list1.length;
		//add elements of second array
		for(int i = 0; i < list2.length; i++) {
			combinedArray[startingIndex] = list2[i];
			startingIndex++;
		}
		//return new array
		return combinedArray;
	}
	/**
	 * Finds the number of times each vowel occurs in a string
	 * @param str
	 * @return an integer array, containing the number of each vowel [a, e, i, o, u]
	 */
	public static int[] vowelCount(String str) {
		//Initialize counters
		int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;
		str = str.toLowerCase();
		//Iterate through each character of the string
		for(int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			//increment counters for each vowel that matches
			if(currentChar == 'a') {
				aCount++;
			}else if(currentChar == 'e') {
				eCount++;
			}else if(currentChar == 'i') {
				iCount++;
			}else if(currentChar == 'o') {
				oCount++;
			}else if(currentChar == 'u') {
				uCount++;
			}
		} 
		//create new array with list of vowels
		int[] vowelCount = {aCount, eCount, iCount, oCount, uCount};
		//return array
		return vowelCount;
		
	}
}