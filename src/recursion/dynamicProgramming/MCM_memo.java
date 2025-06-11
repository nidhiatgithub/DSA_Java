package src.recursion.dynamicProgramming;

//Input: arr[] = {40, 20, 30, 10, 30}
//Output: 26000
//Explanation: There are 4 matrices of dimensions 40×20, 20×30, 30×10, 10×30.
//Let the input 4 matrices be A, B, C, is, and D.
//The minimum number of multiplications is obtained by putting parenthesis in the following way (A(BC))D.
//The minimum is 20*30*10 + 40*20*10 + 40*10*30


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

//Time Complexity: O(N3 )
//Auxiliary Space: O(N2) ignoring recursion stack space
public class MCM_memo {
    public static void main(String[] args) {
        int[] inputMatArray = {40, 20, 30, 10, 30};
        int[][] dp = new int[5][5];
        for(int[] row:dp)
           Arrays.fill(row, -1);

        AtomicInteger counter = new AtomicInteger(0);
        System.out.println(minMatMultFinder(inputMatArray, 1,inputMatArray.length-1, counter, dp));
        System.out.println("Recursion counter: "+counter);
    }

    private static int minMatMultFinder(int[] p, int i, int j, AtomicInteger counter, int[][] dp) {
        counter.set(counter.intValue()+1);
        System.out.println("Inside minMatMultFinder: "+i +", "+j);
        if(i == j)
            return 0;

        if (dp[i][j] != -1)
        {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;

        for(int k=i;k<j;k++) {
            dp[i][j] = Math.min(minMatMultFinder(p, i, k,counter,dp) + minMatMultFinder(p, k+1, j,counter,dp) +
                    p[i-1]*p[k]*p[j],dp[i][j]);
        }

        return dp[i][j];
    }
}
