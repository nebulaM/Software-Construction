package exp4game;

import static org.junit.Assert.*;

import org.junit.Test;

public class Exp4GameTest {

	@Test
	public void test1() {
		assertEquals(1, Exp4Game.getWinner(1));
	}
	
	@Test
	public void test2() {
		assertEquals(2, Exp4Game.getWinner(2));
	}
	
	@Test
	public void test3() {
		assertEquals(1, Exp4Game.getWinner(3));
	}	

}
