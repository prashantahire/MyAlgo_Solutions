package my.algo.greedymethod;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Works with directed/non-directed non negative graph.
//Time complexity with array O(V^2 +E )... With PQ (V*logV+E*logV)
public class Dijkstra {
    public void dijkstra(WGraph graph) {

        List<Integer> shortestPathSet = new ArrayList<>();

        int predecessor[] = new int[graph.vertices];

        int distance[] = new int[graph.vertices];
        boolean visited[] = new boolean[graph.vertices];
        //initialize relaxation distance array
        for (int i = 0; i < graph.vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // initialize distance array OR Minheap/PQ can be used
        distance[0] = 0;        
        for (int i = 0; i < graph.vertices; i++) {
            int minNode = extractMinNode(distance, visited);
            shortestPathSet.add(minNode);
            for (WNode adjNode : graph.adj[minNode]) {
                if (distance[adjNode.value] > distance[minNode] + adjNode.weight) {
                    distance[adjNode.value] = distance[minNode] + adjNode.weight;
                    predecessor[adjNode.value] = minNode;
                }
            }
            visited[minNode] = true;
        }
        
        System.out.println("Shortest Path nodes sequence : "+shortestPathSet);
        
        System.out.println("Shortest path distances : ");
        for(int i=0; i<graph.vertices; i++) {
            System.out.println(" "+i+" : "+ distance[i]);
        }
        
        System.out.println("Predecessors : ");
        for(int i=0; i<graph.vertices; i++) {
            System.out.println(" " + i + " -> " + predecessor[i] );
        }
    }    
    private int extractMinNode(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minNode = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && min > distance[i]) {
                min = distance[i];
                minNode = i;
            }
        }
        return minNode;
    }
}
class WGraph {
    int vertices;
    List<WNode>[] adj;

    @SuppressWarnings("unchecked")
    WGraph(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    void addEdge(int u, int v, int wt) {
        adj[u].add(new WNode(v, wt));
    }
}


class WNode {
    int value;
    int weight;

    public WNode(int val, int wt) {
        this.value = val;
        this.weight = wt;
    }
}
