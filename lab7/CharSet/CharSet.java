
public class CharSet {
    
    private String s;
    
    // Rep invariant:
    //     s contains no repeated characters;
    //     s is sorted such that s[0] < s[1] < ... < s[s.length()-1]
    // Abstraction function:
    //     represents the set of characters found in s
    
    
    @Override
    public boolean equals(Object obj) {
        return false; // Replace with your implementation
    }
    
    @Override
    public int hashCode() {
        return 0; // Replace with your implementation
    }

}
