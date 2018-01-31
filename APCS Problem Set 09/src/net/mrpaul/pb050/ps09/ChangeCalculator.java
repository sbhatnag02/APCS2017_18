package net.mrpaul.pb050.ps09;

import java.util.Arrays;

public class ChangeCalculator {
	
	public static int recursiveMinChange(int n, int[] coins) {
		//Check base case
		if(n == 0) {
			return 0;
		}else {
			//Create new array to hold coin differences
			int[] differences = new int[coins.length];
			//Create counter to track number of coins used
			int numCoins = 0;
			//Calculate differences
			for(int i = 0; i < coins.length; i++) {
				differences[i] = n - coins[i];
			}
			//Check cases based on calculated differences
			int[] solutions = new int[differences.length];
			for(int i = 0; i < differences.length; i++) {
				int solution = differences[i];
				if(solution == 0) {
					solutions[i] = 1;
					return 1;
				}else if(solution < 0) {
					solutions[i] = Integer.MAX_VALUE;
					differences[i] = Integer.MAX_VALUE;
				}else if(solution > 0) {
					solutions[i] = recursiveMinChange(differences[i], coins);
					numCoins++;
				}
			}
			//Find the smallest difference
			int smallestDif = solutions[0];
			for(int i = 0; i < solutions.length; i++) {
				if(solutions[i] < smallestDif) {
					smallestDif = solutions[i];
				}
			}
			//Return smallest dif -- minimum number of coins used
			smallestDif++;
			return smallestDif;
		}
	}
	
	public static int dynamicMinChange(int n, int[] coins) {
		int[] dynamicMinChange = new int[n+1];
		if(n == 0) {//Check base case of 0
			return 0;
		}else if (n == 1) { //Check base case of 1
			return 1;
		}
		//Check if any of the coins in coins[ ] match n
		boolean matchesCoin = false;
		for(int i = 0; i < coins.length; i++) {
			if(n == coins[i]) {
				matchesCoin = true;
			}
		}
		//Return 1 if one coin matches
		if(matchesCoin) {
			return 1;
		}else {//Build up array
			//Assign base values
			dynamicMinChange[0] = 0;
			dynamicMinChange[1] = 1;
			//Iterate through each element and build up dynamicMinChange array
			for(int i = 2; i < dynamicMinChange.length; i++) {
				for(int j = coins.length - 1; j >= 0; j--) {
					int difference = i - coins[j];
					//If difference is negative, don't do anything
					if(!(difference < 0)) {
						if(dynamicMinChange[i] == 0) { //Check if array slot is empty
							dynamicMinChange[i] = (dynamicMinChange[difference] + 1);
						}else {
							//Compare new min change with existing min change value
							int newMinChange = (dynamicMinChange[difference] + 1);
							if(newMinChange < dynamicMinChange[i]){ //Assign new min change value if new one is less than current one
								dynamicMinChange[i] = newMinChange;
							}
						}
					}
				}
			}
			//Return minChange value
			return dynamicMinChange[n];
		}
	}

}
