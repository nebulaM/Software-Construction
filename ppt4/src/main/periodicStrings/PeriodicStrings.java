package periodicStrings;

import java.util.TreeSet;

public class PeriodicStrings {
    private static TreeSet<Integer> solutions=new TreeSet<>();
    /**
     * How many changes are needed to make a string periodic?
     *
     * @param hiddenMsg
     *            the string to make periodic
     * @param maxPeriod
     *            the maximum permissible period
     * @return
     */
    public static int minChanges(String hiddenMsg, int maxPeriod) {
        if(isPeriod(hiddenMsg,maxPeriod)){
            return 0;
        }
        solutions.clear();
        while(maxPeriod>0){
            modifyChar(hiddenMsg.toCharArray(),0,maxPeriod,0);
            maxPeriod--;
        }
        if(solutions.first()!=null){
            return solutions.first();
        }
        return -1;
    }
    private static char[] list={'A','C','T','G'};
    private static int modifyChar(char[] s, int pos, int maxPeriod, int step){
        if(maxPeriod<=0 ){
            return -1;
        }
        if(isPeriod(String.valueOf(s),maxPeriod)){
            //System.out.println("setp "+step+" "+String.valueOf(s)+" period "+maxPeriod);
            return step;
        }
        if(pos>=s.length){
            return -1;
        }
        for (char ch : list) {
            int localStep;
            char original=s[pos];
            if (ch != original) {
                s[pos] = ch;
                localStep=modifyChar(s, pos+1, maxPeriod, step+1);
                //backtrace
                s[pos]=original;
            }else {
                localStep=modifyChar(s, pos+1, maxPeriod, step);
            }
            if(localStep!=-1) {
                //collect solutions and sort later
                solutions.add(localStep);
            }
        }
        return -1;
    }

    public static boolean isPeriod(String s, int period){
        if(s==null||period>=s.length()){
            return true;
        }
        if(period==1){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=s.charAt(0)){
                    return false;
                }
            }
            return true;
        }
        StringBuilder sb=new StringBuilder(period);
        for(int i=0; i<period; i++){
            sb.append(s.charAt(i));
        }
        String pattern=sb.toString();
        for(int i=0;i<s.length()-period;i=i+period){
            //System.out.println("s is "+s+" sub is "+s.substring(i,period)+" pattern is "+pattern);
            if(!pattern.equals(s.substring(i,period+i))){
                return false;
            }
        }
        /*
         * for example, if string length is 7 and period is 2,
         * we need to make sure that the last char in this string matches
         * the first char in pattern
         */
        int remaining=s.length()%period;
        return pattern.substring(0,remaining).equals(s.substring(s.length()-remaining));
    }

}
