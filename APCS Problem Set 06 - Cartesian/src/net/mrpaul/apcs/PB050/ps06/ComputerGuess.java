package net.mrpaul.apcs.PB050.ps06;

import java.util.Scanner;
/**
 * ComputerGuess.java
 * Game where computer guesses a number from user in the range of 1 to 1000
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class ComputerGuess {

	public static void main(String[] args) {
		//Set limits and instantiate scanner
		int max = 1000;
		int min = 1;
		Scanner input = new Scanner(System.in);
		//Opening message
		System.out.println("Hi, I am a computer. I am going to try to guess your number between 1 and 1000\n"
				+ "Please think of one, and press enter when you are ready to being.\n");
		input.nextLine();
		
		//Instantiate Counters
		boolean guessed = false;
		int tries = 0;
		//Loop to guess number
		while(!guessed) {
			//calculate guess and increment counter
			int guess = (max + min)/2;
			tries++;
			//Guess number
			System.out.println("Is it " + guess + "?\nType y if I am correct.  Type h if your "
					+ "number is higher, and type l if your number is lower:");
			String response = input.nextLine();
			//Set limits or end loop depending on user response
			if(response.equals("h")) {
				min = guess;
			}else if (response.equals("l")) {
				max = guess;
			}else if (response.equals("y")) {
				System.out.println("Got it! It was " + guess + ". It took me " + tries + " tries.");
				guessed = true;
			}
		}
	
	}
}
