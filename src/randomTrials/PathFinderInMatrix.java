package src.randomTrials;

import java.lang.reflect.Array;
import java.util.ArrayList;

//Input: [[1,2,3],
//            [4,5,6]]
//Output: [[1,4,5,6],
//                [1,2,5,6],
//                [1,2,3,6]]
public class PathFinderInMatrix {
    public static void main(String[] args) {
        int[][] m = {
                {1,2,3},
                {4,5,6}
        };
        char[] possiblePaths = {'D','R'};
        ArrayList path = new ArrayList<>();
        path.add(m[0][0]);
        pathTracer(m,path,0,0);
    }
    private static void pathTracer(int[][] m, ArrayList<Integer> path, int rowInd, int colInd) {
//        System.out.println("Inside pathTracer: "+path + ", "+rowInd+", "+colInd);
        if(path.size()>0 && path.getLast()==m[m.length-1][m[0].length-1]) {
            //print the path
            System.out.println("path: "+path);
            return;
        }
        if (colInd<m[0].length-1) {
            path.add(m[rowInd][colInd+1]);
            pathTracer(m,path, rowInd, colInd+1);
            path.removeLast();
        }
        if(rowInd<m.length-1) {
            path.add(m[rowInd+1][colInd]);
            pathTracer(m,path,rowInd+1,colInd);
            path.removeLast();
        }
    }
}
