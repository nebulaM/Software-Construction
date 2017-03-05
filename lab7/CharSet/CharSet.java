import java.util.Objects;

public class CharSet {
    
    private String s;
    // Rep invariant:
    //     s contains no repeated characters;
    //     s is sorted such that s[0] < s[1] < ... < s[s.length()-1]
    // Abstraction function:
    //     represents the set of characters found in s
    public CharSet(String s){
        this.s=s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(!(obj instanceof CharSet)){
            return false;
        }
        CharSet test=(CharSet) obj;
        return Objects.equals(this.s,test.s);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

}
