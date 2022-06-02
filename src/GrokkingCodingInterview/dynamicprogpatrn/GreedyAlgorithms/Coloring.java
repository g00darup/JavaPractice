package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
Problem statement #
Graph coloring involves finding a way of coloring the vertices of a graph.

Implement a function that finds a way of coloring a graph so that no two adjacent vertices are colored using the same color. Try using the minimum number of colors possible.

Input #
The input is an undirected graph with no colors assigned.

Output #
The output is a graph with all of its vertices colored in the correct way, using the minimum number of colors possible.

Sample input #
Graph:

graph {0 -- 1
       0 -- 2
       1 -- 2
       1 -- 3
       2 -- 3
       3 -- 4}
Sample output #
Vertex 0 , Color 0
Vertex 1 , Color 1
Vertex 2 , Color 2
Vertex 3 , Color 0
Vertex 4 , Color 1
 */
public class Coloring {
    public static void greedyColoring(Graph g) {
        int numofVertices = g.getVertices();
        int[] result = new int[numofVertices];

        //Initialize vertices as unassigned
        Arrays.fill(result, -1);

        //Assign the first color to first vertex
        result[0] = 0;

        boolean[] available = new boolean[numofVertices];
        // Assign colors to remaining V-1 vertices
        Arrays.fill(available, true);
        LinkedList < Integer > Llist[];
        Llist = g.getAdj();
        for (int i = 1; i < numofVertices; i++) {

            Iterator< Integer > var = Llist[i].iterator();
            while (var.hasNext()) {

                int temp = var.next();
                // Find the first available color
                if (result[temp] != -1) {
                    available[result[temp]] = false;
                }
            }
            int j;
            for (j = 0; j < numofVertices; j++) {
                if (available[j]) {
                    break;
                }
            }

            result[i] = j; // Assign the found color
            //reset the values
            Arrays.fill(available, true);
        }
        for (int i = 0; i < numofVertices; i++) {
            System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);

        Coloring.greedyColoring(g1);
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        Coloring.greedyColoring(g2);
    }
}



class Graph {
    private int vertices; //number of vertices
    private LinkedList< Integer > adjacencyList[]; //Adjacency Lists
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
        this.adjacencyList[destination].add(source);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }
};