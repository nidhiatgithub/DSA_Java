package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//easy
public class ThirdLargestElement {
    public static void main(String[] args) throws IOException {
        System.out.println("Find third Largest Element in an Array");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("third Largest Element approach2.. "+ thirdLargestApproach2(inputArray));
        System.out.println("third Largest Element approach1.. "+ thirdLargestApproach1(inputArray));

    }

    // time complexity o nlogn and space complexity o n
    private static int thirdLargestApproach1(ArrayList<Integer> integerArrayList) {
        int thirdLargestElement = -1;
        Collections.sort(integerArrayList);
        thirdLargestElement = integerArrayList.get(integerArrayList.size()-3);
        return thirdLargestElement;
    }

    // time complexity o n and space complexity o 1
    private static int thirdLargestApproach2(ArrayList<Integer> integerArrayList) {
        int max = integerArrayList.get(0);
        int secondLargestElement = integerArrayList.get(0);
        int thirdLargestElement = integerArrayList.get(0);

        for(int i=0; i< integerArrayList.size(); i++) {
            if(integerArrayList.get(i) > max) {
                if(max > secondLargestElement) {
                    if(secondLargestElement > thirdLargestElement)
                        thirdLargestElement = secondLargestElement;
                    secondLargestElement = max;
                }
                max = integerArrayList.get(i);
                continue;
            }

            if(integerArrayList.get(i) < max && integerArrayList.get(i) > secondLargestElement)
            {
                if(secondLargestElement > thirdLargestElement)
                    thirdLargestElement = secondLargestElement;
                secondLargestElement = integerArrayList.get(i);
            }

            if((integerArrayList.get(i) < max && integerArrayList.get(i) < secondLargestElement && integerArrayList.get(i) > thirdLargestElement) || (integerArrayList.get(i) < thirdLargestElement && integerArrayList.get(0) == thirdLargestElement))
                thirdLargestElement = integerArrayList.get(i);
        }

        return thirdLargestElement;
    }
}
