package GrokkingCodingInterview.datastructure.Graph;

import GrokkingCodingInterview.datastructure.Stack.Stack;

import java.util.Arrays;


public class CheckPaths {
/*
    graph =
    {
        0 -> 1, 0 -> 5
        1 -> 2, 1 -> 3
        4 -> 2, 4 -> 5,
        2 -> 5,
        5 -> 6, 5 -> 7, 5 -> 3
        6 -> 7
    }
    source = 0
    destination = 6
 */

    public static boolean checkPath1(Graph g, int source, int destination) {
        // Write - Your - Code
        int [] UF = new int[destination];
        int vertices= g.vertices;
        int count =0;
        Arrays.fill(UF,-1);

        while(count<vertices){
            DoublyLinkedList<Integer>.Node tmp = null;
            if(g.adjacencyList[count]!=null){
                tmp = g.adjacencyList[count].headNode;
            }
            while(tmp!=null && tmp.nextNode!=null){
                if(tmp.data==source){
                    UF[source] = tmp.nextNode.data;
                    source = tmp.nextNode.data;
                }
                tmp = tmp.nextNode;
            }
            count++;
        }

        boolean val =false;
        val =checkHelper(source, destination, UF);


        return val;
    }

    private static boolean checkHelper(int source, int destination, int[] UF) {

            if(checkNext(UF,source)!=-1){
                source = checkNext(UF,source);
                if(source==destination){
                    return true;
                }else{
                    checkHelper(source,destination,UF);
                }
            }else {
                return false;
            }
        return false;
    }

    private static int checkNext(int[] uf, int source) {
        return uf[source];
    }




        //Perfrom DFS Traversal starting from source and if you reach destination
        //then it means that there exist a path between source and destination
        //so return true and if you traverse the graph but can't reach destination
        //then simply return false.
        public static boolean checkPath(Graph g, int source, int destination) {
            if (source == destination){
                return true;
            }
            //Boolean Array to hold the history of visited nodes (by default-false)
            //Make a node visited whenever you push it into stack
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
            } //end of while
            return false;
        }
        public static void main(String args[]) {

            Graph g1 = new Graph(9);
            g1.addEdge(0,2);
            g1.addEdge(0,5);
            g1.addEdge(2,3);
            g1.addEdge(2,4);
            g1.addEdge(5,3);
            g1.addEdge(5,6);
            g1.addEdge(3,6);
            g1.addEdge(6,7);
            g1.addEdge(6,8);
            g1.addEdge(6,4);
            g1.addEdge(7,8);
            g1.printGraph();
            System.out.println("Path exists: " + checkPath(g1, 0, 7));
            System.out.println();
            Graph g2 = new Graph(4);
            g2.addEdge(0,1);
            g2.addEdge(1,2);
            g2.addEdge(1,3);
            g2.addEdge(2,3);

            g2.printGraph();
            System.out.println("Path exists: " + checkPath(g2, 3, 0));
        }

}
