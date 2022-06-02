package GrokkingCodingInterview.datastructure.Graph;

public class CheckNumEdges {
    public static int numEdges(Graph g) {
        // Write -- Your -- Code

        int vertices= g.vertices;
        int count =0;
        int numEdges=0;

        while(count<vertices){
            DoublyLinkedList.Node tmp = null;
            if(g.adjacencyList[count]!=null){
                tmp = g.adjacencyList[count].headNode;
            }
            while(tmp!=null){
                numEdges+=1;
                tmp = tmp.nextNode;
            }
            count++;
        }
        return numEdges;
    }
}
