package src.recursion.dynamicProgramming;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class EqualPartition {

        static boolean isSubsetSum(int n, int[] arr,
                                   int sum, int[][] memo,AtomicInteger recCounter) {
            recCounter.set(recCounter.intValue()+1);
            // base cases
            if (sum == 0)
                return true;
            if (n == 0)
                return false;

            if (memo[n - 1][sum] != -1) {
                System.out.println("From memo DP");
                return memo[n - 1][sum] == 1;
            }

            // If element is greater than sum, then ignore it
            if (arr[n - 1] > sum)
                return isSubsetSum(n - 1, arr, sum, memo,recCounter);

            // Check if sum can be obtained by any of the following
            // (a) including the current element
            // (b) excluding the current element
            memo[n - 1][sum] = (isSubsetSum(n - 1, arr, sum, memo,recCounter) ||
                    isSubsetSum(n - 1, arr, sum - arr[n - 1], memo,recCounter)) ? 1 : 0;
            return memo[n - 1][sum] == 1;
        }

        static boolean equalPartition(int[] arr,AtomicInteger recCounter) {

            // Calculate sum of the elements in array
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            // If sum is odd, there cannot be two
            // subsets with equal sum
            if (sum % 2 != 0)
                return false;

            int[][] memo = new int[arr.length][sum + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            // Find if there is subset with sum equal
            // to half of total sum
            boolean res = isSubsetSum(arr.length, arr, sum / 2, memo,recCounter);
            return res;
        }

        public static void main(String[] args) {
            int[] arr = {3,10,4,6,5};
            AtomicInteger recCounter = new AtomicInteger(0);
            if (equalPartition(arr, recCounter)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }

            System.out.println("Recursion counter:"+recCounter.intValue());
        }

}
