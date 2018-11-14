

package my.algo.greedymethod;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class KruskalsMST {

    public static void main(String[] args) {
        int vertices = 6;
        AGraph graph = new AGraph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        new KruskalsMST().findMST(graph);
    }
    
    public void findMST(AGraph graph) {
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.edges.size(), (e1, e2) -> { return e1.weight-e2.weight;});
        
        //add all edges to min heap pq
        for(Edge edge: graph.edges) {
            pq.add(edge);
        }
        
        //create array to keep track of subsets and initialize with -1 to indicate each node itself is subset
        int[] parent = new int[graph.vertices];
        for(int i=0; i<graph.vertices; i++) {
            parent[i] = -1;
        }
        
        List<Edge> mstEdges = new ArrayList<>();
        int mstEdgeCount = 0;
        
        while(mstEdgeCount < graph.vertices-1) {
            
            Edge edge = pq.poll();
            
            //check if selected edge forms cycle or not using Disjoint sets (find-union) data structure
            int srcSet = find(parent, edge.source);
            int destSet = find(parent, edge.destination);
            
            if(srcSet != destSet) {
                
                mstEdges.add(edge);
                mstEdgeCount++;
                union(parent, srcSet, destSet);
            }
        }
        System.out.println("Kruskal's MST :  ");
        System.out.println("Edge \tWeight");
        mstEdges.forEach(edge -> {
            System.out.println(edge.source+"-"+edge.destination+" \t"+edge.weight);
        });
    }
    
    
    //return subset of node
    public int find(int[] parent, int vertex) {
        
        if(parent[vertex] != -1)
            return find(parent, parent[vertex]);
        else
            return vertex;
    }
    
    public void union(int[] parent, int x, int y) {
        
        int xsetParent = find(parent, x);
        int ysetParent = find(parent, y);
        
        parent[ysetParent] = xsetParent;
    }
}


class AGraph {

    int vertices;
    List<Edge> edges = new ArrayList<>();

    AGraph(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }
}


class Edge {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {

        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

