package tournament;

/**
 * A player in a tournament.
 */
public class Player {

    private final String name;
    private final int skill;

    public Player(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }
    

    public int skill() {
        return skill;
    }
    

    @Override
    public String toString() {
        return name + " with skill ranking: " + String.valueOf(skill);
    }
}
