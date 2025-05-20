package src.recursion.takeuforward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Input [3,1,2], output - 0, 1,2,3, 4, 5, 6
public class SubSetSum   {
    public static void main(String[] args) {
        int[] intArray = {3,1,2};
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        subSetGenerator(intArray, 0, result, sum);
        Collections.sort(result);
        System.out.println("Subset generator: "+result);
    }

    private static void subSetGenerator(int[] intArray, int index, ArrayList<Integer> res, int sum) {
        if (index == intArray.length)
        {
            res.add(sum);
            return;
        }

        subSetGenerator(intArray, index+1, res, sum+intArray[index]);
        subSetGenerator(intArray, index+1, res, sum);
    }
}