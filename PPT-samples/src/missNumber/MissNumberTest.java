import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class MissNumberTest {
    @Test
    public void test_1() {
        assertEquals(5, MissNumber.findMissNumber(Arrays.asList(1,2,3,4,6,7,8,9)));
    }
    @Test
    public void test_2() {
        assertEquals(34, MissNumber.findMissNumber(Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,35)));
    }

}
