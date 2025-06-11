package src.Tree;

import java.util.ArrayList;
import java.util.List;

public class GraphMat {
    int[][] mat;

    GraphMat(int n) {
        mat = new int[n][n];
    }

    public void addEdge(int i, int j) {
        this.mat[i][j]=1;
    }

    public void displayMatrix() {
        for(int[] row:mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[][] transitiveClosure() {
        int n = mat.length;
        int[][] res = new int[n][n];

        //Copy the graph value as it is
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                res[i][j] = mat[i][j];
            }
        }

        //All (i,i) positions are self reachable so value 1
        for(int i=0;i<n;i++)
            res[i][i]=1;

        //For each intermediate node k, check i->k and k->j
        for(int i=0; i<n; i++) {
            for (int j=0;j<n;j++) {
                if(res[i][j]==1)
                    continue;
                for (int k=0;k<n;k++) {
                    if(res[i][k]==1 && res[k][j]==1)
                        res[i][j]=1;
                }
            }
        }

        return res;
    }
}
