package src.graph;

import java.util.ArrayList;
import java.util.HashSet;

//Given a matrix of n*m
//Islands is joining lines of 1's
//Distinct Islands are without mirror image and reflection
public class DistinctIslands {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,0}
        };

        System.out.println("No of distinct Islands:"+countDistinctIslands(mat));
    }

    //Starting from 1's to all adjacent 1's
    private static void dfs(int row, int col, int[][] vis, int[][] grid,
                     ArrayList<String> island, int row0, int col0) {
        vis[row][col] = 1;
        island.add(Integer.toString(row-row0)+" "+Integer.toString(col-col0));
        int m = grid.length; //row
        int n = grid[0].length; //col

        //To get Nodes in 4 directions
        int[] adjRow={-1,0,+1,0};
        int[] adjCol={0,+1,0,-1};

        for(int index=0;index<4;index++) {
            int nRow = row+adjRow[index];
            int nCol = col+adjCol[index];

            if(nRow>=0 && nRow<m && nCol >=0 && nCol <n && vis[nRow][nCol] != 1 && grid[nRow][nCol] == 1) {
                dfs(nRow,nCol, vis, grid, island, row0, col0);
            }
        }
    }

    private static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(grid[i][j] == 1 && vis[i][j]==0) {
                    ArrayList<String> island = new ArrayList<>();
                    dfs(i,j,vis,grid,island,i,j);
                    set.add(island);
                }
            }
        }
        return set.size();
    }
}
