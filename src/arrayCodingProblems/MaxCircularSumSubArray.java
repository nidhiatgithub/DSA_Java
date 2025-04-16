package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

public class MaxCircularSumSubArray {
    public static void main(String[] args) throws IOException {
        System.out.println("Maximum Circular Subarray Sum");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("Maximum Circular Subarray Sum is:"+ maxSum(inputArray));

    }

    // TotalSum - minSumOfSubArray
    private static int maxSum(ArrayList<Integer> integerArrayList) {
        int totalSum = 0;
        int maxSum =0;
        int currentMaxSum = 0;
        int minSum = 0;
        int currentMinSum = 0;

        for (int end=0; end<integerArrayList.size() ; end++ ) {
            totalSum = totalSum + integerArrayList.get(end);

            //Kadane's max sum subarray
            currentMaxSum = Math.max(currentMaxSum + integerArrayList.get(end), integerArrayList.get(end));
            maxSum = Math.max(maxSum, currentMaxSum);

            //Kadane's Min sum subarray
            currentMinSum = Math.min(currentMinSum+integerArrayList.get(end), integerArrayList.get(end));
            minSum = Math.min(currentMinSum, minSum);

        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;
        return Math.max(normalSum, circularSum);
    }
}
