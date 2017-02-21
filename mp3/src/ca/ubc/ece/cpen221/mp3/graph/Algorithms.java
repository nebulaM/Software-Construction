package ca.ubc.ece.cpen221.mp3.graph;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
import org.omg.CORBA.portable.ValueInputStream;

import java.util.*;

public class Algorithms {

	/**
	 * *********************** Algorithms ****************************
	 *
	 * Please see the README for the machine problem for a more detailed
	 * specification of the behavior of each method that one should implement.
	 */

	/**
	 * This is provided as an example to indicate that this method and other
	 * methods should be implemented here.
	 *
	 * You should write the specs for this and all other methods.
	 *
	 * @param graph
	 * @param a
	 * @param b
	 * @return
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		// TODO: Implement this method and others
		return 0;
	}

	/**
	 * Perform a complete depth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param graph saves edge of vertices, not null
	 * @return
	 */
	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		if(graph==null){
			throw new IllegalArgumentException("@depthFirstSearch: input graph is null");
		}

		return null; // this should be changed

	}

	/**
	 * Perform a complete breadth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a BFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param graph saves edge of vertices, not null
	 * @return Set of list of vertices visited by each vertex in graph, end->start
	 */
	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		// TODO: Implement this method
        if(graph==null){
            throw new IllegalArgumentException("@depthFirstSearch: input graph is null");
        }
        Set<List<Vertex>> bfsResult=new HashSet<>();
        List<Vertex> gVertices=graph.getVertices();
        Vertex dummy=new Vertex("");
        for(Vertex v: gVertices){
            v.setParent(dummy);
        }
        for(Vertex start : gVertices){
            for(Vertex end : gVertices) {
                if (end.hashCode()!=start.hashCode()) {
                    Queue<Vertex> q = new LinkedList<>();
                    Set<Vertex> visited = new HashSet<>();
                    q.add(start);
                    while (!q.isEmpty()) {
                        Vertex curr = q.remove();
                        if(curr.hashCode()==end.hashCode()){
                            //add new route from end to start
                            List<Vertex> route = new ArrayList<>();
                            while (curr.getParent().hashCode()!=start.hashCode()){
                                route.add(curr);
                                curr=curr.getParent();
                            }
                            //last two vertices
                            route.add(curr);
                            route.add(start);
                            bfsResult.add(route);
                            break;
                        }
                        for (Vertex w : graph.getDownstreamNeighbors(curr)) {
                            if (!visited.contains(w)) {
                                w.setParent(curr);
                                q.add(w);
                                visited.add(w);
                            }
                        }
                    }
                }
            }
        }
		return bfsResult;
	}

	/**
	 * You should write the spec for this method
	 */
	 public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {
		 // TODO: Implement this method
 		return null; // this should be changed
	 }

	 /**
 	 * You should write the spec for this method
 	 */
 	 public static List<Vertex> commonDownstreamVertices(Graph graph, Vertex a, Vertex b) {
 		 // TODO: Implement this method
  		return null; // this should be changed
 	 }


}
