

package my.algo.graph;


import java.util.LinkedList;
import java.util.List;


//Assumption: Graph nodes are int. Need to change datastructure based on type of node
public class BFS {

    /**
     * Visits all the node with complexity O(V+E)
     * 
     * @param startNode
     * @param graph
     */
    public void bfsTraversal(int startNode, Graph graph) {

 
    }
}


class Graph {
    int vertices;
    List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Graph(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }
}
