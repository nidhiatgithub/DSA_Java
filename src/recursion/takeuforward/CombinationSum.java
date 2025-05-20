package src.recursion.takeuforward;

import java.util.ArrayList;
import java.util.List;

//input distinct integers
//unique combinations with chosen sum, same number can be chosen multiple times
//input [2,3,6,7], target=7, output - [2,2,3], [7]
//input [2,3,5], target=8, output  [2,2,2,2], [2,3,3],[3,5]
public class CombinationSum {
    public static void main(String[] args) {
        int[] intArray = {2,3,5};// {1,1,1,2,2};//
        int targetSum = 8;//4;//8;

        List<List<Integer>> answser = new ArrayList<>();
        findCombinations(0, intArray, targetSum, answser , new ArrayList<Integer>() );
        System.out.println("Find combinations answer: "+ answser);

    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(ind == arr.length)
            return;
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1, arr, target, ans, ds);
    }
}
