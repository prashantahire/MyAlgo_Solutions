
package my.algo.dynamicprogramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OptimalBinarySearchTree {
    
    public static void getOBST(int[]key, int frequency[], int n) {
        
        int cost[][] = new int[n+1][n+1];  //cost matrix
        int weight[][] = new int[n+1][n+1];  //cost matrix
        int root[][] = new int[n+1][n+1]; //root matrix 
        
      //Construct weight matrix W 
        for(int i=0; i<=n; i++) {
            for(int j=i+1; j<=n; j++) {
                weight[i][j] = weight[i][j-1]+frequency[j];
            }
        }
        
        //Construct cost matrix  and root matrix 
        for(int i=0; i<=n; i++) {
            cost[i][i] = weight[i][i];
        }
        
        for(int i=0; i<=n-1; i++) {
            int j= i+1;
            cost[i][j] = cost[i][i]+cost[j][j]+weight[i][j];
            root[i][j] = j;
        }
        
        for(int h=2; h<=n; h++) {
            for(int i=0; i<=n-h; i++) {
                
                int j=i+h;
                int m = root[i][j-1];
                int min = cost[i][m-1] + cost[m][j];
                for(int k=m+1; k<=root[i+1][j]; k++) {
                    int x = cost[i][k-1]+cost[k][j];
                    if(x<min) {
                        m = k;
                        min = x;
                    }
                }
                cost[i][j] = weight[i][j] + min;
                root[i][j] = m;
            }
            
            //print weight matrix
            System.out.println("Weight Matrix : ");
            for(int i=0; i<=n; i++) {
                for(int j=0; j<=n; j++) 
                    System.out.print("    "+weight[i][j]);
                System.out.println();                
            }
            System.out.println();
            System.out.println("Cost Matrix : ");
            //print cost matrix
            for(int i=0; i<=n; i++) {
                for(int j=0; j<=n; j++) 
                    System.out.print("    "+cost[i][j]);
                System.out.println();                
            }   
            
            System.out.println();
            System.out.println("Root Matrix : ");            
            //print root matrix
            for(int i=0; i<=n; i++) {
                for(int j=0; j<=n; j++) 
                    System.out.print("    "+root[i][j]);
                System.out.println();                
            }
            System.out.println("====================================================================================");
        }
        
        System.out.println("Cost for OBST : " + cost[0][n]);
        System.out.println("Root key element for OBST : " + key[root[0][n]]);
    }
    
    public static void main(String ...args) {
        int keys[] = {0, 10, 20, 30, 40};
        int frequency[] = {0, 4, 2, 6, 3};
        getOBST(keys, frequency, 4);
        ExecutorService es = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 10, es);
    }
}
