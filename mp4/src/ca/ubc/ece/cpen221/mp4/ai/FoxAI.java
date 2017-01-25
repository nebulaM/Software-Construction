package ca.ubc.ece.cpen221.mp4.ai;

import java.util.*;

import ca.ubc.ece.cpen221.mp4.*;
import ca.ubc.ece.cpen221.mp4.commands.BreedCommand;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.EatCommand;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.animals.*;

/**
 * Your Fox AI.
 */
public class FoxAI extends AbstractAI {
	private int closest = 2; // max number; greater than fox's view range
	private Direction lastMoveDir=Direction.NORTH;
	//bread if and only if food around this animal > breedIffRabbitGT
	private final int breedIffRabbitGT=4;
	//bread if and only if empty location around this animal > breedIffEmptyLocationGT
	private final int breedIffEmptyLocationGT=1;
	//eat if and only if energy of this animal is less than eatIffEnergyLT/10 of the MAX energy
	private final int eatIffEnergyLT=6;
	public FoxAI() {

	}

	@Override
	/**

	 */
	public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
		// TODO: Change this. Implement your own AI to make decisions regarding
		// the next action.
		Set<Item> nearlyByAnimal=world.searchSurroundings(animal);

		Location current = animal.getLocation();
		Iterator<Item> it = nearlyByAnimal.iterator();
		//List of possible empty location for Move/Breed
		Set<Direction> hasEmptySpot=getEmptyLocations(world,animal);

		int minDistance=-1;
		Item targetRabbit=null;
		//number of nearby food
		int countRabbit=0;
		while (it.hasNext()) {
			Item item = it.next();
			if ((item.getName().equals("Rabbit"))) {
				countRabbit++;
				if (minDistance == -1 || minDistance > current.getDistance(item.getLocation())) {
					minDistance = current.getDistance(item.getLocation());
					targetRabbit = item;
				}
			}

		}
		if (targetRabbit != null) {
			if (current.getDistance(targetRabbit.getLocation()) == 1) {
				if (animal.getEnergy() < animal.getMaxEnergy() * eatIffEnergyLT / 10 ) {
					return new EatCommand(animal, targetRabbit);
				}
				//energy is high and we have many food nearby, breed
				else {
					if (!hasEmptySpot.isEmpty()) {
						Direction[] huntingDir = getHuntingDirection(animal, targetRabbit);
						if (hasEmptySpot.contains(huntingDir[0])) {
							//breed only if we have at least 2 locations around this animal
							if((countRabbit > breedIffRabbitGT &&hasEmptySpot.size() > breedIffEmptyLocationGT)) {
								lastMoveDir = huntingDir[0];
								return new BreedCommand(animal, new Location(animal.getLocation(), huntingDir[0]));
							}
							else {
								return new WaitCommand();
							}
						} else if (hasEmptySpot.contains(huntingDir[1])) {
							if((countRabbit > breedIffRabbitGT &&hasEmptySpot.size() > breedIffEmptyLocationGT)) {
								lastMoveDir = huntingDir[1];
								return new BreedCommand(animal, new Location(animal.getLocation(), huntingDir[1]));
							}
							else {
								return new WaitCommand();
							}
						}
						else
							return new WaitCommand();

					} else {
						//no empty spot around, and animal is not hungry, just wait
						return new WaitCommand();
					}
				}
			}
		}
		//never move to the opposite direction of lastMoveDir
		if(hasEmptySpot.contains(this.oppositeDir(lastMoveDir))) {
			hasEmptySpot.remove(this.oppositeDir(lastMoveDir));
		}
		if (!hasEmptySpot.isEmpty()) {
			if (targetRabbit != null) {
				Direction[] huntingDir = getHuntingDirection(animal, targetRabbit);
				if (hasEmptySpot.contains(huntingDir[0])) {
					lastMoveDir=huntingDir[0];
					return new MoveCommand(animal, new Location(animal.getLocation(), huntingDir[0]));
				} else if (hasEmptySpot.contains(huntingDir[1])) {
					lastMoveDir=huntingDir[1];
					return new MoveCommand(animal, new Location(animal.getLocation(), huntingDir[1]));
				} else {
					while (!hasEmptySpot.contains(lastMoveDir)) {
						lastMoveDir = Util.getRandomDirection();
					}
					return new MoveCommand(animal, new Location(animal.getLocation(), lastMoveDir));
				}
			}
			else {
				while (!hasEmptySpot.contains(lastMoveDir)) {
					lastMoveDir = Util.getRandomDirection();
				}
				return new MoveCommand(animal, new Location(animal.getLocation(), lastMoveDir));
			}
		}
		else {
			//no empty spot around, and animal is not hungry, just wait
			return new WaitCommand();
		}
	}

	/**
	 *
	 * @param world
	 * @param animal
	 * @return	Set of nearby empty location(being used for MOVE/Breed)
	 */
	private Set<Direction> getEmptyLocations(ArenaWorld world, ArenaAnimal animal){
		Direction dir;
		Set<Direction> emptyLocation=new HashSet<>();
		for(int i=0;i<4;++i){
			switch (i){
				case 0:  dir = Direction.EAST;
					break;
				case 1:  dir=Direction.WEST;
					break;
				case 2:  dir = Direction.SOUTH;
					break;
				case 3:  dir = Direction.NORTH;
					break;
				default:dir = Direction.EAST;
					break;

			}
			Location targetLocation = new Location(animal.getLocation(), dir);
			if (Util.isValidLocation(world, targetLocation) && this.isLocationEmpty(world, animal, targetLocation)) {
				emptyLocation.add(dir);
			}
		}
		return emptyLocation;
	}

	/**
	 * distance btw animal and target(eatable) animal
	 * int[0]=difference in x cord
	 * int[1]=difference in y cord
	 * @param animal
	 * @param targetAnimal
	 * @return

	 */
	private int[] getDistance(ArenaAnimal animal, Item targetAnimal){
		return new int []{targetAnimal.getLocation().getX()-animal.getLocation().getX(),targetAnimal.getLocation().getY()-animal.getLocation().getY()};
	}

	/**
	 * Per staff.Location, South is positive y, East is positive x
	 * It is better to get approach a target from larger(x,y)
	 * @param animal
	 * @param targetAnimal
	 * @return
	 */
	private Direction[] getHuntingDirection(ArenaAnimal animal, Item targetAnimal){
		int[] xyCord=getDistance(animal,targetAnimal);
		//the first two cases are used for Breed command, we want the child animal close to target animal
		if(xyCord[0]==0) {
			return xyCord[1]>0? new Direction[]{Direction.SOUTH,Direction.NORTH}:new Direction[]{Direction.NORTH,Direction.SOUTH};
		}
		else if(xyCord[1]==0) {
			return xyCord[0]>0? new Direction[]{Direction.EAST,Direction.WEST}:new Direction[]{Direction.WEST,Direction.EAST};
		}
		//starting from this case, THIS animal is not close to target animal yet, so we want to MOVE toward target animal
		else if(xyCord[0]>0 && xyCord[1] >0){
			return xyCord[0]>xyCord[1]? new Direction[]{Direction.EAST,Direction.SOUTH}:new Direction[]{Direction.SOUTH,Direction.EAST};
		}
		else if(xyCord[0]>0 && xyCord[1] <0){
			return xyCord[0]>Math.abs(xyCord[1])?new Direction[]{Direction.EAST,Direction.NORTH}:new Direction[]{Direction.NORTH,Direction.EAST};
		}
		else if(xyCord[0]<0 && xyCord[1] <0){
			return Math.abs(xyCord[0])>Math.abs(xyCord[1])?new Direction[]{Direction.WEST,Direction.NORTH}:new Direction[]{Direction.NORTH,Direction.WEST};
		}
		else{
			return Math.abs(xyCord[0])>xyCord[1]?new Direction[]{Direction.WEST,Direction.SOUTH}:new Direction[]{Direction.SOUTH,Direction.WEST};
		}
	}
}
