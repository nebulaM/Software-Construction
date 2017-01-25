package aabbbstrings;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class ABBStringsTest {

	@Test
	public void test0() {
		assertEquals(0, ABBStrings.countStrings(0));
	}

	@Test
	public void test1() {
		assertEquals(0, ABBStrings.countStrings(1));
	}
	
	@Test
	public void test2() {
		assertEquals(1, ABBStrings.countStrings(2));
	}

	@Test
	public void test3() {
		assertEquals(1, ABBStrings.countStrings(3));
	}

	@Test
	public void test4() {
		assertEquals(1, ABBStrings.countStrings(4));
	}


	@Test
	public void test5() {
		assertEquals(2, ABBStrings.countStrings(5));
	}

	@Test
	public void test12() {
		assertEquals(12, ABBStrings.countStrings(12));
	}

	@Test
	public void test45() {
		assertEquals(128801, ABBStrings.countStrings(45));
	}
	
	@Test
	public void testWords5() {
		try {
			assertEquals(new HashSet<String>(Arrays.asList("aabbb", "bbbaa")), ABBStrings.getWords(5));
		}
		catch (TooManyWordsException e) {
			fail("No exception should have been thrown!");
		}
	}
	
}
