package src.recursion;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindAllPossibleCombinations {
    public static void main(String[] args) throws IOException {
        System.out.println("combinations of string");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("Enter size of combinations string:");
        int size = CommonUtil.readInteger();

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinations(inputArray, 0, size, new ArrayList<Integer>(), result);
        System.out.println("all possible combinations: "+result);


    }

    private static void combinations(ArrayList<Integer> integerArrayList, int index, int size, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if(current.size() == size) {
            result.add(current);
        }
        for (int i =index; i< integerArrayList.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>(current);
            temp.add(integerArrayList.get(i));
            combinations(integerArrayList, i+1, size, temp, result);
        }
    }

}
