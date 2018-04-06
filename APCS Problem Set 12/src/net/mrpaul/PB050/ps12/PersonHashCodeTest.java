package net.mrpaul.PB050.ps12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonHashCodeTest {

	//Person objects used for testing
	Person p1, p2, p3, p4, p5, p6;
	
	@Before
	public void setUp() throws Exception {
		//Construct person objects
		p1 = new Person();
		p2 = new Person();
		p3 = new Person("Last", "First", "first_last@gmail.com", "firstLast", 2);
		p4 = new Person("Last", "First", "first_last@gmail.com", "firstLast", 2);
		p5 = new Person("Last", "First", "first_last@gmail.com", "firstLast", 2);
		p6 = new Person("Bobby", "Bob", "first_last@gmail.com", "firstLast", 2);
	}

	@After
	public void tearDown() throws Exception {
		//Set person objects to null after each test is completed
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		p5 = null;
		p6 = null;
	}

	//Test the hash code method
	@Test
	public void testHashCode() {
		assertEquals(p1.hashCode(), p2.hashCode());
		assertEquals(p3.hashCode(), p4.hashCode());
		assertFalse(p5.hashCode() == p6.hashCode());
	}

}
