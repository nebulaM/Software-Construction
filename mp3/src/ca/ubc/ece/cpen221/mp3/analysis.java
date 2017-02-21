package ca.ubc.ece.cpen221.mp3;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class analysis {
    public static void main(String[] args) throws IOException{
        Graph mGraph=new AdjacencyMatrixGraph();
        Scanner console= new Scanner(System.in);
        String choice="l";
        boolean loopMain=true;
        while(true){
            loopMain=true;
            if(choice.length()>0) {
                if (choice.charAt(0) == 'l' || choice.equals("load")) {
                    System.out.println("load in data, enter path of the data: ");
                    String url = console.nextLine().trim();
                    if (url.length() > 0) {
                        if (isURL(url)) {
                            System.out.println("Downloading from " + url + " ...");
                        }
                        try {
                            mGraph = processGraphFromFileOrURL(url);
                            printGraph(mGraph);

                        } catch (MalformedURLException mfurle) {
                            System.out.println("Badly formatted URL: " + url);
                        } catch (FileNotFoundException fnfe) {
                            System.out.println("Web page or file not found: " + url);
                        } catch (IOException ioe) {
                            System.out.println("I/O error: " + ioe.getMessage());
                        }
                    } else {
                        System.out.println("url cannot be empty");
                    }
                } else if (choice.charAt(0) == 'p' || choice.equals("print")) {
                    printGraph(mGraph);
                } else if (choice.charAt(0) == 'q' || choice.equals("query")) {
                    if (mGraph.size() == 0) {
                        System.out.println("Please load data into graph first");
                        choice = "load";
                        loopMain = false;
                    } else {
                        queryGraph(mGraph, console);
                    }
                } else if (choice.equals("quit")) {
                    break;
                }
            }
            if(loopMain) {
                System.out.println("(l)oad, (p)rint, (q)uery, (h)elp, quit?");
                choice = console.nextLine().trim().toLowerCase();
            }
        }
    }

    /** Returns true if the given string represents a URL. */
    public static boolean isURL(String address) {
        return address.startsWith("http://") || address.startsWith("https://") ||
                address.startsWith("www.") ||
                address.endsWith("/") ||
                address.endsWith(".com") || address.contains(".com/") ||
                address.endsWith(".org") || address.contains(".org/") ||
                address.endsWith(".edu") || address.contains(".edu/") ||
                address.endsWith(".ca")  || address.contains(".ca/") ||
                address.endsWith(".gov") || address.contains(".gov/");
    }

    /**
     * Returns an input stream to read from the given address.
     * Works with URLs or normal file names.
     */
    public static InputStream getInputStream(String address)
            throws IOException
    {
        if (isURL(address)) {
            return new URL(address).openStream();
        } else {
            // local file
            return new FileInputStream(address);
        }
    }


    /**
     * read data from a file/url and put data into graph
     */
    public static Graph processGraphFromFileOrURL(String address) throws IOException {
        InputStream stream = getInputStream(address);   // open file
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
        String line;
        Graph graph=new AdjacencyListGraph();
        while ((line=reader.readLine())!=null) {
            String noSpace=line.trim();
            String[] ids=noSpace.split("->");
            //trim is necessary!!!
            Vertex v0=new Vertex(ids[0].trim());
            Vertex v1=new Vertex(ids[1].trim());
            graph.addVertex(v0);
            graph.addVertex(v1);
            //v0 -> v1 means v1 follows v0
            graph.addEdge(v1,v0);
        }
        System.out.println("Finished reading data into graph");

        return graph;
    }

    public static void printGraph(Graph graph){
        int count=graph.size()<20?graph.size():20;
        List<Vertex> print=graph.getVertices();
        System.out.println("print first "+count+" vertices in graph");
        for(int i=0;i<count;i++){
            System.out.println(print.get(i));
        }
    }

    public static void queryGraph(Graph graph, Scanner sn){
        System.out.println("example usage: ");
        System.out.println("ci 14838508 98032178 ?");
        System.out.println("nr 14838508 98032178 ?");
        System.out.println("quit to go to upper level");
        while(true) {
            String in = sn.nextLine();
            if(in.length()>0) {
                if (in.endsWith("?")) {
                    String[] args = in.split(" ");
                    System.out.println("args[1] " + args[1]);
                    System.out.println("args[2] " + args[2]);
                    if (args[0].equals("ci")) {
                        System.out.println("commonInfluencers " + Algorithms.commonDownstreamVertices(graph, new Vertex(args[1].trim()), new Vertex(args[2].trim())));
                    } else if (args[0].equals("nr")) {
                        int cost=Algorithms.shortestDistance(graph, new Vertex(args[1].trim()), new Vertex(args[2].trim()));
                        if(cost==Algorithms.NO_EDGE){
                            System.out.println("retweet from "+args[1]+" to "+args[2]+" is not possible");
                        }
                        else if(cost>0){//cost =0 means args[1] follows args[2]
                            //[re]tweet, so exclude the first tweet
                            cost--;
                        }
                        System.out.println("numRetweets " + cost);
                    }
                } else if (in.equals("print")) {
                    printGraph(graph);
                } else if (in.equals("quit")) {
                    break;
                } else {
                    System.out.println("invalid input");
                }
            }
        }
    }
}
