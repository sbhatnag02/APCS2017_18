package net.mrpaul.PB050.ps12;

public class Exercises2dArr {

	/**
	 * Return the max value element from a 2D array
	 * @param a array to search through
	 * @return the max value in the 2D  array
	 */
	public static int max(int[][] a) {
		//Define initial max
		int max = a[0][0];
		//Iterate through the array to search for the max
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] > max) { //If the current element is greater than the current max, set the current element to the max
					max = a[i][j];
				}
			}
		}
		//Return the highest element
		return max;
	}
	
	/**
	 * Collapses a 2D array into a 1D array by summing the second dimension
	 * @param a array to collapse
	 * @return the collapsed array, as a 1D array
	 */
	public static int[] collapseRows(int[][] a) {
		//Create 1D array to collapse 2D array into
		int[] collapsedArray = new int[a.length];
		//Iterate through each row of the 2D array
		for(int i = 0; i < a.length; i++) {
			//Sum the elements in each row and store it in 1 value in the 1D array
			for(int j = 0; j < a[i].length; j++) {
				collapsedArray[i] += a[i][j];
			}
		}
		//Return the 1D array
		return collapsedArray;
	}
	/**
	 * Generates a ragged array (first array has 1 element, second array has 2 elements, etc.)
	 * @param n number of arrays to generate (how many rows are there)
	 * @return a ragged array as a 2D integer array
	 */
	public static int[][] generateRagged(int n){
		int[][] raggedArray = new int[n][n];
		int counter = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <=i; j++) {
				raggedArray[i][j] = counter;
				counter++;
			}
		}
		return raggedArray;
	}
	/**
	 * Checks to see if an array is a latin square. A latin square doesn't have any elements repeat in a given row
	 * or in a given column
	 * @param arr array to check to see if it is a latin square
	 * @return true if the array is a latin square, false otherwise
	 */
	public static boolean isLatinSquare(int[][] arr) {
		boolean[][] currentColumn = new boolean[arr.length][arr.length];
	    boolean[][] currentRow = new boolean[arr.length][arr.length];
	    //Iterate through each row of the array
	    for(int rowIndex = 0; rowIndex < arr.length; rowIndex++) {
	    	//Base case for checking a square (length and height of array should be the same)
	        if (arr[rowIndex].length != arr.length) { //Return false if it is not a square
	            return false; // Not a square
	        }
	        //Search for duplicates and iterate through each column
	        for (int columnIndex = 0; columnIndex < arr.length; columnIndex++) {
	            int currentElement = arr[rowIndex][columnIndex] - 1;
	            if (currentRow[rowIndex][currentElement] || currentColumn[columnIndex][currentElement]) {
	                return false;
	            }
	            currentRow[rowIndex][currentElement] = currentColumn[columnIndex][currentElement] = true;
	        }
	    }
	    
	    return true;
	}
	
	public static void main(String[] args) {
		//Create 2D arrays for method testing
		int[][] arr1 = {
				{1, 2, 3, 4, 5},
				{2, 5, 3, 4, 6},
				{12, 45, 14, 56, 37},
		};
		
		int[][] arr2 = {
				{3, 6, 4, 3},
				{5, 2, 5, 7},
				{11, 12, 5, 7},
		};
		
		int[][] arr3 = {
				{1, 1, 1},
				{2, 3, 1},
				{3, 2, 1}
		};
		
		int[][] arr4 = {
				{1, 2, 3},
				{2, 3, 1},
				{3, 1, 2}
		};

		//Test max method, expected output is 56
		System.out.println(max(arr1));
		//Test max method, expected output is 12
		System.out.println(max(arr2));
		
		//Test collapse rows method, expected output is true
		int[] collapsedArr1 = collapseRows(arr1);
		System.out.println(collapsedArr1[0] == 15);
		//Test collapse rows method, expected output is true
		int[] collapsedArr2 = collapseRows(arr2);
		System.out.println(collapsedArr2[0] == 16);
		
		//Test ragged array method. Console should output a ragged array
		int[][] raggedArray = generateRagged(5);
		for(int i = 0; i < raggedArray.length; i++) {
			for(int j = 0; j < raggedArray[i].length; j++) {
				if(raggedArray[i][j] != 0)
				System.out.print(raggedArray[i][j] + ", ");
			}
			System.out.println();
		}
		
		//Test isLatinSquare method, expected output should be false
		System.out.println(isLatinSquare(arr3));
		//Test isLatinSquare method, expected output should be true
		System.out.println(isLatinSquare(arr4));
		
		
	}
	
}
