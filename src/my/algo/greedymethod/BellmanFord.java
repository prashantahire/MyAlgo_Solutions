
package my.algo.greedymethod;


public class BellmanFord {    public void bellmanFordShortestPath(WGraph graph) {

        int distance[] = new int[graph.vertices];
        int predecessor[] = new int[graph.vertices];

        // initialization
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
    }
