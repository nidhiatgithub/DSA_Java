package src.recursion.takeuforward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//Input : k = 3 , n = 7
//Output : [ [1, 2, 4] ]
//Explanation :
//        1 + 2 + 4 = 7
//There are no other valid combinations.
//Input : k = 3, n = 9
//Output : [[1, 2, 6],[1, 3, 5],[2, 3, 4]]
public class CombinationSum3 {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6,7,8,9};//
        int subSetSize = 3;
        int targetSum = 9;//8;
//        Arrays.sort(intArray);

        HashSet<List<Integer>> answser = new HashSet<>();
        findCombinations(0, intArray, subSetSize, targetSum, answser , new ArrayList<Integer>() );
        System.out.println("Find combinations answer: "+ answser);
    }

    private static void findCombinations(int ind, int[] arr, int subSetSize, int target, HashSet<List<Integer>> ans, List<Integer> ds) {
        if(target == 0 && subSetSize==ds.size()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(ind == arr.length || subSetSize==ds.size() || target==0)
            return;

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            // As we can not take same candidate multiple times, we move forward index when we decide to choose the element
            findCombinations(ind+1, arr, subSetSize , target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1, arr, subSetSize, target, ans, ds);
    }
}

