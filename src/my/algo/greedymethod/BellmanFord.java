

package my.algo.greedymethod;


public class BellmanFord {

    public void bellmanFordShortestPath(WGraph graph) {

        int distance[] = new int[graph.vertices];
        int predecessor[] = new int[graph.vertices];

        for (int i = 0; i < graph.vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // assume start node is 0
        distance[0] = 0;

        // Execute for V-1 passes
        for (int i = 1; i <= graph.vertices - 1; i++) {

            // for each edge execute relation
            for (int node = 0; node < graph.vertices; node++) {
                for (WNode adjNode : graph.adj[node]) {

                    // RELAX
                    if (distance[adjNode.value] > distance[node] + adjNode.weight) {
                        distance[adjNode.value] = distance[node] + adjNode.weight;
                        predecessor[adjNode.value] = node;
                    }
                }
            }
        }
        
        //check for -ve weight cycle
        for (int node = 0; node < graph.vertices; node++) {
            for (WNode adjNode : graph.adj[node]) {
                if (distance[adjNode.value] > distance[node] + adjNode.weight) {
                    System.out.println(" Negative weight cycle exist @ " + node+" -> "+adjNode.value);
                }
            }
        }
                
        System.out.println("Shortest path distances : ");
        for(int i=0; i<graph.vertices; i++) {
            System.out.println(" "+i+" : "+ distance[i]);
        }
        
        System.out.println("Predecessors : ");
        for(int i=0; i<graph.vertices; i++) {
            System.out.println(" " + i + " -> " + predecessor[i] );
        }
    }
    
    
    public static void main(String ...args) {
        
        WGraph graph = new WGraph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 1, 4);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 2);
        graph.addEdge(4, 3, 9);
        graph.addEdge(3, 4, 7);
        new BellmanFord().bellmanFordShortestPath(graph);        
        WGraph graph1 = new WGraph(6);
        graph1.addEdge(0, 1, -1);
        graph1.addEdge(0, 2, 4);
        graph1.addEdge(1, 2, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(1, 4, 2);
        graph1.addEdge(3, 1, 1);
        graph1.addEdge(4, 3, -3);
        graph1.addEdge(4, 5, 3);

        new BellmanFord().bellmanFordShortestPath(graph1);

    }
}

