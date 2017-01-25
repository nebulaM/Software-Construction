package inventoryManagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloorTimeTest {

	@Test
	public void test1() {
		assertEquals(1.0, FloorTime.avgFloorTime(2, 4), 0.00000001);
	}

	@Test
	public void test2() {
		assertEquals(2.0, FloorTime.avgFloorTime(3, 5), 0.00000001);
	}

	@Test
	public void test3() {
		assertEquals(2.5, FloorTime.avgFloorTime(1, 6), 0.00000001);
	}

	@Test
	public void test4() {
		assertEquals(6170.0, FloorTime.avgFloorTime(2345, 12345), 0.00000001);
	}
	
}
