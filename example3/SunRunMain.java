import java.util.Scanner;

public class SunRunMain {

	/**
	 * Collect information for a certain number of runners in a team, and then
	 * compute the average race completion time for the team. Display the result.
	 * @param args The arguments are ignored.
	 */
	public static void main(String[] args) {
		// The keyword _final_ is used to indicate a constant.
		final int numRunners = 5;
		
		// Create an array of RaceRecords, one for each team member.
		// Here we only allocate space for the array.
		// We do not create the RaceRecords yet.
		RaceRecord[] ourTeamRecords = new RaceRecord[ numRunners ];
		
		// Create a scanner to read imputs from the default system input.
		Scanner scanner = new Scanner( System.in );
		// Each input to the scanner is terminated by a newline or carriage return,
		// which is denoted by \n. 
		// The \\n is needed because \ is a special character in these contexts.
		scanner.useDelimiter( System.getProperty( "line.separator" ) );
		
		// Read the information for the team and create new RaceRecords.
		// The new RaceRecords are stores in the array created earlier.
		for ( int i = 0; i < numRunners; ++i ) {
			System.out.println( "Enter details for Runner " + (i+1) );
			System.out.print( "Enter id: ");
			int id = scanner.nextInt( );
			System.out.print( "Enter name: ");
			String name = scanner.next( );
			System.out.print( "Enter completion time in minutes: ");
			int rTime = scanner.nextInt( );
			ourTeamRecords[ i ] = new RaceRecord( id, name, rTime );
			System.out.println( );
		}
		
		// We are done with the scanner.
		// Close it.
		scanner.close( );
	
		// Compute the average completion time and display the result.
		float totalTime = 0;
		for ( int i = 0; i < numRunners; ++i ) {
			totalTime += ourTeamRecords[ i ].getTime( );
		}
		System.out.println( "Average completion time is " + totalTime/numRunners + " minutes" );
		
	}

}
