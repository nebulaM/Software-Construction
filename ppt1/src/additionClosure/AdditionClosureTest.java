package additionClosure;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AdditionClosureTest {

    @Test
    public void test1() {
        assertEquals(true, AdditionClosure.isClosed(Arrays.asList(-1, 0, 1), 2));
    }

    @Test
    public void test2() {
        assertEquals(false, AdditionClosure.isClosed(Arrays.asList(-2, 3), 4));
    }

    @Test
    public void test3() {
        assertEquals(true, AdditionClosure.isClosed(Arrays.asList(1, 1, 0), 2));
    }

    @Test
    public void test4() {
        assertEquals(false, AdditionClosure.isClosed(Arrays.asList(1, 1), 3));
    }

    @Test
    public void test5() {
        assertEquals(true, AdditionClosure.isClosed(Arrays.asList(1, 1, 2), 2));
    }

    @Test
    public void test6() {
        assertEquals(true, AdditionClosure.isClosed(Arrays.asList(0, 1, 1, 2), 2));
    }

    @Test
    public void test7() {
        assertEquals(false, AdditionClosure.isClosed(Arrays.asList(0, 1, 100, 50, 50), 100));
    }

    @Test
    public void test8() {
        assertEquals(true, AdditionClosure.isClosed(Arrays.asList(0, 1, 100, 50, 50), 50));
    }
}
