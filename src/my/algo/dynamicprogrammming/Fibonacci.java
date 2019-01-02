
package my.algo.dynamicprogrammming;

public class Fibonacci {
    /**
     * This is using dynamic programming tabulation method
     * @param n
     * @return
     */
    public static int getFibonacciOfOrder(int n) {        
        if(n<=1)
            return n;
        int prePreSeq = 0;
        int preSeq = 1;
        int seq = -1;
        System.out.print(+prePreSeq +" ");
        System.out.print(+preSeq +" ");
        for(int i=2; i<=n; i++) {
            seq = preSeq + prePreSeq;
            prePreSeq = preSeq;
            preSeq = seq;
            System.out.print(+seq +" ");
        }
        System.out.println("");
        return seq;
    }
    
    public static void main(String ...args) {
        System.out.println("Fibonacci sequence of order 10 -> "+getFibonacciOfOrder(10));
    }
}
