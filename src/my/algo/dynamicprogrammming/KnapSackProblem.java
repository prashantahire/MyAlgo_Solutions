
package my.algo.dynamic.programming;

public class KnapSackProblem {
    
    public static int getMaximumProfit(int weight[],int profit[], int wtMaxcapacity) {
        
        //profit table
        int profitTable[][] = new int[weight.length][wtMaxcapacity+1];
        
        for(int i=0; i<weight.length; i++) {
            for(int w=0; w<=wtMaxcapacity; w++) {
                
                //for 0th row and 0th column or memo-ization
                if(i==0 || w==0){
                    profitTable[i][w] = 0;
                }else if(weight[i] <= w) {
                    if(profitTable[i-1][w] >= profit[i]+profitTable[i-1][w-weight[i]]) {
                        profitTable[i][w] = profitTable[i-1][w];
                    }else {
                        profitTable[i][w] = profit[i]+profitTable[i-1][w-weight[i]];
                    }
                }else {
                    profitTable[i][w] = profitTable[i-1][w];
                }
                            
            }
        }
        
        int i=weight.length-1;
        int j=wtMaxcapacity;
        while(i>0 && j>0) {
            if(profitTable[i][j] == profitTable[i-1][j]) {
                System.out.println(" "+i+" = 0");
                i--;
            }else {
                System.out.println(" "+i+" = 1");
                i--;
                j=j-weight[i];
            }
        }
        return profitTable[weight.length-1][wtMaxcapacity];
        
    }
    
    public static void main(String ...args) {
        
        int p[]= {0,1,2,5,6};
        int w[]= {0,2,3,4,5};
        
        System.out.println("Maximum profit for 0/1 knapsack by DP :"+getMaximumProfit(w, p, 8));
    }
}
