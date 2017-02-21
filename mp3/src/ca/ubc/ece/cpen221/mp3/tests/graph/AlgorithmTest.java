package ca.ubc.ece.cpen221.mp3.tests.graph;


import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AlgorithmTest {
    private Vertex v0=new Vertex("0");
    private Vertex v1=new Vertex("1");
    private Vertex v2=new Vertex("2");
    private Vertex v3=new Vertex("3");
    private Vertex v4=new Vertex("4");
    private Vertex v5=new Vertex("5");
    private Vertex v6=new Vertex("6");
    private Vertex v7=new Vertex("7");
    private Graph graph;

    @Test
    public void testBreadthFirstSearch_1(){
        createGraph1();
        System.out.println("downstream vertices for v0-v7: ");
        for(Vertex v : graph.getVertices()) {
            System.out.print(graph.getDownstreamNeighbors(v));
        }
        System.out.println();
        System.out.println("transversed graph bfs: ");
        System.out.println(Algorithms.breadthFirstSearch(graph));
    }

    @Test
    public void testDepthFirstSearch_1(){
        createGraph1();
        System.out.println("downstream vertices for v0-v7: ");
        for(Vertex v : graph.getVertices()) {
            System.out.print(graph.getDownstreamNeighbors(v));
        }
        System.out.println();
        System.out.println("transversed graph dfs: ");
        System.out.println(Algorithms.depthFirstSearch(graph));
    }

    @Test
    public void testSD_1_1() {
        createGraph1();
        assertEquals(2, Algorithms.shortestDistance(graph,v0,v2));
    }

    @Test
    public void testSD_1_2() {
        createGraph1();
        assertEquals(2, Algorithms.shortestDistance(graph,v0,v7));
    }

    @Test
    public void testSD_1_3() {
        createGraph1();
        assertEquals(4, Algorithms.shortestDistance(graph,v1,v7));
    }

    @Test
    public void testSD_1_4() {
        createGraph1();
        assertEquals(2, Algorithms.shortestDistance(graph,v0,v2));
    }

    @Test
    public void testSD_1_5() {
        createGraph1();
        assertEquals(Algorithms.NO_EDGE, Algorithms.shortestDistance(graph,v5,v1));
    }


    @Test
    public void testBreadthFirstSearch_2(){
        createGraph2();
        System.out.println("downstream vertices for v0-v7: ");
        for(Vertex v : graph.getVertices()) {
            System.out.print(graph.getDownstreamNeighbors(v));
        }
        System.out.println();
        System.out.println("transversed graph bfs: ");
        System.out.println(Algorithms.breadthFirstSearch(graph));
    }

    @Test
    public void testDepthFirstSearch_2(){
        createGraph2();
        System.out.println("downstream vertices for v0-v7: ");
        for(Vertex v : graph.getVertices()) {
            System.out.print(graph.getDownstreamNeighbors(v));
        }
        System.out.println();
        System.out.println("transversed graph dfs: ");
        System.out.println(Algorithms.depthFirstSearch(graph));
    }





    private void initGraph(){
        graph=new AdjacencyMatrixGraph();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
    }

    /**
     *          0-----------
     *          |          |
     *          .          |
     *          1 -> 2     |
     *             / |     |
     *           .   .     .
     *          5 -> 6  -> 4
     *          |         /
     *          |        /
     *          .      .
     *          3 -> 7
     *
     *
     *
     *
     */

    private void createGraph1(){
        initGraph();

        graph.addEdge(v0,v1);
        graph.addEdge(v0,v4);
        graph.addEdge(v1,v2);
        graph.addEdge(v2,v5);
        graph.addEdge(v2,v6);
        graph.addEdge(v3,v7);
        graph.addEdge(v4,v7);
        graph.addEdge(v5,v3);
        graph.addEdge(v5,v6);
        graph.addEdge(v6,v4);


    }

    /**
     *                  0
     *                 /|
     *               .  .
     *             3 <- 1 <- 2  4
     *                  |    | .
     *                  .    ./
     *                  5 -> 6
     *                      /
     *                     .
     *                    7
     */
    private void createGraph2(){
        initGraph();
        graph.addEdge(v0,v1);
        graph.addEdge(v0,v3);
        graph.addEdge(v1,v3);
        graph.addEdge(v1,v5);
        graph.addEdge(v2,v1);
        graph.addEdge(v2,v6);
        graph.addEdge(v5,v6);
        graph.addEdge(v6,v4);
        graph.addEdge(v6,v7);
    }
}
