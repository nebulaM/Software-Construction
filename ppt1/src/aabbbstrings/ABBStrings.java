package aabbbstrings;

import java.util.HashSet;
import java.util.Set;

public class ABBStrings {

    /**
     * @param n >= 0
     * @return the number of words in the AABBB language of length n
     */

    public static long countStrings(int n) {
        //special case not covered by recursive call
        if(n==0){
            return 0;
        }
        return countStringsHelper(n);
    }

    public static long countStringsHelper(int n){
        if(n<0 || n==1){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return countStringsHelper(n-2)+countStringsHelper(n-3);
    }

    /**
     *
     * @param n >= 0
     * @return the set of words in the AABBB language of length n
     * @throws TooManyWordsException when the length of a word exceeds 30
     */
    public static Set<String> getWords(int n)
            throws TooManyWordsException {
        if(n<0){
            return null;
        }
        Set<String> solution=new HashSet<>();
        buildWords(n,new StringBuilder(),solution);
        return solution;
    }


    private static void buildWords( int n, StringBuilder sb,Set<String> solution){
        if(n<0 || n==1){
            return ;
        }
        if(n==0){
            solution.add(sb.toString());
            return;
        }
        //save initial length of sb
        int len=sb.length();

        sb.append("aa");
        buildWords(n-2,sb,solution);
        //backtrace
        sb.setLength(len);

        sb.append("bbb");
        buildWords(n-3,sb,solution);
        //backtrace
        sb.setLength(len);
    }

}
