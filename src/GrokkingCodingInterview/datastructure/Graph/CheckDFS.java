package GrokkingCodingInterview.datastructure.Graph;

import GrokkingCodingInterview.datastructure.Stack.Stack;

public class CheckDFS {
    //Depth First Traversal of Graph g
    public String dfs(Graph g) {
        StringBuffer result = new StringBuffer();
        if (g.vertices < 1){
            return result.toString();
        }

        boolean isVisited[] = new boolean[g.vertices];

        for(int i=0;i<isVisited.length;i++){
            if(!isVisited[i])
                result.append(dfsHelper(isVisited,i,g));
        }
        return result.toString();
    }

    StringBuffer dfsHelper(boolean[] isVisited, int i, Graph g){
        StringBuffer sb = new StringBuffer();
        Stack<Integer> st = new Stack<>(g.vertices);
        st.push(i);

        while (!st.isEmpty()){
            int current_node = (int)st.pop();
            sb.append(current_node);
            DoublyLinkedList<Integer>.Node tmp = null;

            if(g.adjacencyList[current_node].headNode!=null){
                tmp = g.adjacencyList[current_node].headNode;
            }

            while(tmp!=null){
                if(!isVisited[tmp.data]){
                    st.push(tmp.data);
                }
                tmp = tmp.nextNode;
            }

            isVisited[current_node] = true;
        }

       return sb;
    }


    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        CheckDFS checkDFS = new CheckDFS();

        System.out.println("BFS traversal of Graph1 : " +checkDFS.dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        System.out.println("BFS traversal of Graph2 : " + checkDFS.dfs(g2));
    }
}