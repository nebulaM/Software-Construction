package aabbbstrings;

import java.util.Set;
import java.util.TreeSet;

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
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return 0;
        }
        return countStringsHelper(n-2)+countStringsHelper(n-3);
    }

    public static Set<String> setString;
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
        setString=new TreeSet<>();
        buildWords( n,0,new StringBuilder());
        return setString;
    }


    public static String buildWords( int n, int prev,StringBuilder sb){
        n-=prev;
        if(n<0){
            //backtrace: delete previously appended string when go back to upper level
            if(sb.length()>0) {
                sb.delete(sb.length() - prev, sb.length());
            }
            return "";
        }
        if(n==0){
            String tmp=sb.toString();
            //backtrace
            if(sb.length()>0) {
                sb.delete(sb.length() - prev, sb.length());
            }
            return tmp;
        }
        if(n==1){
            //backtrace
            if(sb.length()>0) {
                sb.delete(sb.length() - prev, sb.length());
            }
            return "";
        }
        String a=buildWords(n,2,sb.append("aa"));
        if(!a.equals("")){
            setString.add(a);
        }

        String b=buildWords(n,3,sb.append("bbb"));
        if(!b.equals("")){
            setString.add(b);
        }
        //IMPORTANT: do NOT forget backtrace here
        if(sb.length()>0) {
            sb.delete(sb.length() - prev, sb.length());
        }
        return "";
    }

}
