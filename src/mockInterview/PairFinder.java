package src.mockInterview;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PairFinder {
    public static void main(String[] args) throws IOException {
        System.out.println("Find no of all the pairs which sums up to targetValue");

        System.out.println("Enter the array separated by space");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        Collections.sort(inputArray);

        System.out.println("Enter target sum");
        int targetSum = CommonUtil.readInteger();

        System.out.println("Matching pair count.. "+ matchingUniquePairCount(inputArray, targetSum));
    }

    private static int matchingUniquePairCount(ArrayList<Integer> inputArr, int targetSum) {
        int matchingPairCount = 0;

        int subArrStartInd = 0;
        int subArrEndInd = inputArr.size() -1;

        ArrayList<int[]> matchingPairs = new ArrayList<>(); // This could be hashMap

        while (subArrStartInd < subArrEndInd){
            if(inputArr.get(subArrStartInd) + inputArr.get(subArrEndInd) == targetSum){
                int[] matchingPair = new int[2];
                matchingPair[0]=inputArr.get(subArrStartInd);
                matchingPair[1]=inputArr.get(subArrEndInd);
                if(matchingPairs.size() == 0 || !isMatchInArrayList(matchingPair, matchingPairs)) {
                    matchingPairCount++;
                    matchingPairs.addLast(matchingPair);
                }
                subArrStartInd++;
            }

            if(inputArr.get(subArrStartInd) + inputArr.get(subArrEndInd) < targetSum){
                subArrStartInd++;
            }

            if(inputArr.get(subArrStartInd) + inputArr.get(subArrEndInd) > targetSum){
                subArrEndInd--;
            }
        }

        return matchingPairCount;
    }

    private static boolean isMatchInArrayList(int[] matchPair, ArrayList matchingPairs) {
        for (int i=0;i<matchingPairs.size();i++)
        {
            int[] currentPair = (int[]) matchingPairs.get(i);
            if(currentPair[0] == matchPair[0] && currentPair[1] == matchPair[1]) {
                return true;
            }
        }
        return false;
    }
}
