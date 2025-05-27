package src.randomTrials;

import java.util.ArrayList;

public class CombinationTrial {
    public static void main(String[] args) {
        int[] inputArr = {1,5,4,8};
        int size = 2;
        ArrayList<Integer[]> res = new ArrayList<>();
        combinationGenerator(inputArr,size,res,new ArrayList<>(),0);
    }

    private static void combinationGenerator(int[] inputArr, int size, ArrayList<Integer[]> res, ArrayList<Integer> temp, int index) {
        if(temp.size()==size) {
            System.out.println(temp+" , ");
            return;
        }
        for (int i=index;i<inputArr.length;i++) {
            temp.add(inputArr[i]);
            combinationGenerator(inputArr, size, res, temp,i+1);
            temp.removeLast();
        }
    }
}
