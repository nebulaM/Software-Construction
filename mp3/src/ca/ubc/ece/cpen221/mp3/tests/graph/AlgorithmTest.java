package ca.ubc.ece.cpen221.mp3.tests.graph;


import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
import org.junit.Test;

public class AlgorithmTest {
    private Vertex v1=new Vertex("1");
    private Vertex v2=new Vertex("2");
    private Vertex v3=new Vertex("3");
    private Vertex v4=new Vertex("4");
    private Vertex v5=new Vertex("5");
    private Vertex v6=new Vertex("6");
    private Graph graph;

    @Test
    public void test1(){
        initGraph();
        graph.addEdge(v1,v2);
        graph.addEdge(v1,v3);
        graph.addEdge(v1,v6);
        graph.addEdge(v2,v4);
        graph.addEdge(v2,v5);
        graph.addEdge(v4,v3);
        graph.addEdge(v5,v1);
        graph.addEdge(v5,v2);
        graph.addEdge(v5,v6);
        graph.addEdge(v6,v2);
        graph.addEdge(v6,v3);
        graph.addEdge(v6,v4);
        System.out.println("downstream vertices for v1-v6: ");
        for(Vertex v : graph.getVertices()) {
            System.out.print(graph.getDownstreamNeighbors(v));
        }
        System.out.println();
        System.out.println("transversed graph: ");
        System.out.println(Algorithms.breadthFirstSearch(graph));
    }


    private void initGraph(){
        graph=new AdjacencyMatrixGraph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
    }
}
