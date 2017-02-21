package ca.ubc.ece.cpen221.mp3.graph;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

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
        Set<List<Vertex>> dfsResult=new HashSet<>();
        List<Vertex> gVertices=graph.getVertices();
        for(Vertex start : gVertices) {
            //dfsResult.add(dfsHelper(graph,start));
            dfsResult.add(dfsHelper(graph,start,new HashSet<>(),new ArrayList<>()));
        }
        return dfsResult;

	}

    /**
     * recursively transverse a graph using depth first search
     * @param graph not null
     * @param start vertex to start dfs
     * @param visited mark a vertex as visited after visiting the vertex
     * @param route a list from start to last vertex visited in graph
     * @return a list of vertex in @param route
     */
    private static List<Vertex> dfsHelper(Graph graph, Vertex start, Set<Vertex> visited, List<Vertex> route){
	    visited.add(start);
	    route.add(start);
	    for(Vertex v : graph.getDownstreamNeighbors(start)){
	        if(!visited.contains(v)){
	            dfsHelper(graph,v,visited,route);
            }
        }
        return route;
    }

    /**
     * non-recursive method to transverse graph using depth first search
     * @param graph not null
     * @param start vertex to start dfs
     * @return a list of vertex in @localParam route
     */
    private static List<Vertex> dfsHelper(Graph graph, Vertex start){
        List<Vertex> route = new ArrayList<>();
        Stack<Vertex> s = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        s.push(start);
        while (!s.isEmpty()) {
            Vertex curr = s.pop();
            if (!visited.contains(curr)) {
                route.add(curr);
                visited.add(curr);
                for (Vertex v : graph.getDownstreamNeighbors(curr)) {
                    s.push(v);
                }
            }
        }
        return route;
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
	 * @return Set of list of vertices visited by each vertex in graph, in bfs order
	 */
	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
        if(graph==null){
            throw new IllegalArgumentException("@depthFirstSearch: input graph is null");
        }
        Set<List<Vertex>> bfsResult=new HashSet<>();
        List<Vertex> gVertices=graph.getVertices();

        for(Vertex start : gVertices){
            List<Vertex> route = new ArrayList<>();
            Queue<Vertex> q = new LinkedList<>();
            Set<Vertex> visited = new HashSet<>();
            route.add(start);
            q.add(start);
            visited.add(start);
            while (!q.isEmpty()) {
                Vertex curr = q.remove();
                for (Vertex v : graph.getDownstreamNeighbors(curr)) {
                    if (!visited.contains(v)) {
                        q.add(v);
                        route.add(v);
                        visited.add(v);
                    }
                }
            }
            bfsResult.add(route);
        }
		return bfsResult;
	}

    /**
     *
     * @param graph not null, contains a,b
     * @param a a vertex in graph
     * @param b a vertex in graph
     * @return common upstream vertices of a and b
     */
	 public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {
         if(graph==null || a==null || b==null){
             throw new IllegalArgumentException("@commonUpstreamVertices input is null");
         }
         List<Vertex> listA=graph.getUpstreamNeighbors(a);
         List<Vertex> listB=graph.getUpstreamNeighbors(b);
         List<Vertex> commonVertices=new ArrayList<>();
         for(Vertex v : listA){
             if(listB.contains(v)){
                 commonVertices.add(v);
             }
         }
 		 return commonVertices;
	 }

    /**
     *
     * @param graph not null, contains a,b
     * @param a a vertex in graph
     * @param b a vertex in graph
     * @return common downstream vertices of a and b
     */
 	 public static List<Vertex> commonDownstreamVertices(Graph graph, Vertex a, Vertex b) {
         if(graph==null || a==null || b==null){
             throw new IllegalArgumentException("@commonUpstreamVertices input is null");
         }
         List<Vertex> listA=graph.getDownstreamNeighbors(a);
         List<Vertex> listB=graph.getDownstreamNeighbors(b);
         List<Vertex> commonVertices=new ArrayList<>();
         for(Vertex v : listA){
             if(listB.contains(v)){
                 commonVertices.add(v);
             }
         }
         return commonVertices;
 	 }
}
