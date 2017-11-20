package net.mrpaul.apcs.PB050.ps06;
/**
 * StandardFormLine.java
 * Object that represents a line in a standard form equation
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class StandardFormLine {
	//Declare instance variables
	private double a, b, c;
	
	//Define constructors
	/**
	 * No arg constructor to initialize instance variables
	 */
	public StandardFormLine(){
		this.a = -1;
		this.b = 1;
		this.c = 1;
	}
	/**
	 * Takes in coefficients for standard line equation
	 * @param a
	 * @param b
	 * @param c
	 */
	public StandardFormLine(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * Determines equation of line given two points
	 * @param p1
	 * @param p2
	 */
	public StandardFormLine(Point p1, Point p2) {
		double y1 = p1.getY(); double y2 = p2.getY();
		double x1 = p1.getX(); double x2 = p2.getX();
		this.a = y1-y2;
		this.b = x2 - x1;
		this.c = (x1-x2)*y1 + (y2-y1) * x1;
	}
	/**
	 * Determine slope of line based off of standard equation
	 * @return the slope as a double
	 */
	public double getSlope() {
		return (-this.a/this.b);
	}
	
	public String toString() {
		return (this.a + "x + " + this.b + "y = " + this.c);
	}
	/**
	 * @return a
	 */
	public double getA() {
		return a;
	}
	/**
	 * @param a number to set to a
	 */
	public void setA(double a) {
		this.a = a;
	}
	/**
	 * @return  b
	 */
	public double getB() {
		return b;
	}
	/**
	 * @param b number to set to b
	 */
	public void setB(double b) {
		this.b = b;
	}
	/**
	 * @return c
	 */
	public double getC() {
		return c;
	}
	/**
	 * @param c number to set to c
	 */
	public void setC(double c) {
		this.c = c;
	}
	
}
