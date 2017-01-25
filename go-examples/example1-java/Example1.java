// We need to import some Java libraries;
// and the `import` statements are not that different from
// #include< ... > in C
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Example1 {
    // The use of a `class` is something that is Java-specific;
    // adds to the verbosity of the language at times.
    // Notice that the name of the class matches the name of the file.
    
    /**
     * The main method to print a list of Pokemon names.
     * Does not require any input arguments.
     */
    public static void main(String[ ] args) {
        
        // A big difference between the C and Java versions is the use of 
        // String and ArrayList. We do not need to specify a maximum length
        // for the strings or for the list.
        List<String> pokemonNames = new ArrayList(Arrays.asList("Pikachu", "Cleafiry", "Victreebell", "Eevee", "Flareon", "Rapidash", "Charmander", "Ponyta", "Dratini", "Snorlax"));
        
        // now let us print out the names
        
        System.out.println("Here are the names of some Pokemon");
        System.out.println("==================================");

        
        // note the compressed for loop syntax
        // this loop iterates over all strings in the List pokemonNames
        for (String str : pokemonNames) {
            System.out.println(str);
        }
        
    }
    
}
