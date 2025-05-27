package src.mockInterview;

import java.util.ArrayList;

public class StringPartition {
    public static void main(String[] args) {
        int arr[] = {1,6,3};

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
        if(!combinationFinder(arr,0, new ArrayList(), totalSum/2, 0))
            System.out.println(false);
//        for (i;nt i=1;i<arr.length-1;i++) {
//            if(combinationFinder(arr, i, 0, new ArrayList(), totalSum/2, 0)) {
//                break;
//            }
//        }

    }

    private static boolean combinationFinder(int[] arr, int index, ArrayList tempList, int expectedSum, int tempSum) {
        if(tempSum>expectedSum)
            return false;
        if(tempSum==expectedSum) {
            System.out.println("String partiion:"+tempList);
            return true;
        }
        for (int i=index;i<arr.length;i++) {
            tempSum+=arr[i];
            tempList.add(arr[i]);
            combinationFinder(arr, i+1, tempList, expectedSum, tempSum);
            tempSum-=arr[i];
            tempList.removeLast();
        }
        return false;
    }
}
