package net.mrpaul.apcs.PB050.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Tests methods from StandardFormLine.java and StandardFormLinearSystem.java
 * @author Sarthak Bhatnagar
 *
 */
public class StandardFormLinearSystemTest {
	StandardFormLine l1, l2;
	StandardFormLinearSystem linearSystem;
	Point p;
	Point p2;
	@Before
	public void setUp() throws Exception {
		l1 = new StandardFormLine();
		l2 = new StandardFormLine();
		linearSystem = new StandardFormLinearSystem(l1, l2);
		p = new Point();
		p = new Point(0, 2);
	}

	@After
	public void tearDown() throws Exception {
		l1 = null; l2 = null;
		linearSystem = null;
		p = null;
	}

	@Test
	public void testLineSlope() {
		//Test the calculations for slope of a line -- StandardFormLine.java
		double slope = l1.getSlope();
		double expected = 1.0;
		assertEquals(slope, expected, 0.001);
	}
	
	@Test
	public void testLineToString() {
		//Test toString method for line -- StandardFormLine.java
		String lineToString = l1.toString();
		String expected = "-1.0x + 1.0y = 1.0";
		assertEquals(lineToString, expected);
	}
	
	@Test
	public void testSetLine() {
		//Test setLine and getLine methods -- StandardFormLinearSystem.java
		l2.setA(3); l2.setB(1); l2.setC(9);
		linearSystem.setLine(1, l2);
		String newLine1 = linearSystem.getLine(1).toString();
		String expected = l2.toString();
		assertEquals(newLine1, expected);
	}
	
	@Test
	public void testHasSameSlope() {
		//Test hasSameSlope method when lines are the same -- expected result is true
		boolean actual = linearSystem.hasSameSlope();
		assertTrue(actual);
		//Test hasSameSlope method when lines have different slopes -- expected result is false
		l2.setA(-2);
		actual = linearSystem.hasSameSlope();
		assertFalse(actual);
	}
	
	@Test
	public void testHasInfiniteSolutions() {
		//Test method hasInfiniteSolutions when lines have same state -- should be true
		boolean actual = linearSystem.hasInfiniteSolutions();
		assertTrue(actual);
		//Test hasInfiniteSolutions when lines have no solutions -- should be false
		l1.setA(3); l1.setB(2); l1.setC(5);
		l2.setA(3); l2.setB(2); l2.setC(14);
		actual = linearSystem.hasInfiniteSolutions();
		assertFalse(actual);
	}
	
	@Test
	public void testAreParallel() {
		//Test two lines that are parallel -- should be true
		l1.setA(3); l1.setB(2); l1.setC(5);
		l2.setA(3); l2.setB(2); l2.setC(14);
		boolean actual = linearSystem.areParallel();
		assertTrue(actual);
		//Test two lines that are not parallel -- should be false
		l1.setA(5); l1.setB(2); l1.setC(5);
		l2.setA(3); l2.setB(2); l2.setC(14);
		actual = linearSystem.areParallel();
		assertFalse(actual);
	}
	
	@Test
	public void testSolve() {
		//Test two lines that intersect at point (0, 2)
		l1.setA(2); l1.setB(3); l1.setC(6);
		l2.setA(-2); l2.setB(5); l2.setC(10);
		p = linearSystem.solve();
		boolean actual;
		if(p.getX() == 0 && p.getY() == 2) {
			actual = true;
		}else {
			actual = false;
		}
		assertTrue(actual);
		//Test two lines that have infinite solutions
		l1.setA(3); l1.setB(2); l1.setC(5);
		l2.setA(3); l2.setB(2); l2.setC(14);
		p = linearSystem.solve();
		if(p == null) {
			actual = true;
		}else {
			actual = false;
		}
		assertTrue(actual);
	}

}
