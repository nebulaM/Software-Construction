package ca.ubc.ece.cpen221.mp3.graph;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

import java.util.*;

public class AdjacencyMatrixGraph implements Graph {
private Map<Vertex,Set<Vertex>> mGraph;
    public AdjacencyMatrixGraph(){
        mGraph=new HashMap<>();
    }

    @Override
    public void addVertex(Vertex v){
        if(!mGraph.containsKey(v)){
            mGraph.put(v,new HashSet<>());
        }else {
            System.out.println("@addVertex: Vertex "+v.toString()+" already in graph");
        }
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2){
        if(!v1.equals(v2) && mGraph.containsKey(v1) && mGraph.containsKey(v2)){
            mGraph.get(v1).add(v2);
        }else{
            if(v1.equals(v2)){
                System.out.println("@addEdge: Vertex v1 " + v1.toString() + " equals to v2");
            }else {
                System.out.println("@addEdge: Vertex v1 or Vertex v2 not in graph");
            }
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2){
        return mGraph.get(v1).contains(v2);
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v){
        if(mGraph.containsKey(v)){
            List downStreamList=new ArrayList();
            for(Vertex dv:mGraph.get(v)){
                downStreamList.add(dv);
            }
            return downStreamList;
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v){
        List<Vertex> list=new ArrayList<>();
        for(Vertex key: mGraph.keySet()){
            if(mGraph.get(key).contains(v)){
                list.add(key);
            }
        }
        return list;
    }

    @Override
    public List<Vertex> getVertices(){
        List<Vertex> list=new ArrayList<>();
        for(Vertex key: mGraph.keySet()){
            list.add(key);
        }
        return list;
    }
}
