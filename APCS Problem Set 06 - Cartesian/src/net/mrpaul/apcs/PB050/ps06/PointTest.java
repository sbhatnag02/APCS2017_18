package net.mrpaul.apcs.PB050.ps06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * PointTest.java
 * Test methods and data from Point.java in JUnit 4 Test Class
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class PointTest {
	
	Point original;
	Point other;
	Point other2;
	@Before
	public void setUp() throws Exception {
		original = new Point(5, 2);
		other = new Point(5, -2);
		other2 = new Point(5, 6);
	}

	@After
	public void tearDown() throws Exception {
		original = null;
		other = null;
		other2 = null;
	}

	@Test
	public void testManhattanDistance() {
		//Test distance from point to origin
		other.setLocation(0, 0);
		int actual = original.manhattanDistance(other);
		int expected = 7;
		assertEquals(actual, expected);
		//Test distance for point with same x value
		other.setLocation(7, 2);
		actual = original.manhattanDistance(other);
		expected = 2;
		assertEquals(actual, expected);
		//Test distance for point with same y value
		other.setLocation(5, 3);
		actual = original.manhattanDistance(other);
		expected = 1;
		assertEquals(actual, expected);
		//Test distance for point in different quadrant
		other.setLocation(-8, 1);;
		actual = original.manhattanDistance(other);
		expected = 14;
		assertEquals(actual, expected);
		//Test points with same state
		other.setLocation(original.getX(), original.getY());
		actual = original.manhattanDistance(other);
		expected = 0;
		assertEquals(actual, expected);
		//Test points with same identity
		other = original;
		actual = original.manhattanDistance(other);
		expected = 0;
		assertEquals(actual, expected);

	}
	
	@Test
	public void testIsVertical(){
		//Test two points that line up vertically
		boolean actual = original.isVertical(other);
		boolean expected = true;
		assertEquals(actual, expected);
		//Test two points that do not line up vertically
		other.setX(3); other.setY(5);
		actual = original.isVertical(other);
		expected = false;
		assertEquals(actual, expected);
		//Test two points that line up horizontally, but not vertically
		other.setX(4); other.setY(3);
		actual = original.isVertical(other);
		expected = false;
		assertEquals(actual, expected);
		//Test two points with same state
		other.setX(original.getX()); other.setY(original.getY());
		actual = original.isVertical(other);
		expected = true;
		assertEquals(actual, expected);
		//Test two points with same identity
		other = original;
		actual = original.isVertical(other);
		expected = true;
		assertEquals(actual, expected);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSlope(){
		//Test slope between two points that have an undefined slope
		double actual = original.slope(other);
		Class<IllegalArgumentException> expected = IllegalArgumentException.class;
		assertEquals(actual, expected);
		//Test slope between two points with same y values, but different x
		other.setX(3); other.setY(2);
		actual = original.slope(other);
		int expectedNum = 0;
		assertEquals(actual, expectedNum, 0);
		//Test slope between two points
		other.setX(6); other.setY(3);
		actual = original.slope(other);
		expectedNum = 1;
		assertEquals(actual, expectedNum, 0);
	}
	
	@Test
	public void testIsCollinear(){
		//Test if three points with same x value are collinear
		boolean actual = original.isCollinear(other, other2);
		boolean expected = true;
		assertEquals(actual, expected);
		//Test if three points with same y value are collinear
		other.setX(3); other.setY(2); other2.setX(-1); other2.setY(2);
		actual = original.isCollinear(other, other2);
		expected = true;
		assertEquals(actual, expected);
		//Test if three points with same slope are collinear
		other.setX(6); other.setY(3); other2.setX(7); other2.setY(4);
		actual = original.isCollinear(other, other2);
		expected = true;
		assertEquals(actual, expected);
		//Test if three points with different slopes are collinear
		other.setX(0); other.setY(0); other.setX(-5); other.setY(3);
		actual = original.isCollinear(other, other2);
		expected = false;
		assertEquals(actual, expected);
		
		
	}

}
