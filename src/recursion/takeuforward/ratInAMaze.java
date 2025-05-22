package src.recursion.takeuforward;

//D, L, R, U turn possible only to positions with value 1
//Print all possible paths from 0,0 to 3,3 in lexigraphic order
public class ratInAMaze {
    public static void main(String[] args) {
        int m[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        char possiblePaths[] = {'D','L','R','U'};
        ratMazePath(m,"",possiblePaths,0,0);
    }

    private static void ratMazePath(int m[][], String path, char[] possiblePaths, int curRow, int curCol) {
        if(curRow==m.length-1 &&curCol==m.length-1) {
            System.out.println("Possible path: "+path);
            return;
        }
        for (char possiblePath:possiblePaths) {
            switch (possiblePath) {
                case 'D':
                    if(curRow+1>=0 && curRow+1<m.length && curCol>=0 && curCol< m.length && m[curRow+1][curCol] == 1) {
                        m[curRow+1][curCol] = 2;
                        ratMazePath(m,path+possiblePath,possiblePaths,curRow+1,curCol);
                        m[curRow+1][curCol] = 1;
                    }
                case 'L':
                    if(curRow>=0 && curRow<m.length && curCol-1>=0 && curCol-1< m.length &&m[curRow][curCol-1] == 1) {
                        m[curRow][curCol-1] = 2;
                        ratMazePath(m,path+possiblePath,possiblePaths,curRow,curCol-1);
                        m[curRow][curCol-1] = 1;
                    }
                    break;
                case 'R':
                    if(curRow>=0 && curRow<m.length && curCol+1>=0 && curCol+1< m.length &&m[curRow][curCol+1] == 1) {
                        m[curRow][curCol+1] = 2;
                        ratMazePath(m,path+possiblePath,possiblePaths,curRow,curCol+1);
                        m[curRow][curCol+1] = 1;
                    }
                    break;
                case 'U':
                    if(curRow>=0 && curRow<m.length && curCol-1>=0 && curCol-1< m.length &&m[curRow][curCol-1] == 1) {
                        m[curRow][curCol-1] = 2;
                        ratMazePath(m,path+possiblePath,possiblePaths,curRow,curCol-1);
                        m[curRow][curCol-1] = 1;
                    }
                    break;
            }
        }
    }
}
