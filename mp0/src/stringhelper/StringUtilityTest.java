package stringhelper;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilityTest {
    @Test
    public void isPalindromeTest(){
        assertEquals(true,StringUtility.isPalindrome(""));
        assertEquals(false,StringUtility.isPalindrome("ab"));
        assertEquals(true,StringUtility.isPalindrome("aba"));
        assertEquals(true,StringUtility.isPalindrome("abba"));
        assertEquals(false,StringUtility.isPalindrome("abBa"));
        assertEquals(false,StringUtility.isPalindrome("Madam, I'm Adam"));
        assertEquals(false,StringUtility.isPalindrome("MadamImAdam"));
        assertEquals(true,StringUtility.isPalindrome("madamimadam"));
    }

    @Test
    public void countOccurrencesTest() {
        assertEquals(6, StringUtility.countOccurrences("acefg", ""));
        assertEquals(0,StringUtility.countOccurrences("bcd","k"));
        assertEquals(1, StringUtility.countOccurrences("ab", "b"));
        assertEquals(2, StringUtility.countOccurrences("Luke Skywalker", "ke"));
        assertEquals(3,StringUtility.countOccurrences("abababab","aba"));

        assertEquals(5,StringUtility.countOccurrences("abababababa","aba"));
        assertEquals(2,StringUtility.countOccurrences("apple pen pineapple","app"));
        assertEquals(2,StringUtility.countOccurrences("abababAb","aba"));
    }

    @Test
    public void formatNameTest(){
        assertEquals("Gopalakrishnan, Sathish", StringUtility.formatName("sathish gopalakrishnan"));
        assertEquals("Ripeanu, Matei R.",StringUtility.formatName("Matei Radu Ripeanu"));
        assertEquals("Tolkien, John R. R.",StringUtility.formatName("John Ronald reuel Tolkien"));
        assertEquals("Arvind",StringUtility.formatName("Arvind"));


    }

    @Test
    public void anagramsTest(){
        assertEquals(true, StringUtility.anagrams("mary", "army"));
        assertEquals(true, StringUtility.anagrams("tom marvolo riddle", "i am lordvoldemort"));
        assertEquals(false, StringUtility.anagrams("trick", "tick"));
        assertEquals(true, StringUtility.anagrams("that is a loop", "alp th o aotsi"));
        assertEquals(false, StringUtility.anagrams("trick", "Trick"));
        assertEquals(true, StringUtility.anagrams("click on it", "ti  onclick"));
    }

    @Test
    public void decodeTest(){
        assertEquals("aaassddddffg", StringUtility.decode("3a2s4d2f1g"));

        assertEquals("zzz56yyy", StringUtility.decode("3z15163y"));
    }

}
