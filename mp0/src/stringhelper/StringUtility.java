package stringhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** An instance contains static methods for assignment A2 */
public class StringUtility {

    /* Consult the methods that are declared in class String.
     * Visit docs.oracle.com/javase/8/docs/api/java/lang/String.html. 
     * Some important methods are charAt, length(), trim, substring, 
     * indexOf, isEmpty, lastIndexOf, startsWith, endsWith, split.
     */

    /** Return true iff str is a palindrome: it reads the same 
     * backwards and forwards.
     *
     * Examples: For str = "", return true
     *           For str = "ab", return false
     *           For str = "aba", return true.
     *           For str = "abba", return true.
     *           For str = "Madam, I'm Adam", return false.
     *           For str = "MadamImAdam", return false.
     *           For str = "madamimadam", return true.  
     * 
     * @param str is not null
     * @return true if str is a palindrome and false otherwise
     */
    public static boolean isPalindrome(String str) {
        // Do not visit each character of the string more than once 
        // each.
        if(str.equals("")||str.length()==1){
            return true;
        }
        for(int i=0;i<(str.length()>>1);i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**  Return the number of times query occurs as a substring of 
     * src (the different occurrences may overlap).
     * Precondition:    query is not null and
     *                  query is not the empty string "".
     * Examples: For src = "ab", query = "b", return 1.
     *           For src = "Luke Skywalker", query = "ke", return 2.
     *           For src = "abababab", query = "aba", return 3.
     *           For src = "abc", query = "", return 4 
     *
     * @param src is not null and neither is it the empty string
     * @return a count of the number of times query appears in 
     *          mainString
     */
    public static int countOccurrences(String src, String query)
    {
        if(query.equals("")){
            return src.length()+1;
        }
        int count=0;
        for(int i=0;i<=src.length()-query.length();i++){
            if(src.substring(i,i+query.length()).equals(query)){
                count++;
            }
        }
        return count;
    }

    /** 
     * Suppose a string represents somebody's full name. 
     * The first word in the string is the first name, 
     * the last word is the last name, and any words in between are 
     * middle names. The string may have an arbitary amount of 
     * whitespace (blank spaces) between words and at the beginning or 
     * the end. Return a string that is a nicely formatted name in the 
     * format Lastname, Firstname [Middle Initials]. In the string that 
     * this method returns, the first character of the last name, the 
     * first character of the first name and the middle initials must be
     * capitalized; all other characters must be in lower case.

     * Some examples:
     * sathish gopalakrishnan should result in Gopalakrishnan, Sathish
     * Matei Radu Ripeanu should result in Ripeanu, Matei R.
     * John Ronald reuel Tolkien should result in Tolkien, John R. R.
     * Arvind should result in Arvind (this is a special case when there
     * is only one word in the string) */
    
    public static String formatName(String nameStr) {
        /* As you know, String is a class. An object of class String is
         * immutable -- you cannot change the sequence of chars that it
         * contains. However, you can create new strings by catenating 
         * together parts of the original string.
         *
         * You will need to use at most one loop. 
         * This task can be solved by selecting appropriate methods in the 
         * String class and then using if statements.
         */
        if(nameStr.contains(" ")){
            String[] nameWords=nameStr.split(" ");
            StringBuilder sb=new StringBuilder();
            sb.append(upperCaseFirst(nameWords[nameWords.length-1]));
            sb.append(", ");
            sb.append(upperCaseFirst(nameWords[0]));
            int i=1;
            for (; i < nameWords.length-1; i++) {
                sb.append(" ");
                sb.append((nameWords[i].charAt(0) >= 'A' && nameWords[i].charAt(0) <= 'Z') ? nameWords[i].charAt(0) : nameWords[i].substring(0, 1).toUpperCase());
                sb.append(".");
            }
            return sb.toString();
        }
        return upperCaseFirst(nameStr);
    }

    private static String upperCaseFirst(String str){
        return (str.charAt(0)>='A' && str.charAt(0)<='Z')? str:str.replaceFirst(str.substring(0,1),str.substring(0,1).toUpperCase());
    }

    /** Return true iff s1 and s2 are anagrams of each other.
     * An anagram of a string is another string that has the same
     * characters, but possibly in a different order. 
     * Like other methods of this class, this method too is
     * case-sensitive, so 'a' and 'A' are considered different 
     * characters.
     *
     * Examples: For s1 = "mary", s2 = "army", return true.
     *           For s1 = "tom marvolo riddle", 
     *               s2 = "i am lordvoldemort", return true.
     *           For s1 = "tommarvoloriddle", 
     *               s2 = "i am lordvoldemort", return false.
     *           For s1 = "foo", s2 = "bar", return false.  
     * 
     * @param s1 and s2 are not null
     * @return true if s2 is an anagram of s1, and false otherwise
     */
    public static boolean anagrams(String s1, String s2) {
        // You do not need to use iteration/recursion.
        // Hint: how can a sequence of characters be uniquely ordered
        // You might need to first convert the string to an array of
        // characters, and then use a function from class [`Arrays`](http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html).
        char l1[]=s1.toCharArray();
        char l2[]=s2.toCharArray();
        Arrays.sort(l1);
        Arrays.sort(l2);
        return Arrays.hashCode(l1)==Arrays.hashCode(l2);
    }


    /** An encoding of the string `aaassddddffg` is the string 
     * `3a2s4d2f1g`. Along these lines, `zzz56yyy` would be encoded as 
     * `3z15163y`. Assuming this encoding method, an encoded string is 
     * a *sequence* of digit-character pairs. Implement a method to 
     * decode a string (given the encoded version). 
     * (What should you do if a string is not in the correct format? 
     * For now, assume that all test strings will conform to the 
     * expected format.)
     * 
     * @param encstr Is in the appropriate encoded format
     * @return a String that has been decoded from the special format
     */
    public static String decode(String encstr) {
        /* To produce the integer that is in String encstr use function
         * Integer.parseInt(s1). Remember that a character c is not a 
         * String, and to change c into a String you may have to 
         * catenate it with the empty String.
         * This function will probably need a nested loop
         */
        if(encstr==null || encstr.equals("") ||encstr.length()%2!=0) {
            return "";
        }
        List<Integer> l1=new ArrayList<>();
        List<Character> l2=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<encstr.length();i=i+2){
            if(encstr.charAt(i)>='0' &&encstr.charAt(i)<='9' ) {
                int count = Integer.parseInt(encstr.substring(i, i + 1));
                while (count > 0) {
                    sb.append(encstr.charAt(i + 1));
                    count--;
                }
            }else {
                System.out.println("Wrong format");
                return "";
            }
        }
        return sb.toString();
    }
}
