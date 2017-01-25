
public class ChristmasSong {

	/**
	 * @param args We do not actually have to pass any arguments to this program.
	 */
	public static void main(String[] args) {
		
		// This is an example of an array of Strings.
		// Illustrates one way to declare an array.
		// There are other ways to declare an array.
		String[] giftArray = 	
							{	"a partridge in a pear tree", 
								"two turtle doves",
								"three French hens",
								"four calling birds",
								"five golden rings",
								"six geese-a-laying"
							};
		
		String initialString = "On the";
		String followupString = "day of Christmas, my true love gave to me";
		
		// Print something for the first six days of Christmas
		for ( int i = 1 ; i <= 6; ++i ) {
			// See how Strings can be created by concatenating other Strings
			// using +
			System.out.println( initialString + " " + i + numberSuffix( i ) + " " + followupString );
			
			// This loop prints a gift for each day.
			// Note the reasoning for adding the appropriate punctuation.
			for ( int j = 0; j < i; ++j ) {
				System.out.print( giftArray[ j ] );
				if ( j == i-1 ) 
				{
					System.out.println( "." );
				}
				else {
					if ( (i > 1) && (j == i-2) ) {
						System.out.println( ", and" );
					}
					else
						System.out.println( "," );
				}
			}
			
			// Leave a line between stanzas
			System.out.println( "" );
			
		}
	}
	
	
	// Notice how is is possible to use HTML tags in the special comments below.
	// The comments below are Javadoc comments as opposed to these comments.
	/**
	 * 
	 * @param n
	 * @return a String that represents the appropriate suffix for the number n in spoken English.
	 * <ul>
	 * 		<li>If n is 1 then this method should return "st" for first,</li>
	 *  	<li>if n is 2 then this method should return "nd" for second,</li>
	 * 		<li>if n is 3 then this method should return "rd" for third,</li>
	 * 		<li>if n is 4 then this method should return "th" for fourth,</li> 
	 * 		<li>etc.</li>
	 * </ul>
	 * This function should be general and work for all positive integers n.
	 * 
	 */
	private static String numberSuffix( int n ) {
		// TODO modify this method
		// In Eclipse, TODO comments are highlighted in special ways.
		return "";
	}

}
