import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MostCommonWordTest {
    @Test
    public void test1() {
        assertEquals("moto",MostCommonWord.mostCommonWord("at to which to moto to kkk to moto to abc to mato tomato","to"));

    }
    @Test
    public void test2() {
        assertEquals("to",MostCommonWord.mostCommonWord("at to which to moto to kkk to moto to abc to mato tomato"," "));
    }

    @Test
    public void test3() {
        assertEquals("to",MostCommonWord.mostCommonWord("at ,to ,which ,to ,moto ,to ,kkk ,to ,moto ,to ,abc ,to ,mato ,tomato"," ,"));
    }
    @Test
    public void test4() {
        assertEquals("moto",MostCommonWord.mostCommonWord("at ,to which ,to moto ,to kkk ,to moto ,to abc ,to mato tomato",",to"));
    }

    @Test
    public void test5() {
        assertEquals("93t",MostCommonWord.mostCommonWord("t 93t t","t"));
    }
}
