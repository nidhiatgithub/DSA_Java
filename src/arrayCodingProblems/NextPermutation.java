package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

public class NextPermutation {
    public static void main(String[] args) throws IOException {
        System.out.println("print the lexicographically next greater permutation of the given array");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("Next permutation.. " + nextPermutation(inputArray));
    }

    // time complexity o nlogn and space complexity o n
    private static ArrayList nextPermutation(ArrayList<Integer> inArrayList) {
        int pivot = -1;
        int pivotInd = -1;

        int i = inArrayList.size() - 1;
        for (; i > 0; i--) {
            if (inArrayList.get(i - 1) > inArrayList.get(i)) {
                continue;
            } else {
                pivot = inArrayList.get(i-1);
                pivotInd = i-1;
                break;
            }
        }
        if (i == 0) {
            //reverse rest of the array
            for (int start = 0, end = inArrayList.size()-1; start < end; start ++, end -- ){
                int temp1 = inArrayList.get(start);
                inArrayList.set(start, inArrayList.get(end));
                inArrayList.set(end, temp1);
            }
        }

        if (pivotInd != -1) {
            int pivotSuccessor = 100;
            int pivotSuccessorIndex = -1;
            for (int j = inArrayList.size() - 1; j > pivotInd; j--) {
                if (inArrayList.get(j) > pivot && inArrayList.get(j) < pivotSuccessor) {
                    pivotSuccessor = inArrayList.get(j);
                    pivotSuccessorIndex = j;
                }
            }

            //Swap pivot and successor
            inArrayList.set(pivotInd,inArrayList.get(pivotSuccessorIndex));
            inArrayList.set(pivotSuccessorIndex, pivot);

            //reverse rest of the array
            for (int start = pivotInd + 1, end = inArrayList.size()-1; start < end; start ++, end -- ){
                int temp1 = inArrayList.get(start);
                inArrayList.set(start, inArrayList.get(end));
                inArrayList.set(end, temp1);
            }
        }
        return inArrayList;
    }

}

