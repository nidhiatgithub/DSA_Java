package src.recursion.repeatTrial;

import java.util.ArrayList;
import java.util.List;

//n*n matrix, rat needs to traverse from (0,0) to (n,n)
//rat can move D -> L -> R -> U only if placeholder value is 1
//Rat can visit to certain position only once
//Print all possible paths in lexicographic order
public class ratInAMaze {
    public static void main(String[] args) {
        int m[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        List<String> possiblePaths = new ArrayList<>();
        String tempPath = "";
        char[] paths = {'D','L','R','U'};
        ratPathTracer(m,paths,possiblePaths,tempPath,0,0);
        System.out.println("PossiblePaths : "+possiblePaths);
    }

    private static void ratPathTracer(int[][] m, char[] paths,List<String> possiblePaths, String tempPath, int rowInd, int colInd) {
//        System.out.println("inside ratPathTracer:"+rowInd+ ", "+ colInd+", "+tempPath);
        if (rowInd==m.length-1 && colInd==m.length-1) {
            System.out.println("Possible path: "+tempPath);
            possiblePaths.add(new String(tempPath));
            return;
        }
        for(char path:paths) {
            switch (path) {
                case 'D':
                    if(rowInd+1>=0&&rowInd+1<m.length&&colInd>=0&&colInd<m.length&&m[rowInd+1][colInd]==1)
                    {
                        m[rowInd+1][colInd]=2;
                        ratPathTracer(m, paths, possiblePaths,tempPath+'D',rowInd+1,colInd);
                        m[rowInd+1][colInd]=1;
                    }
                    continue;
                case 'L':
                    if(rowInd>=0&&rowInd<m.length&&colInd-1>=0&&colInd-1<m.length&&m[rowInd][colInd-1]==1)
                    {
                        m[rowInd][colInd-1]=2;
                        ratPathTracer(m, paths, possiblePaths,tempPath+'L',rowInd,colInd-1);
                        m[rowInd][colInd-1]=1;
                    }
                    continue;
                case 'R':
                    if(rowInd>=0&&rowInd<m.length&&colInd+1>=0&&colInd+1<m.length&&m[rowInd][colInd+1]==1)
                    {
                        m[rowInd][colInd+1]=2;
                        ratPathTracer(m, paths, possiblePaths,tempPath+'R',rowInd,colInd+1);
                        m[rowInd][colInd+1]=1;
                    }
                    continue;
                case 'U':
                    if(rowInd-1>=0&&rowInd-1<m.length&&colInd>=0&&colInd<m.length&&m[rowInd-1][colInd]==1)
                    {
                        m[rowInd-1][colInd]=2;
                        ratPathTracer(m, paths, possiblePaths,tempPath+'U',rowInd-1,colInd);
                        m[rowInd-1][colInd]=1;
                    }
            }
        }
    }
}
