package ca.ubc.ece.cpen221.mp4.ai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.Direction;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.commands.BreedCommand;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.EatCommand;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.animals.ArenaAnimal;

/**
 * Your Rabbit AI.
 * Credit to my friend
 */
public class RabbitAI extends AbstractAI {

    private static double energyFactorToEat = 0.8;   // Energy Percentage Threshold to start eating 
    private static double energyFactorToBreed = 0.9;   // Energy Percentage Threshold to start breeding 
    
    private int closest = 10; // max number; greater than rabbit's view range
    private Direction previousMove = null;

    public RabbitAI() {
    }

    @Override
    public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {


        List<Direction> possibleMoveDirections = new ArrayList<Direction>();
        List<Direction> possibleMoveDirections_predatorFree = new ArrayList<Direction>();
        possibleMoveDirections.add(Direction.NORTH);
        possibleMoveDirections.add(Direction.SOUTH);
        possibleMoveDirections.add(Direction.EAST);
        possibleMoveDirections.add(Direction.WEST);
        possibleMoveDirections = removeInvalidDirections(world, animal, possibleMoveDirections);
        possibleMoveDirections_predatorFree = getDirectionToAvoidPredators(world, animal, possibleMoveDirections);

        // If no possible directions, do nothing
        if (possibleMoveDirections_predatorFree.size() == 0) {
            return new WaitCommand();
        }
        // If there's a new invalid direction, means we have a predator beside & we got to run
        else if( possibleMoveDirections_predatorFree.size() - possibleMoveDirections.size() != 0 ){
            Direction nextMoveDirection = getRandomDirection(possibleMoveDirections_predatorFree);
            Location targetLocation = new Location(animal.getLocation(), nextMoveDirection);
            previousMove = nextMoveDirection;
            return new MoveCommand(animal, targetLocation);
        }
        // If we don't have to run away from predator, decide if we move, eat or
        // breed
        // - If energy == 100%, breed
        // - Else if there's grass beside me
        //      - If energy > 50%, do nothing (stay next to grass)
        //      - Else (energy <= 50%) eat grass
        // - Else find grass (make sure we don't undo last move, i.e. if we moved down previous turn, don't move up this turn)
        else if ( enoughEnergyToBreed(animal) && animal.getEnergy() > energyFactorToBreed * animal.getMaxEnergy()) {
                Direction nextMoveDirection = getRandomDirection(possibleMoveDirections);
                Location targetLocation = new Location(animal.getLocation(), nextMoveDirection);
                return new BreedCommand(animal, targetLocation);
        } 
        else {
            Item nextFoodItem = getNextAdjacentPreyToEat(world, animal);
            // If we have a prey (i.e. grass) in adjacent tile
            if (nextFoodItem != null) {
                if (animal.getEnergy() > energyFactorToEat * animal.getMaxEnergy()) {
                    return new WaitCommand(); // Wait next to Food
                } else {
                    return new EatCommand(animal, nextFoodItem);
                }
            }
            // Else find for prey (i.e. grass)
            else {
                Direction nextMoveDirection;
                nextMoveDirection = getRandomDirection(possibleMoveDirections);
                Location targetLocation = new Location(animal.getLocation(), nextMoveDirection);
                previousMove = nextMoveDirection;
                return new MoveCommand(animal, targetLocation);
            }
        }
    
    }

    /*
     * Checks if the animal passed into the function has enough energy to breed
     * 
     * @params thisAnimal animal to check if it has energy to breed
     * 
     * @return true if the animal has energy to breed, false otherwise
     */
    private static boolean enoughEnergyToBreed(ArenaAnimal thisAnimal) {
        return thisAnimal.getEnergy() >= thisAnimal.getMinimumBreedingEnergy();
    }

    /**
     * Determines the possible direction to take based on predator positions
     * relative to current position.
     * 
     * @param world
     *            ArenaWorld instance
     * @param animal
     *            ArenaAnimal instance
     * 
     * @return a list of possible directions to move.
     */
    private List<Direction> getDirectionToAvoidPredators(ArenaWorld world, ArenaAnimal animal,
            List<Direction> possibleMoveDirections) {

        // Check surroundings
        Set<Item> allUnits = world.searchSurroundings(animal);
        Location current = animal.getLocation();
        Iterator<Item> it = allUnits.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if ((item.getName().equals("fox")) && (current.getDistance(item.getLocation()) == 1)) {
                Location thisFoxLoc = item.getLocation();
                Direction dirFromCurrentToFox = Util.getDirectionTowards(current, thisFoxLoc);
                possibleMoveDirections.remove( oppositeDir(dirFromCurrentToFox) );
            }
        }

        return possibleMoveDirections;
    }

    /**
     * Remove any direction in <code>possibleMoveDirections</code> that would
     * result in an invalid move.
     * 
     * @param world
     *            ArenaWorld instance
     * @param animal
     *            ArenaAnimal instance
     * @param possibleMoveDirections
     *            a non-empty list of directions
     * 
     * @return a list of valid directions to move.
     */
    private List<Direction> removeInvalidDirections(ArenaWorld world, ArenaAnimal animal,
            List<Direction> possibleMoveDirections) {

        List<Direction> possibleValidMoveDirections = new ArrayList<Direction>();

        for (Direction thisDir : possibleMoveDirections) {
            Location targetLocation = new Location(animal.getLocation(), thisDir);
            if (Util.isValidLocation(world, targetLocation) && isLocationEmpty(world, animal, targetLocation)) {
                possibleValidMoveDirections.add(thisDir);
            }
        }

        return possibleValidMoveDirections;
    }

    /**
     * Picks a random direction contained in <code>possibleMoveDirections</code>
     * 
     * @param possibleMoveDirections
     *            a non-empty list of directions
     * 
     * @return a random direction contained in
     *         <code>possibleMoveDirections</code>
     */
    private static Direction getRandomDirection(List<Direction> possibleMoveDirections) {
        Direction thisDir;
        do{
            thisDir = Util.getRandomDirection();
        }while( !possibleMoveDirections.contains(thisDir) );
        
        return thisDir;
    }

    /**
     * Returns a possible item located in the adjacent tile of the current position to eat
     * 
     * @param world
     *            ArenaWorld instance
     * @param animal
     *            ArenaAnimal instance
     * 
     * @return item to eat, <code>null</code> if there's no available item to eat in the adjacent tiles
     */
    private static Item getNextAdjacentPreyToEat(ArenaWorld world, ArenaAnimal animal) {
        Set<Item> possibleEats = world.searchSurroundings(animal);
        Location current = animal.getLocation();
        Iterator<Item> it = possibleEats.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if ((item.getName().equals("grass")) && (current.getDistance(item.getLocation()) == 1)) {
                return item;
            }
        }
        return null;
    }
}