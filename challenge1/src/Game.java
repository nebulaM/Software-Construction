import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Game {
	
	public enum Mode {
		
		TWO_PLAYER(0, "Two Player"),
		ONE_PLAYER(1, "One Player"),
		BOT_BATTLE(2, "Bot Battle");
		

	    private final String text;
	    private final int ID;


	    private Mode(final int ID, final String text) {
	        this.text = text;
	        this.ID = ID;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return this.text;
	    }
	    
	}


	public Game(){}
	
	/* Mode is one of SINGLE_PLAYER, TWO_PLAYER, RESUME and MOVIE */
	public Game(Mode mode){}
	public Mode getMode(){ return null; }

	public boolean isGameFinished(){ return false; }
	public Player getWinner(){ return null; }
	public void setBoard(Board board){}
	public void setPlayer(Player player){}

	void save(){}
	
	/**
	 * Opens an already saved game specified by fileName. 
	 * Parses the file specified by fileName. If fileName is a valid 
	 * game, it initializes a game and simulates it up to the last 
	 * move specified in the file.
	 * @param  fileName: an absolute path to the game file to be opened 
	 * @return true if file is valid game and opened successfully, 
	 * 		   false otherwise 
	 */
	public void open(String fileName) throws IOException{

		/* To save the game to the same file later if desired */
		this.fileName = fileName; 

		/* Just the scanner code. */
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
         
		// read file line by line
		scanner.useDelimiter(System.getProperty("line.separator"));
		while(scanner.hasNext()){
			String line = scanner.next();
			/* … */
		}
		scanner.close();
	}
	
	private String fileName;
	
}

