package GrokkingCodingInterview.dynamicprogpatrn.GraphAlgos;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int vertices; //number of vertices
    private LinkedList < Integer > adjacencyList[]; //Adjacency Lists
    @SuppressWarnings("unchecked")
        // Constructor
    Graph(int vert) {
        this.vertices = vert;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < this.vertices; ++i)
            this.adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }
    public Graph getTranspose() {
        Graph g = new Graph(vertices);
        for (int j = 0; j < vertices; j++) {
            Iterator< Integer > i = adjacencyList[j].listIterator();
            while (i.hasNext())
                g.adjacencyList[i.next()].add(j);
        }
        return g;
    }
    public void dfsTraversal(int v, boolean visited[]) {
        visited[v] = true;
        int source = 0;


        Iterator < Integer > i = adjacencyList[v].iterator();
        Integer temp;
        while (i.hasNext()) {
            temp = i.next();
            if (!visited[temp])
                dfsTraversal(temp, visited);
        }
    }
    void printGraph() {

        for (int v = 0; v < this.vertices; v++) {
            System.out.print(v);
            for (Integer pCrawl: this.adjacencyList[v]) {
                System.out.print("->" + pCrawl);
            }
            System.out.print("\n");
        }
    }




    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
    }
}