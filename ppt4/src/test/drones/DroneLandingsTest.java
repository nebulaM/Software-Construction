package drones;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DroneLandingsTest {
    @Test
    public void test1() {
        assertEquals(15, DroneLandings.timeToLand(15, 10,new String[]{"5 10 20"}));
    }
    @Test
    public void test2() {
        assertEquals(47, DroneLandings.timeToLand(15, 12,new String[]{"10 10 20","15 10 20","5 20 50"}));
    }
    @Test
    public void test3() {
        assertEquals(235, DroneLandings.timeToLand(50,85,new String[]{"20 1 100","10 100 100", "5 100 200"}));
    }
    @Test
    public void test4() {
        assertEquals(1000, DroneLandings.timeToLand(10,1000,new String[]{}));
    }
    @Test
    public void test5() {
        assertEquals(900, DroneLandings.timeToLand(400,800,new String[]{"800 1 500","400 1 499","401 501 999"}));
    }
}
