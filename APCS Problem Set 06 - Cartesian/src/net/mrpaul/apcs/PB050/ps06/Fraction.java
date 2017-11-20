package net.mrpaul.apcs.PB050.ps06;
/**
 * Fraction.java
 * Holds attributes and behaviors of fraction -- numerator, denominator, arithmetic methods
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class Fraction {
	//Instantiate instance variables
	private int numerator, denominator;
	//Default constructor
	public Fraction(){
		this.numerator = 1;
		this.denominator = 1;
	}
	/**
	 * Constructor that only takes a numerator, denominator is set to 1
	 * @param numerator
	 */
	public Fraction(int numerator){
		this.numerator = numerator;
		this.denominator = 1;
	}
	/**
	 * Constructs new fraction object by cloning an existing fraction
	 * @param fraction
	 */
	public Fraction(Fraction fraction){
		this.numerator = fraction.getNumerator();
		this.denominator = fraction.getDenominator();
	}
	/**
	 * Constructs new fraction given the numerator and denominator
	 * @param numerator 
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		if(denominator == 0){
			throw new IllegalArgumentException("Invalid. Denominator of " + denominator + " is undefined");
		}else{
			this.denominator = denominator;
		}
	}
	//Returns numerator
	public int getNumerator(){
		return this.numerator;
	}
	//Return denominator
	public int getDenominator(){
		return this.denominator;
	}
	//Set numerator
	public void setNumerator(int numerator){
		this.numerator = numerator;
	}
	//Set denominator
	public void setDenominator(int denominator){
		if(denominator == 0){
			throw new IllegalArgumentException("Invalid. Denominator of " + denominator + " is undefined");
		}else{
			this.denominator = denominator;
		}
	}
	
	//arithmetic methods
	/**
	 * Multiply two fractions
	 * @param fraction
	 * @return fraction object that has been multiplied
	 */
	public Fraction multiply(Fraction fraction){
		//Multiply numerators and denominators
		int num = (int) (this.numerator * fraction.getNumerator());
		int dem = (int)(this.denominator * fraction.getDenominator());
		fraction.setNumerator(num);
		fraction.setDenominator(dem);
		return fraction;
	}
	/**
	 * Divide two fractions
	 * @param fraction
	 * @return fraction object that has been divided
	 */
	public Fraction divide(Fraction fraction){
		//multiply be reciprocal
		int num = this.numerator * fraction.getDenominator();
		int dem = this.denominator * fraction.getNumerator();
		fraction.setNumerator(num);
		fraction.setDenominator(dem);
		return fraction;
	}
	/**
	 * Add two fractions
	 * @param fraction
	 * @return fraction object that has been added
	 */
	public Fraction add(Fraction fraction){
		int newDem = this.denominator * fraction.getDenominator();
		int newNum = this.numerator * fraction.getDenominator();
		int newNum2 = fraction.getNumerator() * this.denominator;
		
		int resultNumerator = newNum + newNum2;
		int resultDenominator = newDem;
		fraction.setDenominator(resultDenominator);
		fraction.setNumerator(resultNumerator);

		return fraction;
	}
	/**
	 * Subtract two fractions
	 * @param fraction
	 * @return fraction that has been subtracted
	 */
	public Fraction subtract(Fraction fraction){
		int newDem = this.denominator * fraction.getDenominator();
		int newNum = this.numerator * fraction.getDenominator();
		int newNum2 = fraction.getNumerator() * this.denominator;
		
		int resultNumerator = newNum - newNum2;
		int resultDenominator = newDem;
		fraction.setDenominator(resultDenominator);
		fraction.setNumerator(resultNumerator);
		
		return fraction;
	}
	
	/**
	 * Find gcd of two numbers
	 * @param num
	 * @param dem
	 */
	private int findGCD(int num, int dem){
		if(dem == 0){
			return num;
		}
			return findGCD(dem, num % dem);
		}
	/**
	 * Simplifies a fraction
	 */
	public Fraction reduce(){
		int gcd = findGCD(numerator, denominator);
		int newNum = numerator / gcd;
		int newDem = denominator / gcd;
		return new Fraction(newNum , newDem);
	}
	/**
	 * Gets reciprocal of fraction
	 * @return new fraction
	 */
	public Fraction getReciprocal(){
		int newNum = this.denominator;
		int newDem = this.numerator;
		return new Fraction(newNum, newDem);
	}
	/**
	 * Converts fraction object to double
	 * @param fraction
	 * @return numerator/denominator (from fraction object)
	 */
	public double getDoubleEquivalent(){
		double num = this.getNumerator();
		double den = this.getDenominator();
		double fractionEquiv = num/den;
		return fractionEquiv;
	}
	
	public String toString(){
		return this.numerator + "/" + this.denominator;
	}
	
}
