package net.mrpaul.apcs.PB050.ps06;
/**
 * StandardFormLinearSystem.java
 * Object that represents a linear system of equations
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class StandardFormLinearSystem {

	StandardFormLine l1, l2;
	/**
	 * 
	 * @param l1 Line 1
	 * @param l2 Line 2
	 */
	public StandardFormLinearSystem(StandardFormLine l1, StandardFormLine l2) {
		this.l1 = l1;
		this.l2 = l2;
	}
	/**
	 * Default constructor
	 */
	public StandardFormLinearSystem() {
		this.l1 = new StandardFormLine();
		this.l2 = new StandardFormLine();
		
	}
	/**
	 * Sets instance variable line to a line from user
	 * @param lineNumber - Line 1 or Line 2
	 * @param line - Standard form line to be set
	 */
	public void setLine(int lineNumber, StandardFormLine line) {
		switch(lineNumber) {
			case 1:
				this.l1 = line;
				break;
			case 2:
				this.l2 = line;
				break;
		}
	}
	/**
	 * Returns the line the user calls for
	 * @param lineNumber - Selects line 1 or line 2
	 * @return StandardFormLine
	 */
	public StandardFormLine getLine(int lineNumber) {
		if(lineNumber == 1) {
			return this.l1;
		}else {
			return this.l2;
		}
		
	}
	/**
	 * Returns both lines expressed in the Standard Form Equation
	 */
	public String toString() {
		return this.l1.getA() + "x + " + this.l1.getB()+ "y = " + this.l1.getC()
		+ "\n" + this.l2.getA() + "x + " + this.l2.getB()+ "y = " + this.l2.getC();
	}
	/**
	 * Compares slope of the two lines
	 * @return true if slope is the same, false otherwise
	 */
	public boolean hasSameSlope() {
		if(this.l1.getSlope() == this.l2.getSlope()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Checks if a systems of two lines has an infinite number of solutions
	 * @return true if there are an infinite amount of solutions, false otherwise
	 */
	public boolean hasInfiniteSolutions() {
		if(this.hasSameSlope()) {
			if((this.l1.getC()/this.l1.getB()) == (this.l2.getC() / this.l2.getB())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	/**
	 * Determines whether two lines are parallel
	 * @return true if the two lines are parallel, false otherwise
	 */
	public boolean areParallel() {
		if(this.hasSameSlope()) {
			if((this.l1.getC()/this.l1.getB()) == (this.l2.getC() / this.l2.getB())) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public Point solve() {
		if(!(this.areParallel())) { //If the lines are not parallel, use Cramer's rule
			Point p = new Point();
			//Calculate x
			double[][] xarray = new double[2][2];
			xarray[0][0] = this.l1.getC(); xarray[0][1] = this.l1.getB();
			xarray[1][0] = this.l2.getC(); xarray[1][1] = this.l2.getB();
			double xNum = (xarray[0][0]*xarray[1][1]) - (xarray[1][0]*xarray[0][1]);
			double[][] xarray2 = new double[2][2];
			xarray2[0][0] = this.l1.getA(); xarray2[0][1] = this.l1.getB();
			xarray2[1][0] = this.l2.getA(); xarray2[1][1] = this.l2.getB();
			double xDen = (xarray2[0][0]*xarray2[1][1]) - (xarray2[1][0]*xarray2[0][1]);
			int x = (int) (xNum/xDen);
			
			//Calculate y
			double[][] yarray = new double[2][2];
			yarray[0][0] = this.l1.getA(); yarray[0][1] = this.l1.getC();
			yarray[1][0] = this.l2.getA(); yarray[1][1] = this.l2.getC();
			double yNum = (yarray[0][0]*yarray[1][1]) - (yarray[1][0]*yarray[0][1]);
			double[][] yarray2 = new double[2][2];
			yarray2[0][0] = this.l1.getA(); yarray2[0][1] = this.l1.getB();
			yarray2[1][0] = this.l2.getA(); yarray2[1][1] = this.l2.getB();
			double yDen = (yarray2[0][0]*yarray2[1][1]) - (yarray2[1][0]*yarray2[0][1]);
			int y = (int) (yNum/yDen);
	
			//Assign x and y to point object
			p.setX(x); p .setY(y);
			
			return p;
			
		}else {
			return null;
		}
	}
	
}
