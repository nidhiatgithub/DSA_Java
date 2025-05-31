package src.recursion.randomTrials;

import java.util.Arrays;

public class TugOfWar_DP {
    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 6, 5};
        System.out.println("Minimum difference: " + tugOfWar(arr)); // Output: 1
    }
    public static int tugOfWar(int[] arr) {
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();
        int targetSum = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        int optimalSum = 0;
        for (int j = targetSum; j >= 0; j--) {
            if (dp[n][j]) {
                optimalSum = j;
                break;
            }
        }
        return Math.abs(totalSum - 2 * optimalSum);
    }
}
