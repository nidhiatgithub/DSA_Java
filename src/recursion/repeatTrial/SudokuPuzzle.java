package src.recursion.repeatTrial;

import src.recursion.takeuforward.SubSetSum;

public class SudokuPuzzle {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        sudokuSolver(board);
    }

    private static boolean sudokuSolver(int[][] board) {
        boolean isSolved=true;
        for (int i=0; i< board.length; i++) {
            for (int j=0;j<board.length;j++) {
                if (board[i][j] == 0)
                    isSolved=false;
            }
        }
        if (isSolved) {
            for (int i=0; i< board.length; i++) {
                for (int j=0;j<board.length;j++) {
                    System.out.print(" "+board[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board.length;j++) {
                //This position is not yet being solved
                if (board[i][j] == 0) {
                    for(int num=1;num<=9;num++) {
                        if(isRightPlaceHolder(board,num,i,j)) {
                            board[i][j]=num;
                            if(sudokuSolver(board)) return true;
                            board[i][j]=0;
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRightPlaceHolder(int[][] board, int num, int row, int col) {
        //No repeating element in row or column
        for (int i=0; i<board.length; i++) {
            if (board[row][i]==num)
                return false;
            if(board[i][col]==num)
                return false;
        }

        //No repeating element in small 3*3 grid
        int startRowPos = (row/3)*3;
        int startColPos = (col/3)*3;
        for (int i=startRowPos;i<startRowPos+3;i++) {
            for (int j=startColPos;j<startColPos+3;j++) {
                if (board[i][j]==num)
                     return false;
            }
        }

        return true;
    }
}
