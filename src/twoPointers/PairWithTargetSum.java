package src.twoPointers;

import src.util.CommonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// easy
public class PairWithTargetSum {
    public static void main(String[] args) throws IOException {
        System.out.println("Given a sorted array, find Pair with Target Sum aka \"Two Sum\" (easy)");
        System.out.println("enter sorted array:");
        ArrayList<Integer> inputList = CommonUtil.readArray(" ");

        System.out.println("Enter target sum to be matched");
        int size = CommonUtil.readInteger();

        System.out.println("Pair with Target Sum"+ Arrays.toString(pairFinder(inputList, size)));

    }

    private static int[] pairFinder(ArrayList<Integer> inputList, int targetSum) {
        int[] pairArray = new int[2];
        int currentSum = 0;

        int start = 0, end = inputList.size() - 1;
        while (start < end) {
            currentSum = inputList.get(start) + inputList.get(end);
            if (currentSum == targetSum) {
                pairArray[0] = inputList.get(start);
                pairArray[1] =inputList.get(end);
                break;
            }
            if(currentSum < targetSum)
                start++;
            if(currentSum > targetSum)
                end--;
        }

        return pairArray;
    }

}
