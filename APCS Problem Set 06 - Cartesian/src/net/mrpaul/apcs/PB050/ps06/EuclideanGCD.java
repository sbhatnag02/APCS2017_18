package net.mrpaul.apcs.PB050.ps06;

import java.util.Scanner;
/**
 * EuclideanGCD.java
 * Use Euclidean algorithm to determine GCD of two numbers
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class EuclideanGCD {

	public static void main(String[] args) {
		//Declare scanner
		Scanner input = new Scanner(System.in);
		//Ask user for information
		System.out.println("Enter n1: ");
		int n1 = input.nextInt();
		System.out.println("Enter n2: ");
		int n2 = input.nextInt();
		
		//calculate steps
		int remainder = 1;
		int lastRemainder = 0;
		if(n1 > n2) { //If first number is greater than second number
			while(remainder != 0) {
				remainder = n1 % n2;
				n1 = n2;
				n2 = remainder;
				System.out.println("Step:\nA Remainder: " + remainder + "\nB"
						+ "\tn1: " + n1 + " n2: " + n2);
				if(remainder == 0) {
					lastRemainder = n1;
				}
			}
			//Print out GCD
			System.out.println("GCD is " + lastRemainder);
		}else { //If second number is greater than first number
			while(remainder != 0) {
				remainder = n2 % n1;
				n2 = n1;
				n1 = remainder;
				System.out.println("Step:\nA Remainder: " + remainder + "\nB"
						+ "\tn1: " + n1 + " n2: " + n2);
				if(remainder == 0) {
					lastRemainder = n2;
				}
			}
			//Print out GCD
			System.out.println("GCD is " + lastRemainder);
		}
		
	}

}
