package GrokkingCodingInterview.datastructure.Graph;

import GrokkingCodingInterview.datastructure.Stack.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckMin2 {

    public static int findShortestPathLength(Graph g, int source, int destination) {
        //Write -- Your -- Code
        List<Integer> pathSize= new ArrayList<>();
        if(checkPath(g,source,destination)){
            pathSize= new ArrayList<>();
        }

        Collections.sort(pathSize);

        return pathSize.size()<1 ? 0 : pathSize.get(0);
    }

    public static boolean checkPath(Graph g, int source, int destination) {
        if (source == destination){
            return true;
        }
        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        if (checkPathHelper(g, source, destination)) return true;
        return false;
    }

    private static boolean checkPathHelper(Graph g, int source, int destination) {
        boolean[] visited = new boolean[g.vertices];
        //Create Stack
        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        visited[source] = true;
        //Traverse while stack is not empty
        while (!stack.isEmpty()) {
            //Pop a vertex/node from stack
            int current_node = stack.pop();
            //Get adjacent vertices to the current_node from the array,
            //and if only push unvisited adjacent vertices into stack
            //Before pushing into stack, check if it's the destination.
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;
            if (innerPathHelper(destination, visited, stack, temp)) return true;
        } //end of while
        return false;
    }

    private static boolean innerPathHelper(int destination, boolean[] visited, Stack<Integer> stack, DoublyLinkedList<Integer>.Node temp) {
        while (temp != null) {
            if (!visited[temp.data]) {
                if (temp.data == destination) {
                    return true;
                }
                stack.push(temp.data);
                visited[temp.data] = true;
            }
            temp = temp.nextNode;
        }
        return false;
    }

}
