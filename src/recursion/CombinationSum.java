package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Unique combinations
public class CombinationSum {
    public static void main(String[] args) {
        int[] intArray = {1,2,1,1,2,2};
        int targetSum = 4;
        System.out.println("combinations: "+ combinationSum2(intArray, targetSum));
    }

    private static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<arr.length; i++) {
            if(i>ind && arr[i] == arr[i-1]) continue;
            if (arr[i] >target) break;

            ds.add(arr[i]);
            findCombinations(i+1, arr, target-arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
    }
 }
