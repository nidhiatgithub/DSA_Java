package src.recursion.takeuforward;

//Only one possible solution
//complexity to find all possible sudoku solutions is very high so only one possible solution to be returned
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
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    private static boolean solveSudoku(int board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]==0) {
                    for(int num=1;num<=9;num++) {
                        if(isRightNumAtPos(num,board,i,j)) {
                            board[i][j] = num;
                            if (solveSudoku(board))
                                return true;
                            else board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRightNumAtPos(int n, int board[][], int rowInd, int colInd) {
        //Row check
        for(int i=0;i<9;i++) {
            if(board[rowInd][i] == n) {
                return false;
            }
        }

        //Column check
        for(int i=0;i<9;i++) {
            if(board[i][colInd] == n)
                return false;
        }

        //Small grid check
        int smallGridRowInd = (rowInd/3)*3;
        int smallGridColInd = (colInd/3)*3;
        for(int i=smallGridRowInd;i<smallGridRowInd+3;i++) {
            for(int j=smallGridColInd;j<smallGridColInd+3;j++) {
                if(board[i][j]==n)
                    return false;
            }
        }

        return true;
    }
}
