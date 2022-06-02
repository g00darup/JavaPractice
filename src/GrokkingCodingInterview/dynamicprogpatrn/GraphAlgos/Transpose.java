package GrokkingCodingInterview.dynamicprogpatrn.GraphAlgos;

import java.util.LinkedList;

public class Transpose {
    public static void getTranspose(Graph g) {
        int num_of_vertices = g.getVertices();
        //creating new graph
        Graph transposedGraph = new Graph(num_of_vertices);
        LinkedList< Integer > Llist[];
        Llist = g.getAdj();
        //transposing the graph
        for (int v = 0; v < g.getVertices(); v++) {

            for (int i = 0; i < Llist[v].size(); i++) {
                //Now the source is destination and vice versa
                transposedGraph.addEdge(Llist[v].get(i), v);

            }

        }
        //printing the graph
        transposedGraph.printGraph();
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        System.out.println("Transpose of given Graph: ");
        Transpose.getTranspose(g1);
    }
}
