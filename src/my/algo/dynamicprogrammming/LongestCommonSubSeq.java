package my.algo.dynamicprogrammming;

public class LongestCommonSubSeq {
    
    public static int getLongestCommonSubSequenceInStrings(String s1, String s2) {
        
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        int lcs[][] = new int[s1.length()+1][s2.length()+1];
        int m=1, n=1;
        for(int i=0; i<s1.length(); i++) {
            n=1;
            for(int j=0; j<s2.length(); j++) {
                if(s1char[i] == s2char[j]) {
                    //add 1 + prev diagonal val
                    lcs[m][n] = 1+lcs[m-1][n-1];
                }else {
                    //find max in diagonal comparison
                    if(lcs[m-1][n] > lcs[m][n-1]) 
                        lcs[m][n] = lcs[m-1][n];
                    else
                        lcs[m][n] =  lcs[m][n-1]; 
                }
                n++;
            }
            m++;
        }
        System.out.println("LCS Matrix : ");            
        //print root matrix
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) 
                System.out.print("    "+lcs[i][j]);
            System.out.println();                
        }
        return lcs[s1.length()][s2.length()];
    }    
    public static void main(String ...args) {
        System.out.println("     "+getLongestCommonSubSequenceInStrings("stone", "longest"));
    }
}

