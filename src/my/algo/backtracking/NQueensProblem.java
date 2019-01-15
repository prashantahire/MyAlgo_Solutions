

package my.algo.backtracking;


public class NQueensProblem {
    
    //Bounding condition check for back tracking
    private static boolean isBoundingConditionSatisfied(int board[][], int row, int col) {

        // row check
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // upper diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // lower diagonal check
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }
    
    public static boolean solveNQUtil(int board[][], int col) {
        if(col == board.length) {
            print(board);
            return true;
        }
        
        boolean result = false;
        for(int i=0; i<board.length; i++) {
            
            if(isBoundingConditionSatisfied(board, i, col)) {
                
                board[i][col] = 1;
                
                result = solveNQUtil(board, col+1) || result;

                board[i][col] = 0;
            }
        }
        return result;
    }
}

