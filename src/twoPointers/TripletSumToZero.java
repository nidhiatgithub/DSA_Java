package src.twoPointers;

import src.util.CommonUtil;
import java.util.ArrayList;

//medium
public class TripletSumToZero {
    public static void main(String[] args){
        System.out.println("Given an array of unsorted numbers, find triplet with sum 0(medium)");
        ArrayList<Integer> inputList = CommonUtil.readArray(", ");
        inputList.sort(null);
        int targetSum = 0;

        tripletSum0Finder(inputList, targetSum);

    }

    private static ArrayList tripletSum0Finder(ArrayList<Integer> inputList, int targetSum) {
        ArrayList triplet = new ArrayList();
        int start =0; int end=inputList.size()-1;
        for (;start < end; start++) {
            ArrayList pairArr = pairFinder(inputList, start + 1, -(inputList.get(start)));
            if(pairArr.size() > 0) {
                pairArr.add(0, inputList.get(start));
                triplet = pairArr;
                System.out.println("Triplet with Target Sum 0: "+ triplet);
            }
        }
        return triplet;
    }

    private static ArrayList pairFinder(ArrayList<Integer> inputList, int start, int targetSum) {
        ArrayList pairArray = new ArrayList();
        int currentSum = 0;

        int end = inputList.size() - 1;
        while (start < end) {
            currentSum = inputList.get(start) + inputList.get(end);
            if (currentSum == targetSum) {
                pairArray.add(inputList.get(start));
                pairArray.add(inputList.get(end));
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
