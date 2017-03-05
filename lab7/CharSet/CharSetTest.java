import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CharSetTest {
    @Test
    public void test1(){
        assertEquals(true,new CharSet("abc").equals(new CharSet("abc")));
    }

    @Test
    public void test2(){
        assertEquals(false,new CharSet("abcd").equals(new CharSet("abc")));
    }

    @Test
    public void test3(){
        assertEquals(true, new CharSet("").equals(new CharSet("")));
    }

    @Test
    public void test4(){
        assertEquals(false, new CharSet("").equals(null));
    }

    @Test
    public void test5(){
        assertEquals(true, new CharSet("12jk,$r").equals( new CharSet("12jk,$r")));
    }
}
