package beaconsOfGondor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LocateMinasTirith {

    /**
     *
     * @param numLocations
     *            the number of cities in the kingdom, 0 < numCities < 50.
     * @param roadNetwork
     *            represents the roads connecting different cities in the
     *            kingdom. roadNetwork.length( ) is equal to
     *            numLocations*numLocations. For all i, j such that 0 <= i <
     *            numLocations and 0 <= j < numLocations, the character at index
     *            numLocations*i+j in this string indicates if there is a road
     *            between cities i and j (1 if there is and 0 if there is no
     *            road). For all i such that 0 <= numLocations < i, the
     *            character at index numLocations*i+i is 1. <strong>The roadNetwork
     *            represents a connected graph.</strong>
     * @return a set of city indices with the following condition: the maximum
     *         travel time from a city (represented by its index) is as small as
     *         possible. The travel time from one city to another is the number
     *         of roads to traverse to get from one to the other. For a given
     *         city, its maximum travel time is the time to reach that city that
     *         is farthest from it in terms of number of roads traversed.
     */
    public static Set<Integer> getGoodLocations(int numLocations, String roadNetwork) {
        int minCost=Integer.MAX_VALUE;
        Set<Integer> cost=new HashSet<>();
        for(int i=0;i<numLocations;i++){
            int tempCost=0;
            for(char j=0;j<numLocations;j++) {
                if(j!=i){
                    tempCost+=cost(i,j,roadNetwork,numLocations);
                }
            }
            System.out.println("cost for city "+i+" is "+tempCost);
            //same cost, simply add this solution
            if(tempCost==minCost) {
                cost.add(i);
            }else if(tempCost<minCost){
                minCost=tempCost;
                //clear all previous results
                cost.clear();
                cost.add(i);
            }
        }
        return cost;
    }

    /**
     * breath first search to get cost from start to end
     * @param start index to start
     * @param end index to end(goal is to reach this)
     * @param roadNetwork vertex info
     * @param networkSize how many nodes
     * @return cost from start to end
     */
    private static int cost(int start, int end, String roadNetwork, int networkSize){
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        //array tracks node parent, index represents node, content represents parent of node
        int[] parent=new int[networkSize];
        int cost=1;
        q.add(start);
        while(!q.isEmpty()){
            int current=q.remove();
            if(current==end){
                //add up cost until we reach start
                while(parent[current]!=start){
                    //cost is always 1
                    cost++;
                    current=parent[current];
                }
                return cost;
            }
            for(int i=0;i<networkSize;i++){
                //location [i][current] in roadNetwork is index
                int index= i*networkSize+current;
                if(roadNetwork.charAt(index)=='1'){
                    if(!visited.contains(i)){
                        visited.add(i);
                        q.add(i);
                        parent[i]=current;
                    }
                }
            }
        }
        return cost;
    }
}
