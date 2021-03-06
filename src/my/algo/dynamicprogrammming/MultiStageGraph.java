


package my.algo.dynamicprogrammming;


public class MultiStageGraph {

    /**
     * Dynamic prog Method to find out minimum cost for traveling from source to destination for Multi-Stage Graph
     * 
     * Multi-Stage Graph represented ad adjacency matrix
     * 
     * T(n) = O(n^2)
     * 
     * Assumes source vertex is 0 and dest is vertices-1
     */
    public static void solveMultiStageGraph(int graph[][], int stages, int vertices) {
        
        //cost[i] is cost of vertex i to destination
        int cost[] = new int[vertices];
        
        //vertex given min cost 
        int minCostSelectedVertex[] = new int[vertices];
        
        cost[vertices-1] = 0;
        
        for(int i=vertices-2; i>=0; i--) {
            
            int min = Integer.MAX_VALUE;
            for(int k=i+1; k<=vertices-1; k++) {
                //apply formula cost[u] = min(dist[u, v] + cost[v])
                if(graph[i][k] !=0 && graph[i][k]+cost[k] < min) {
                    min = graph[i][k]+cost[k];
                    minCostSelectedVertex[i] = k;
                }
            }
            cost[i] = min;
        }
        
        int path[] = new int[stages];
        path[0] = 0;
        path[stages-1] = vertices-1;
        for(int i=1; i<stages-1;i++) {
            path[i] = minCostSelectedVertex[path[i-1]];
        }
        
        System.out.println(" Minimum cost path : ");
        System.out.print(path[0]);
        for(int i=1; i<stages-1;i++) {
            System.out.print(" -> "+path[i]);
        }
        System.out.print(" -> "+path[stages-1]);
        System.out.println();
        System.out.println("Minimum cost source to destination : "+cost[0]);
    }
    
    public static void main(String ...args) {
        
        int graph[][] = new int[8][8];
        graph[0][1] = 2;
        graph[0][2] = 1;
        graph[0][3] = 3;
        graph[1][4] = 2;
        graph[1][5] = 3;
        graph[2][4] = 6;
        graph[2][5] = 7;
        graph[3][4] = 6;
        graph[3][5] = 8;
        graph[3][6] = 9;
        graph[4][7] = 6;
        graph[5][7] = 4;
        graph[6][7] = 5;
        
        solveMultiStageGraph(graph, 4, 8);
    }
}
