import java.util.*;

public class MostCommonWord {

    // Split the input string into words
    public static List<String> splitIntoWords(String text, String split) {
        if(text == null || split == null){
            throw new IllegalArgumentException("null input");
        }
        int textLen=text.length();
        int splitLen=split.length();
        if(textLen<splitLen){
            throw new IllegalArgumentException("text cannot shorter than split");
        }
        List<String> words=new ArrayList<>();
        //symbol only, space does not matter
        int headIndex=0;
        if(!split.matches("[a-zA-Z0-9]+")){
            for(int i=0;i<textLen-splitLen;i++) {
                if (text.substring(i, i + splitLen).equals(split)) {
                    if(i>0) {
                        words.add(text.substring(headIndex, i).trim());
                    }
                    headIndex = i + splitLen;
                }
            }
            //last element
            if(text.substring(textLen-splitLen,textLen).equals(split)) {
                words.add(text.substring(headIndex, textLen-splitLen).trim());
            }else{
                words.add(text.substring(headIndex, textLen).trim());
            }

        }else{
            for(int i=0;i<textLen-splitLen;i++) {
                if (text.substring(i, i + splitLen).equals(split)) {
                    boolean addThis=true;
                    //check i in case i=0 makes i-1 outOfBound
                    if(i>0 && text.charAt(i-1)!=' '){
                        addThis=false;
                    }
                    //i+splitLen always < textLen (ensured by the for loop)
                    if(text.charAt(i+splitLen)!=' '){
                        addThis=false;
                    }
                    if(addThis) {
                        if(i>0) {
                            words.add(text.substring(headIndex, i).trim());
                        }
                        headIndex = i + splitLen;
                    }
                }
            }
            if(text.substring(textLen-splitLen,textLen).equals(split)) {
                words.add(text.substring(headIndex, textLen-splitLen).trim());
            }else{
                words.add(text.substring(headIndex, textLen).trim());
            }
        }
        System.out.println(words);
        return words;
    }
    
    
    // Count how many times each input word appears
    public static Map<String, Integer> countOccurrences(List<String> words) {
        Map<String, Integer> wordMap=new HashMap<>();
        for(String word: words){
            if(wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word)+1);
            }else {
                wordMap.put(word, 1);
            }
        }
        System.out.println(wordMap);
        return wordMap;
    }
    
    
    // Find the input word with the highest frequency count
    public static String findMax(Map<String, Integer> freqs) {
        int max= Collections.max(freqs.values());
        for(Map.Entry<String, Integer> e:freqs.entrySet()){
            if(e.getValue().equals(max)){
                return e.getKey();
            }
        }
        throw new IllegalStateException("cannot find the max value");
    }

    
    /**
     * Find the most common word in a string of text.
     * @param s string of words.
     * @return word that occurs most often in s.
     */
    public static String mostCommonWord(String s, String split) {
        return findMax(countOccurrences(splitIntoWords(s,split)));
    }
}