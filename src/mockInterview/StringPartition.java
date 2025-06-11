package src.mockInterview;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class StringPartition {
    public static void main(String[] args) {
        int arr[] = {3,10,4,6,5};

        //Total sum / 2,
        // if total sum is odd , then false
        // combination where sum = totalsum/2

        int totalSum =0;

        for(int i=0;i<arr.length;i++) {
            totalSum+=arr[i];
        }
        if(totalSum%2!=0) {
            System.out.println(false);
            return;
        }
        AtomicInteger recCounter=new AtomicInteger(0);
        int[][] memo = new int[arr.length][totalSum/2];
        if(!combinationFinder(arr,0, new ArrayList(), totalSum/2, 0, recCounter, memo))
            System.out.println(false);

        System.out.println("Recursion counter: "+recCounter.intValue());
//        for (i;nt i=1;i<arr.length-1;i++) {
//            if(combinationFinder(arr, i, 0, new ArrayList(), totalSum/2, 0)) {
//                break;
//            }
//        }

    }

    private static boolean combinationFinder(int[] arr, int index, ArrayList tempList, int expectedSum, int tempSum, AtomicInteger recCounter,int[][] memo) {
        recCounter.set(recCounter.intValue()+1);
        if(tempSum>expectedSum)
            return false;
        if(tempSum==expectedSum) {
            System.out.println("String partiion:"+tempList);
            return true;
        }
        for (int i=index;i<arr.length;i++) {
            tempSum+=arr[i];
            tempList.add(arr[i]);
            combinationFinder(arr, i+1, tempList, expectedSum, tempSum, recCounter, memo);
            tempSum-=arr[i];
            tempList.removeLast();
        }
        return false;
    }
}
