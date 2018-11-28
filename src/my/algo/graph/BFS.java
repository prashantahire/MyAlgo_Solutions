

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


        System.out.println("Start Node :" + startNode);
        // keep track of visited nodes and level of node
        int[] visited = new int[graph.vertices];

        // to keep track of parent node for current node
        int[] parent = new int[graph.vertices];

        // initialize with -1 to indicate not visited
        for (int i = 0; i < graph.vertices; i++) {
            visited[i] = -1;
            parent[i] = -1;
        }

        // to keep track of next adjacent node to visit for given node
        LinkedList<Integer> queue = new LinkedList<>();

        // to keep track of level
        int level = 0;
        // Start algo implementation

        // initialize for start node
        queue.add(startNode);
        visited[startNode] = level;
        level++;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            List<Integer> adjacentNodes = graph.adj[node];
            for (Integer adjNode : adjacentNodes) {
                if (visited[adjNode] == -1) {
                    visited[adjNode] = level;
                    parent[adjNode] = node;
                    queue.add(adjNode);
                    System.out.println(" Visited " + adjNode);
                }
            }
            level++;
        }
        System.out.println("Level of tree " + level);
        for (int i = 0; i < parent.length; i++) {
            System.out.println("Node :" + i + " " + " Parent node: " + parent[i]);
        }
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
