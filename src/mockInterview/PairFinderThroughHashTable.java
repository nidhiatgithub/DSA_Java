package src.mockInterview;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.*;

//Time complexity O(N), space complexity o(n)
public class PairFinderThroughHashTable {
    public static void main(String[] args) throws IOException {
        System.out.println("Find no of all the pairs which sums up to targetValue");

        System.out.println("Enter the array separated by space");
        ArrayList<Integer> inputArray = CommonUtil.readArray(",");

//        Collections.sort(inputArray);

        System.out.println("Enter target sum");
        int targetSum = CommonUtil.readInteger();

        System.out.println("Finding matching pair.. ");
        matchingPair(inputArray, targetSum);
    }

    private static ArrayList<int[]> matchingPair(ArrayList<Integer> inputArr, int targetSum) {
       ArrayList matchingPairList = new ArrayList();
        int[] matchingPair = new int[2];
        LinkedList<Integer> searchLinkedList = new LinkedList<>();
       for(int i=0; i<inputArr.size(); i++) {
            if(searchLinkedList.contains((Integer) targetSum - inputArr.get(i))) {
                matchingPair[0] = targetSum - inputArr.get(i);
                matchingPair[1] = inputArr.get(i);
                matchingPairList.add(matchingPair);
                System.out.println("matching pair.. "+ Arrays.toString(matchingPair));
            }
            searchLinkedList.add(inputArr.get(i));
       }

        return matchingPairList;
    }
}
