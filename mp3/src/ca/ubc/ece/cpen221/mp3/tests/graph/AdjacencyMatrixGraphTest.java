package ca.ubc.ece.cpen221.mp3.tests.graph;


import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjacencyMatrixGraphTest {
    private Vertex v1=new Vertex("1");
    private Vertex v2=new Vertex("2");
    private Vertex v3=new Vertex("3");
    private Vertex v4=new Vertex("4");
    private Vertex v5=new Vertex("5");
    private Vertex v6=new Vertex("6");

    @Test
    public void test1(){
        Graph g=new AdjacencyMatrixGraph();
        g.addVertex(v1);
        g.addVertex(v3);
        g.addEdge(v1,v2);
        assertEquals(false,g.edgeExists(v1,v2));
        g.addVertex(v5);
        g.addEdge(v1,v5);
        assertEquals(true,g.edgeExists(v1,v5));
        assertEquals(false,g.edgeExists(v5,v1));
        //v1,v3,v5
        System.out.println(g.getVertices());
        g.addVertex(v6);
        g.addEdge(v1,v3);
        g.addEdge(v3,v1);
        //v3,v5
        System.out.println(g.getDownstreamNeighbors(v1));
        //v1
        System.out.println(g.getDownstreamNeighbors(v3));
        //v3
        System.out.println(g.getUpstreamNeighbors(v1));
        g.addVertex(v4);
        g.addEdge(v1,v4);
        System.out.println(g.getDownstreamNeighbors(v1));

    }
}
