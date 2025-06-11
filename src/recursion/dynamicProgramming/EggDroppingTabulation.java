package src.recursion.dynamicProgramming;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

//Similar problem - no of floors that can be covered given n eggs and k moves
//[Expected Approach] Using Tabulation with Optimization - O(n * k) Time and O(n * k) Space
public class EggDroppingTabulation {
    static int eggDrop(int n, int k) {

        // create a 2D table to store the results
        int[][] dp = new int[k + 1][n + 1];

        // to count the number of moves
        int cnt = 0;

        // while the number of floors is less than k
        while (dp[cnt][n] < k) {
            cnt++;

            // for each egg
            for (int i = 1; i <= n; i++) {
                dp[cnt][i] = 1 + dp[cnt - 1][i - 1] + dp[cnt - 1][i];
            }
        }

        System.out.println("DP Table:");
        for (int[] row: dp) {
            for (int i: row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 2, k = 36;
        System.out.println(eggDrop(n, k));
    }
}