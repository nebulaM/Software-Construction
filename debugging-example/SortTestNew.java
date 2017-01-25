import static org.junit.Assert.*;

import org.junit.Test;

public class SortTestNew {

  @Test
  public void testReverseEmpty() {
    int[] input = {};
    int[] expected = {};
    Sort.sort(input);
    assertArrayEquals(expected, input);
  }
  
  @Test
  public void testReverseSingle() {
    int[] input = {12};
    int[] expected = {12};
    Sort.sort(input);
    assertArrayEquals(expected, input);
  }
  
  @Test
  public void testReverseDouble() {
    int[] input = {4, 0};
    int[] expected = {0, 4};
    Sort.sort(input);
    assertArrayEquals(expected, input);
  }
  
  @Test
  public void testReverseLong() {
    int[] input = {3, 6, 8, 7, 1, 5, 2, 4};
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
    Sort.sort(input);
    assertArrayEquals(expected, input);
  }
  
  @Test
  public void testReportedBug() {
    int[] input = {3, 6, 8, 7, 1, 5, 2};
    int[] expected = {1, 2, 3, 5, 6, 7, 8};
    Sort.sort(input);
    assertArrayEquals(expected, input);
  }

}
