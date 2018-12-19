package my.algo.dynamic.programming;

public class MatrixChainMultiplicationProblem {
    
    public static int getMinimumCostOfMultiplication(int dimension[], int n) {
        
        int mincost[][] = new int[n][n];
        int minCostMatrix[][] = new int[n][n];
        
        //loop for number of diagonals
        for(int d=1; d<n-1; d++) {
            
            for(int i=1; i<n-d; i++) {
                int j = i+d;
                int min = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++) {
                    int cst = mincost[i][k] + mincost[k+1][j] +(dimension[i-1]*dimension[k]*dimension[j]);
                    if(cst < min) {
                        min = cst;
                        minCostMatrix[i][j] = k;
                    }
                }
                mincost[i][j] = min;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print("   " + minCostMatrix[i][j]);
            }
        }
        System.out.println();
        return mincost[1][n-1];
    }
    
    public static void main(String ...args) {
        int a[] = {5,4,6,2,7};
        System.out.println(" Minimum cost of multiplication : "+getMinimumCostOfMultiplication(a, 5));
    }
}
