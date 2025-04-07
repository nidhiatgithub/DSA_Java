package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//easy
public class SecondLargestElement {

    public static void main(String[] args) throws IOException {
        System.out.println("Find Second Largest Element in an Array");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("Second Largest Element approach2.. "+ secondLargestApproach2(inputArray));
        System.out.println("Second Largest Element approach1.. "+ secondLargestApproach1(inputArray));

    }

    // time complexity o nlogn and space complexity o n
    private static int secondLargestApproach1(ArrayList<Integer> integerArrayList) {
        int secondLargestElement = -1;
        Collections.sort(integerArrayList);
        secondLargestElement = integerArrayList.get(integerArrayList.size()-2);
        return secondLargestElement;
    }

    // time complexity o n and space complexity o 1
    private static int secondLargestApproach2(ArrayList<Integer> integerArrayList) {
        int max = integerArrayList.get(0);
        int secondLargestElement = integerArrayList.get(0);

        for(int i=0; i< integerArrayList.size(); i++) {
            if(integerArrayList.get(i) > max)
                max = integerArrayList.get(i);
            if(integerArrayList.get(i) < max && integerArrayList.get(i) > secondLargestElement)
                secondLargestElement = integerArrayList.get(i);
        }

        return secondLargestElement;
    }
}
