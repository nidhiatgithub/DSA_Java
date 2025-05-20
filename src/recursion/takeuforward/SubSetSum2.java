package src.recursion.takeuforward;

import java.util.*;

//Should not contain duplicate subsets
//[1,2,2] ->
public class SubSetSum2 {
    public static void main(String[] args) {
        int[] intArray = {3,1,2,2,2,1,3,3,1};
        Arrays.sort(intArray);
        HashSet<List<Integer>> answser = new HashSet<>();
        subSetGenerator(intArray, 0, answser, new ArrayList<>());
        System.out.println("Subset generator: "+answser);
    }

    private static void subSetGenerator(int[] intArray, int index, HashSet<List<Integer>> resultSet, ArrayList<Integer> ds) {
//        System.out.println("inside subSetGenerator: "+index + " ,"+ds);
        if (index == intArray.length)
        {
//            System.out.println("Adding result: "+ ds);
            resultSet.add(new ArrayList<>(ds));
//            System.out.println("Result set: "+resultSet);
            return;
        }
        ds.add(intArray[index]);
        subSetGenerator(intArray, index+1, resultSet, ds);
        ds.remove(ds.size()-1);
        subSetGenerator(intArray, index+1, resultSet, ds);
    }
}
