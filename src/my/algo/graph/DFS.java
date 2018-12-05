

package my.algo.graph;

import java.util.Stack;

//Assumption: Graph nodes are int. Need to change data-structure based on type of node
public class DFS {
    
    //This is solved using recursion. Can be solved using stack if don't want to use recursion
    //Time complexity O(V+E)
    public void dfsTraversal(Graph graph) {
        int parent[] = new int[graph.vertices];
        for(int i=0;i<graph.vertices;i++) {
            parent[i] = -1;
        }
        
        for(int vertex=0; vertex<graph.vertices; vertex++) {
            if(parent[vertex] ==-1) {
                parent[vertex] = vertex;
                System.out.println("Visited : "+vertex);
                dfsVisit(vertex, parent, graph);
               // System.out.println("Visit complete : "+vertex);
            }
        }
    }

    private void dfsVisit(int node, int parent[], Graph graph) {        
        for(int v : graph.adj[node]) {
            if(parent[v] == -1) {
                parent[v] = node;
                System.out.println("Visit Start: "+v);
                dfsVisit(v, parent, graph);
                //System.out.println("Visit Complete "+v);
            }
        }
    }
    
    public void dfsStack(Graph graph) {
        
        Stack<Integer> dfsStack = new Stack<>();
        int visited[] = new int[graph.vertices];
        //push start vertex
        
        
        for(int i=0; i<graph.vertices; i++) {
            if(visited[i] != 1)
                   dfsStack.push(i);
            while(!dfsStack.isEmpty()) {
                int temp = dfsStack.pop();
                visited[temp] = 1;
                System.out.println("Visited : "+temp);
                for(int adjNode : graph.adj[temp]) {
                    if(visited[adjNode] != 1) {
                        dfsStack.push(adjNode);
                    }
                }
            }            
        }
    }
    public static void main(String... args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);

        Graph graph2 = new Graph(8);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 4);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 7);
        graph2.addEdge(3, 4);
        graph2.addEdge(4, 3);
        graph2.addEdge(5, 1);
        graph2.addEdge(5, 6);
        graph2.addEdge(6, 2);

        new DFS().dfsTraversal(graph);
        System.out.println("==============");
        new DFS().dfsTraversal(graph2);
        new DFS().dfsStack(graph2);

    }
}
