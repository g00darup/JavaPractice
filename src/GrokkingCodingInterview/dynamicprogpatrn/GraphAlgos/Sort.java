package GrokkingCodingInterview.dynamicprogpatrn.GraphAlgos;

import java.util.Iterator;
import java.util.Stack;

public class Sort {
    public static void utilityFunction(Graph g, int v, boolean visited[], Stack< Integer > myStack) {
        // Mark the current node v as visited.
        visited[v] = true;
        // traverse all the vertices adjacent to this
        // vertex and do a recursive call to the utility function for these
        Iterator< Integer > i = g.getAdj()[v].iterator();
        Integer temp;
        while (i.hasNext()) {

            temp = i.next();
            if (!visited[temp])
                utilityFunction(g, temp, visited, myStack);
        }
        // Push current vertex in to the stack
        myStack.push(v);
    }
    @SuppressWarnings("unchecked")
    public static void topologicalSort(Graph g) {
        Stack < Integer > myStack = new Stack();
        // all the vertices marked as not visited by default
        int numofVertices = g.getVertices();
        boolean visited[] = new boolean[numofVertices];
        // Call the utility function for
        // Topological Sort from all vertices
        for (int i = 0; i < numofVertices; i++) {
            if (visited[i] == false) {
                utilityFunction(g, i, visited, myStack);
            }
        }
        //print the contents of the stack
        while (myStack.empty() == false) {
            System.out.print(myStack.pop() + " ");

        }
    }

    public static void main(String args[]) {

        Graph g = new Graph(6);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 2);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Graph1 Topological Sort: ");
        Sort.topologicalSort(g);
        System.out.println();

        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(0, 3);

        System.out.println("Graph2 Topological Sort: ");
        Sort.topologicalSort(g1);

    }
}