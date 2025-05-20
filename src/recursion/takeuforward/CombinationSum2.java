package src.recursion.takeuforward;

// Collection of candidate numbers and a target sum
// Find unique combinations
// [1,1,1,2,2], target = 4, output = [1,1,2],[2,2]   (even though we have 3 1's and so 1,1,2 combination can be 2 times, we will output unique combinations
// [10,1,2,7,6,1,5] , target=8, output - [1,1,6], [1,2,5], [1,7], [2,6]   (should be sorted in lexigrophic order)

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] intArray = {1,1,1,2,2,1,3};//
        int targetSum = 4;//8;
        Arrays.sort(intArray);

        HashSet<List<Integer>> answser = new HashSet<>();
        findCombinations(0, intArray, targetSum, answser , new ArrayList<Integer>() );
        System.out.println("Find combinations answer: "+ answser);
    }

    private static void findCombinations(int ind, int[] arr, int target, HashSet<List<Integer>> ans, List<Integer> ds) {
        if(ind == arr.length)
            return;
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            // As we can not take same candidate multiple times, we move forward index when we decide to choose the element
            findCombinations(ind+1, arr, target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1, arr, target, ans, ds);
    }
}
