package periodicStrings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    /* too long
    @Test
    public void test5() {
        assertEquals(20, PeriodicStrings.minChanges("ACGTATAGCATGACAACAGATATTATGACAGATGTAGCAGTAACCAGAC", 12));
    }*/

    @Test
    public void test6() {
        assertEquals(true, PeriodicStrings.isPeriod("CATCATC",3));
        assertEquals(true, PeriodicStrings.isPeriod("CATCAT",3));
        assertEquals(true, PeriodicStrings.isPeriod("ACT",3));
        assertEquals(true, PeriodicStrings.isPeriod("TATA",2));
        assertEquals(true, PeriodicStrings.isPeriod("CATTCA",4));
    }
}
