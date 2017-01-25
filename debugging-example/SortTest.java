import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

  @Test
  public void testReverseSingle() {
    int[] input = {12};
    int[] expected = {12};
    Sort.sort(input);
    assertArrayEquals(expected, input);
  }
  
}
