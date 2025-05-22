package src.recursion.takeuforward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N*N chess board, if N=4, that means 4*4 chess board
// place N (4 queens) ---> every row should have a queen, every column should have a queen, and none of queen should attack each other
public class NQueen {
    public static void main(String[] args) {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        int n=4;
        List<List<Integer>> ans = new ArrayList<>();
        nQueenSolveFinder(ans, board, n, 0);
//        System.out.println("answer list:"+ans);
    }

    private static void nQueenSolveFinder(List<List<Integer>> ans, int[][] board, int n, int col) {
        if(col == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(" " + board[i][j]
                            + " ");
                System.out.println();
            }
            System.out.println();
            System.out.println();
            return;
        }
        for(int row=0; row<n; row++) {
            if(isSafe(n, row, col, board)) {
                board[row][col] = 1;
                nQueenSolveFinder(ans, board, n, col+1);
                board[row][col] = 0;
            }
        }
    }

    //If its safe to put Queen at given row and column so that
    // it does not attack or get attacked by other queens
    // left up, down diagonal and straight check
    private static boolean isSafe(int n, int row, int col, int[][] board) {
        int dupRow=row;
        int dupCol=col;

        //left top diagonal check
        while (row>0&&col>0) {
            if(board[--row][--col]==1)
                return false;
        }
        row=dupRow;
        col=dupCol;

        //left horizontal check
        while (col>=0) {
            if(board[row][col--]==1)
                return false;
        }
        row=dupRow;
        col=dupCol;

        //left bottom diagonal check
        while (row<n-1&&col>0) {
            if(board[++row][--col]==1)
                return false;
        }
        return true;
    }
}
