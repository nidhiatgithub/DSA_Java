package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

public class BasicTemplateClass {
    public static void main(String[] args) throws IOException {
        System.out.println("Count Subarrays With Exactly K Distinct Elements");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("Enter size of subarray of size k:");
        int size = CommonUtil.readInteger();

        System.out.println("Count of Subarrays With Exactly K Distinct Elements:"+ atMostKDistinct(inputArray));

    }

    private static int atMostKDistinct(ArrayList<Integer> integerArrayList) {
        int res = -1;
        return res;
    }

    private static ArrayList<Integer> reverseString(ArrayList<Integer> integerArrayList, int start, int end) {
        ArrayList<Integer> outputList = new ArrayList<>();

        return outputList;
    }
}


