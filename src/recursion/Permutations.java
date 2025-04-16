package src.recursion;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) throws IOException {
        System.out.println("perumtation of string");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        permutate(inputArray, 0);

//        System.out.println("Count of Subarrays With Exactly K Distinct Elements:"+ atMostKDistinct(inputArray));

    }

    private static void permutate(ArrayList<Integer> integerArrayList, int idx) {
//        System.out.println("inside permutate method: " + integerArrayList + " " + idx);
        if(idx == integerArrayList.size()-1)
            System.out.println("permutation: "+integerArrayList + " ");

        for (int i=idx; i<integerArrayList.size(); i++){
            swap(integerArrayList, idx, i);
            permutate(integerArrayList, idx+1);
            swap(integerArrayList, idx, i);
        }
    }

    private static void swap(ArrayList<Integer> integerArrayList, int start, int end) {
        if(start == end) {
//            System.out.println("inside swapping indexes : "+ start + " ,"+ end);
            return;
        }

//        System.out.println("swapping indexes: "+ start + " ,"+ end);
        int temp = integerArrayList.get(start);
        integerArrayList.set(start, integerArrayList.get(end));
        integerArrayList.set(end, temp);
    }
}

