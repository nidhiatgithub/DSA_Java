package src.recursion.dynamicProgramming;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

//time complexity O(N*N)
//Space complexity is O(N*N)
public class LongestIncreasingSubSequence_throughMemorization {
    public static void main(String[] args) {
        int inputArr[] = {0,1,0,3,2,3};
        int n=inputArr.length;
        System.out.println("Length of longest increasing subSequence is:" + longestIncreasingSubSequence(inputArr, n));
    }

    private static int longestIncreasingSubSequence(int[] intArr, int n) {
        int dp[][]=new int[n][n+1];

        for(int row[]: dp) {
            Arrays.fill(row,-1);
        }
        AtomicInteger recCounter = new AtomicInteger(0);
        int ans = getAns(intArr, intArr.length, 0, -1, dp, recCounter);
        System.out.println("Recursive counter:"+recCounter.intValue());
        return ans;
    }

    private static int getAns(int arr[], int n, int ind, int prev_ind, int[][] dp, AtomicInteger recCounter) {
        recCounter.set(recCounter.intValue()+1);
        //Base condition
        if(ind==n) {
            return 0;
        }

        if(prev_ind!=-1 && dp[ind][prev_ind] != -1) {
            return dp[ind][prev_ind];
        }

        int noTake = 0 + getAns(arr, n, ind+1, prev_ind, dp,recCounter);

        int take = 0;
        if(prev_ind == -1 || arr[ind] > arr[prev_ind]) {
            take = 1 + getAns(arr, n, ind+1, ind, dp,recCounter);
        }

        dp[ind][prev_ind+1] = Math.max(noTake, take);

        return dp[ind][prev_ind+1];
    }
}
