package net.mrpaul.apcs.PB050.ps06;

import java.util.Random;
/**
 * Dive.java
 * Holds attributes of dice -- number of rolls, rolls for each number
 * Holds behaviors of a die -- rolling
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class Dice {
	//Declare instance variables
	private Random generator;
	private int currentSide, numRolls, numOnes, numTwos, numThrees, numFours, numFives, numSixes;
	
	//No arg constructor
	public Dice(){
		this.currentSide = 1; this.numRolls = 0; 
		this.numOnes = 0; this.numTwos = 0; this.numThrees = 0; this.numFours = 0; this.numFives = 0; this.numSixes = 0;
		generator = new Random();
	}
	/**
	 * Constructor for Dice class that takes in a long "seed" for Random object
	 * @param seed lets you predict the random number to be generated
	 */
	public Dice(long seed){
		this.currentSide = 1; this.numRolls = 0; 
		this.numOnes = 0; this.numTwos = 0; this.numThrees = 0; this.numFours = 0; this.numFives = 0; this.numSixes = 0;
		generator = new Random(seed);
	}
	/**
	 * Rolls the dice and sets the current side to that number. Increments the counters
	 */
	public void roll(){
		this.currentSide = generator.nextInt(6) + 1;
		//Increment counters
		numRolls++;
		if(this.currentSide == 1){numOnes++;}
		else if(this.currentSide == 2){numTwos++;}
		else if(this.currentSide == 3){numThrees++;}
		else if(this.currentSide == 4){numFours++;}
		else if(this.currentSide == 5){numFives++;}
		else if(this.currentSide == 6){numSixes++;}
	}
	
	/**
	 * Returns die's current value
	 * @return int, last roll of die
	 */
	public int getCurrentSide() {
		return currentSide;
	}
	/**
	 * Gets the number of times the dice was rolled
	 * @return int -- number of rolls
	 */
	public int getNumRolls(){
		return numRolls;
	}
	/**
	 * Returns the number of times a certain number was rolled
	 * @param num -- which number on die
	 * @return the counter for the number specified by user
	 */
	public int getNumRolls(int num){
		if(num == 1){
			return numOnes;
		}else if(num == 2){
			return numTwos;
		}else if(num == 3){
			return numThrees;
		}else if(num == 4){
			return numFours;
		}else if(num == 5){
			return numFives;
		}else{
			return numSixes;
		}
	}
	/**
	 * calculates the percentage a certain number was rolled 
	 * @param num -- number on die to get percentage of
	 * @return double -- percentage
	 */
	public double getPercentage(int num){
		if(numRolls == 0){
			return 0.0;
		}else{
			if(num == 1){
				return numOnes/numRolls*100;
			}else if(num == 2){
				return numTwos/numRolls*100;
			}else if(num == 3){
				return numThrees/numRolls*100;
			}else if(num == 4){
				return numFours/numRolls*100;
			}else if(num == 5){
				return numFives/numRolls*100;
			}else{
				return numSixes/numRolls*100;
			}
		}
	}
	/**
	 * Reset counters back to zeroß
	 */
	public void reset(){
		this.numRolls = 0;
		this.numOnes = 0; this.numTwos = 0; this.numThrees = 0; this.numFours = 0; this.numFives = 0; this.numSixes = 0;
	}
}
