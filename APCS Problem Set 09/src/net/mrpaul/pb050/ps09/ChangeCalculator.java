package net.mrpaul.pb050.ps09;

import java.util.Arrays;

public class ChangeCalculator {
	
	public static int recursiveMinChange(int n, int[] coins) {
		if(n == 0) {
			return 0;
		}else {
			int[] differences = new int[coins.length];
			int numCoins = 0;
			for(int i = 0; i < coins.length; i++) {
				differences[i] = n - coins[i];
			}
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
			int smallestDif = solutions[0];
			for(int i = 0; i < solutions.length; i++) {
				if(solutions[i] < smallestDif) {
					smallestDif = solutions[i];
				}
			}
			smallestDif++;
			return smallestDif;
		}
	}
	
	public static int dynamicMinChange(int n, int[] coins) {
		if(n == 0) {	//base case
			return 0;
		}
		else {
			//Create integer array to store min change values
			int[] dynamicMinChange = new int[n+1];
			dynamicMinChange[0] = 0; //assign base case value
			for(int i = 0; i < dynamicMinChange.length; i++) {
				//Create temp array to hold differences
				int[] differences = new int[coins.length];
				//Get differences for each coin value
				for(int j = 0; j < differences.length; j++) {
					differences[j] = n - coins[j];
					if(differences[j] < 0) {
						differences[j] = Integer.MAX_VALUE;
					}
				}
				
				//Find the smallest differences
				int smallestDif = differences[0];
				for(int k = 0; k < differences.length; k++) {
					if(differences[k] < smallestDif) {
						smallestDif = differences[k];
					}
				}
				//Check if it's a base case
				if(i == 0) {
					dynamicMinChange[i] = 0;
				}else { //Assign min change to array 
					dynamicMinChange[i] = (dynamicMinChange[smallestDif] + 1);
				}
			}
			//Return min change value
			return dynamicMinChange[n];
		}
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 4, 6};
		System.out.println(dynamicMinChange(3, coins));
	}

}
