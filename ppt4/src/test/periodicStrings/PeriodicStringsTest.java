package periodicStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeriodicStringsTest {

	@Test
	public void test1() {
		assertEquals(1, PeriodicStrings.minChanges("ATAGATA", 3));
	}

	@Test
	public void test2() {
		assertEquals(3, PeriodicStrings.minChanges("ACGTGCA", 2));
	}

	@Test
	public void test3() {
		assertEquals(0, PeriodicStrings.minChanges("ACGCTGACAGATT", 13));
	}

	@Test
	public void test4() {
		assertEquals(6, PeriodicStrings.minChanges("AAAATTTCCG", 1));
	}

}
