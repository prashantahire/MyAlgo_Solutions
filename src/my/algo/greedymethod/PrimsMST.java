package my.algo.greedymethod;


public class PrimsMST {
    
    public static void main(String ...args) {
        
        PrimsMST msp = new PrimsMST();
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        msp.findMST(graph);        
    }
    public void findMST(Graph graph) {
        
        //to store parent nodes on mst
        int parent[] = new int[graph.vertices];
        
        //to store keys/wts and to return min wt
        int key[] = new int[graph.vertices];
        
        //to keep track of nodes already included in MST 
        boolean mstSet[] = new boolean[graph.vertices];
        
        for(int i=0; i<graph.vertices; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        //start with 0th vertex
        key[0] = 0;
        parent[0] = -1; //first node is always root of MST
        for(int vertex=0; vertex<graph.vertices; vertex++) {
            
            int minKeyIdx = getMinimumKeyVertex(key, mstSet);
            
            mstSet[minKeyIdx] = true;
            
            for(int j=0; j<graph.vertices; j++) {
                
                if(graph.matrix[vertex][j] != 0) {
                    
                    if(!mstSet[j] && key[j] > graph.matrix[vertex][j]) {
                        
                        key[j] = graph.matrix[vertex][j];
                        
                        parent[j] = vertex; 
                    }
                }
            }
        }
        printMST(parent, graph);
    }
    
    public void printMST(int []parent, Graph graph) {
        
        System.out.println("Edge   \t Weight");
        int totalCost = 0;
        for(int i=1; i< graph.vertices; i++) {
            
            System.out.println( parent[i] + "-"+ i+"\t" + graph.matrix[i][parent[i]]);
            totalCost+=graph.matrix[i][parent[i]];
        }
        System.out.println("Totalcost : "+ totalCost);
    }
    public int getMinimumKeyVertex(int[] key, boolean[] mstSet) {
        
        int minkey = Integer.MAX_VALUE;
        int minKeyIndex  = -1;
        for(int i=0; i<key.length; i++) {
            if(!mstSet[i] &&  key[i] < minkey) {
                minkey = key[i];
                minKeyIndex = i;
            }
        }
        return minKeyIndex;
    } 
}

class Graph{
    int vertices;
    int [][] matrix;
    
    Graph(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }
    
    public void addEdge(int src, int dest, int wt) {
        
        //add edge
        matrix[src][dest] = wt;
        
        //add back edge for undirected graph
        matrix[dest][src] = wt;
    }
    
}
