package net.mrpaul.apcs.pb050.ps07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PigLatinTest {

	//String variables to hold test cases
	String word;
	String word2;
	String word3;
	String word4;
	String word5;
	String word6;
	String word7;
	String word8;
	String word9;
	String word10;
	String word11;
	String word12;
	String word13;
	
	@Before
	public void setUp() throws Exception {
		//Assign values to test variables
		word = "apple";
		word2 = "bicycle";
		word3 = "spinach";
		word4 = "aardvark";
		word5 = "1543";
		word6 = "I";
		word7 = "";
		word8 = "happy";
		word9  = "duck";
		word10 = "glove";
		word11 = "--";
		word12 = "egg";
		word13 = "Inbox";
	}

	@After
	public void tearDown() throws Exception {
		//Set string objects to null at the end of testing
		word = null;
		word2 = null;
		word3 = null;
		word4 = null;
		word5 = null;
		word6 = null;
		word7 = null;
		word8 = null;
		word9 = null;
		word10 = null;
		word11 = null;
		word12 = null;
		word13 = null;
	}

	@Test
	public void testStartOfFirstConsonantCluster() {
		assertEquals(1, PigLatin.startOfFirstConsonantCluster(word));
		assertEquals(0, PigLatin.startOfFirstConsonantCluster(word2));
		assertEquals(0, PigLatin.startOfFirstConsonantCluster(word3));
		assertEquals(2, PigLatin.startOfFirstConsonantCluster(word4));
		assertEquals(-1, PigLatin.startOfFirstConsonantCluster(word5));
		assertEquals(-1, PigLatin.startOfFirstConsonantCluster(word7));

	}
	
	@Test
	public void testEndOfFirstConsonantCluster() {
		word = "yield";
		int actual = PigLatin.endOfFirstConsonantCluster(word);
		int expected = 0;
		assertEquals(actual, expected);
		word = "cycle";
		actual = PigLatin.endOfFirstConsonantCluster(word);
		expected = 0;
		assertEquals(actual, expected);
		word = "glyph";
		actual = PigLatin.endOfFirstConsonantCluster(word);
		expected = 1;
		assertEquals(actual, expected);
		word = "aardvark";
		actual = PigLatin.endOfFirstConsonantCluster(word);
		expected = 4;
		assertEquals(actual, expected);
		word = "myopic";
		actual = PigLatin.endOfFirstConsonantCluster(word);
		expected = 0;
		assertEquals(actual, expected);
		word = "1543";
		actual = PigLatin.endOfFirstConsonantCluster(word);
		expected = -1;
		assertEquals(actual, expected);
		word = "I";
		actual = PigLatin.endOfFirstConsonantCluster(word);
		expected = -1;
		assertEquals(actual, expected);
	}
	//Test wordToPigLatin method from PigLatin.java
	@Test
	public void testWordToPigLatin() {
		assertEquals("appleway", PigLatin.wordToPigLatin(word));
		assertEquals("appyhay", PigLatin.wordToPigLatin(word8));
		assertEquals("uckday", PigLatin.wordToPigLatin(word9));
		assertEquals("oveglay", PigLatin.wordToPigLatin(word10));
		assertEquals("--", PigLatin.wordToPigLatin(word11));
		assertEquals("eggway", PigLatin.wordToPigLatin(word12));
		assertEquals("Inboxway", PigLatin.wordToPigLatin(word13));
	
	}
	
	@Test
	public void testFindStartOfEndingPuncSeq() {
		assertEquals(-1, PigLatin.findStartOfEndingPuncSeq("continent"));
		assertEquals(9, PigLatin.findStartOfEndingPuncSeq("continent."));
		assertEquals(9, PigLatin.findStartOfEndingPuncSeq("continent..."));
		assertEquals(9, PigLatin.findStartOfEndingPuncSeq("continent--"));
		assertEquals(-1, PigLatin.findStartOfEndingPuncSeq("battle-field"));
		assertEquals(1, PigLatin.findStartOfEndingPuncSeq("0..."));
		assertEquals(2, PigLatin.findStartOfEndingPuncSeq("&1..."));
		assertEquals(0, PigLatin.findStartOfEndingPuncSeq("..."));
	}

}
