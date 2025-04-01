package src.twoPointers;

import src.util.CommonUtil;
import java.io.IOException;
import java.util.ArrayList;

//easy
//[2, 3, 3, 3, 6, 9, 9]
public class RemoveDuplicates {
    public static void main(String[] args) throws IOException {
        System.out.println("Given a sorted array, remove duplicates (easy)");
        System.out.println("enter sorted array:");
        ArrayList<Integer> inputList = CommonUtil.readArray(", ");
        removeDuplicates(inputList);


    }

    private static void removeDuplicates(ArrayList<Integer> inputList) {
        int nextNonDuplicate = 1;
        int arrIndex = 1;
        while (arrIndex < inputList.size()) {
            if (inputList.get(arrIndex) != inputList.get(nextNonDuplicate - 1)) {
                inputList.set(nextNonDuplicate, inputList.get(arrIndex));
                nextNonDuplicate++;
            }
            arrIndex++;
        }

        System.out.println("String after removing duplicates"+ inputList.subList(0, nextNonDuplicate));
    }

}
