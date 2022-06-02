package GrokkingCodingInterview.dynamicprogpatrn.GraphAlgos;

class Connected {
    public static boolean isConnected(Graph g) {

        int numofVertices = g.getVertices();
        boolean visited[] = new boolean[numofVertices];
        // Using depth first traversal
        g.dfsTraversal(0, visited);
        //if there are unvisited vertices then graph is divided into components
        for (int i = 1; i < numofVertices; i++)
            if (visited[i] == false)
                return false;

        return true;
    }

    public static Object willCauseSeparateComponents(Graph g, int source, int destination) {
        // remove the edge from both sides because graph is bidirectional
        g.getAdj()[source].remove(g.getAdj()[source].indexOf(destination));
        g.getAdj()[destination].remove(g.getAdj()[destination].indexOf(source));

        //check whether the graph is connected or not
        boolean result = isConnected(g);

        if (result == false) //if graph is not connected then components created
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);

        // remove edge 3 -> 4
        Object x = Connected.willCauseSeparateComponents(g, 3, 4);
        System.out.println("Separate components created due to deletion of edge 3 -> 4? " + x);

        // remove edge 1 -> 2
        x = Connected.willCauseSeparateComponents(g, 1, 2);
        System.out.println("Separate components created due to deletion of edge 1 -> 2? " + x);

    }
}
