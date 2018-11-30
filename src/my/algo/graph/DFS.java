
package my.algo.graph;

import java.util.Stack;

//Assumption: Graph nodes are int. Need to change data-structure based on type of node
public class DFS {
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
}
