package GrokkingCodingInterview.datastructure.Graph;

import GrokkingCodingInterview.datastructure.Stack.Queue;

public class CheckBFS {

    //Breadth First Traversal of Graph g
    public static String bfs2(Graph g) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        int vertices= g.vertices;
        Queue qu = new Queue(vertices);

        qu.enqueue(g.adjacencyList);
        DoublyLinkedList d = (DoublyLinkedList) qu.dequeue();
        while (d!=null && !d.isEmpty() && d.headNode!=null){
            sb.append(d.headNode.data);
            d.headNode = d.headNode.nextNode;
        }
        vertices = vertices--;
        g = new Graph(vertices);

        return bfs(g);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        CheckBFS checkBFS = new CheckBFS();

        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }

    static String bfs(Graph g){
        StringBuffer result = new StringBuffer();

        if(g.vertices < 1){
            return result.toString();
        }

        boolean[] visited = new boolean[g.vertices];

        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                result.append(bfsVisit(g,i,visited));
            }
        }
        return result.toString();
    }

    static StringBuffer bfsVisit(Graph g, int src, boolean[] visited){
        StringBuffer result = new StringBuffer();
        int vertices= g.vertices;
        Queue q = new Queue(vertices);

        q.enqueue(src);
        visited[src]=true;

        while(!q.isEmpty()){
            int current_node = (int)q.dequeue();
            result.append(current_node);

            DoublyLinkedList<Integer>.Node tmp = null;
            if(g.adjacencyList[current_node].headNode!=null){
                tmp = g.adjacencyList[current_node].headNode;
            }

            while(tmp!=null){
                if(!visited[tmp.data]){
                    q.enqueue(tmp.data);
                    visited[tmp.data] = true;
                }
                tmp = tmp.nextNode;
            }
        }

        return result;
    }


}