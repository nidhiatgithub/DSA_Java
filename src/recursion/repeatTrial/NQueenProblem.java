package src.recursion.repeatTrial;

// n*n matrix
//n queens in such a way that it does not attach each other

import java.util.ArrayList;
import java.util.List;

// 0 1 0 0
// 0 0 0 1
// 1 0 0 0
// 0 0 1 0

// 0 0 1 0
// 1 0 0 0
// 0 0 0 1
// 0 1 0 0

  public class NQueenProblem {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        List<int[][]> ans = new ArrayList<>();


        queenPathFinder(board,ans,0);
    }

    private static void queenPathFinder(int[][] board, List<int[][]> ans, int col) {
        //exit condition
        if(col==board.length) {
            //print the board
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board.length;j++) {
                    System.out.print(" "+board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            return;
        }

        for(int i=0;i<board.length;i++) {
                if(isRightPlaceHolder(board, i,col)) {
                    board[i][col] = 1;
                    queenPathFinder(board,ans, col+1);
                    board[i][col]=0;
                }
        }

    }

    private static boolean isRightPlaceHolder(int[][] board, int row, int col) {
        // we check in the row
        for(int i=0; i<board.length; i++) {
            if (board[row][i]==1)
                return false;
        }

        // we check in the column
        for(int i=0; i<board.length; i++) {
            if (board[i][col]==1)
                return false;
        }

        // we check in the upper diagonal
        int i=row-1;
        int j=col-1;
        while (i>=0 && j>=0) {
            if (board[i][j]==1)
                return false;
            i=i-1;
            j=j-1;
        }

        // we check in the lower diagonal
        i=row+1;
        j=col-1;
        while (i<board.length && j>=0) {
            if (board[i][j]==1)
                return false;
            i=i+1;
            j=j-1;
        }
//        for (int i=row+1;i<board.length;i++) {
//            for (int j=col-1;j>=0;j--) {
//                if (board[i][j]==1)
//                    return false;
//            }
//        }
        return true;
    }
}
