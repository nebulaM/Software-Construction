/**
 * 
 * @author Sathish Gopalakrishnan
 *
 * This class is used to record details about a race completion:
 * 	the runner's identification (bib/jersey number);
 * 	the runner's name;
 *  the runner's completion time in minutes.
 */
public class RaceRecord {
	
	// The following variables associated with the RaceRecord are 'private.'
	// What this means is that once can only use methods included in the RaceRecord class
	// to manipulate these data items.
	// This preserves the integrity of the data type in that it can only be operated upon
	// using well-defined methods.
	private int runnerId;
	private String runnerName;
	private int runnerTime;
	
/**
 * The default constructor for RaceRecord. Create a new RaceRecord given the constituent data items.
 * @param id the runner's id (jersey/bib number) should be >= 0
 * @param name the runner's name
 * @param rTime the runner's race completion time should be > 0
 */
	public RaceRecord ( int id, String name, int rTime ) {
	// This method is a special method. It is known as a constructor.
	// It builds a new RaceRecord.
	
		// For now, we will not verify if id is >= 0
		runnerId = id;
		
		// Set the name
		runnerName = name;
		
		// Set the race completion time in minutes.
		// Again, no verification of valid time!
		runnerTime = rTime;
	}
	
	/**
	 * @return the runner's identification number.
	 */
	public int getId( ) {
		return runnerId;
	}
	
	/**
	 * @return the runner's name.
	 */
	public String getName( ) {
		// This method is dangerous because of the way Java handles Strings.
		// But let us get to that discussion later.
		return runnerName;
	}
	
	/**
	 * @return the runner's race completion time.
	 */
	public int getTime( ) {
		return runnerTime;
	}
	
	/**
	 * This method updates a RaceRecord by replacing the runner name with the 
	 * newly supplied name.
	 * @param correctName the corrected runner name. 
	 */
	public void updateName( String correctName ) {
		runnerName = correctName;
	}
	
	/**
	 * This method updates a RaceRecord by replacing the completion time with 
	 * the newly supplied time.
	 * @param correctTime the corrected race completion time.
	 */
	public void updateTime( int correctTime ) {
		runnerTime = correctTime;
	}

}
