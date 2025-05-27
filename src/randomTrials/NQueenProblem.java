package src.randomTrials;

import java.util.ArrayList;

//N queens in such a way that it does not attack each other
public class NQueenProblem {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        ArrayList<int[][]> solArr = new ArrayList<>();
        nQueenSolver(board, solArr, new int[board.length][board.length],0);

    }

    private static void nQueenSolver(int[][] board, ArrayList<int[][]> solArr, int[][] temp, int colIndex) {
        if(colIndex==board.length) {
            solArr.add(temp);
            for (int i=0;i<board.length;i++) {
                for(int j=0;j<board.length;j++) {
                    System.out.print(temp[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("\n");
            return;
        }

        for (int rowInd=0;rowInd<board.length;rowInd++) {
            if(isRightPlaceHolder(temp, rowInd, colIndex)) {
                temp[rowInd][colIndex] = 1;
                nQueenSolver(board, solArr, temp, colIndex+1);
                temp[rowInd][colIndex]=0;
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
