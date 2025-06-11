package src.recursion.randomTrials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TugOfWar_bitmesh {
    public static void main(String[] args) {
//        System.out.println(1<<0);
//        System.out.println(1<<1);
//        System.out.println(1<<2);
//        System.out.println(1<<3);
//        System.out.println(1<<4);
//        System.out.println(1<<5);
//
//        System.out.println("\n\n==============");
//
//        System.out.println(1&(1<<0));
//        System.out.println(1&(1<<1));
//        System.out.println(1&(1<<2));
//        System.out.println(1&(1<<3));
//        System.out.println(1&(1<<4));
//        System.out.println(1&(1<<5));
//        System.out.println(1&(1<<6));
//        System.out.println("\n\n==============");

        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        int totalSum = 0;
        for(int i=0;i<arr.length;i++) {
            totalSum+=arr[i];
        }

        int sum1=0,sum2=0;
        AtomicInteger diff=new AtomicInteger(10000);
        boolean selected[] = new boolean[arr.length];
        arraySplitterEqual(arr, totalSum, diff, selected);
        System.out.println("Difference: "+diff +"First list:");
        for(int i=0;i<selected.length;i++) {
            if(selected[i])
                System.out.print(arr[i]+", ");
        }
        //print second
        System.out.println("Second list:");
        for(int i=0;i<selected.length;i++) {
            if(selected[i]==false)
                System.out.print(arr[i]+", ");
        }

    }

    //Returns diff
    private static int arraySplitterEqual(int[] inputArr, int totalSum, AtomicInteger diff, boolean selected[]) {
        int maxDiff = Integer.MAX_VALUE;
        int n= inputArr.length;
        int tempSum = 0;
        ArrayList<Integer> arr1;
        for(int i=0;i<Math.pow(2,n);i++) {
            arr1 = new ArrayList<>();
            tempSum=0;
            for(int j=0;j<n;j++) {
                if((i&(1<<j)) != 0) {
                    arr1.add(j);
                    tempSum+=inputArr[j];
                }
            }
            if(n%2==0 ? arr1.size() == n/2 : arr1.size() == (n-1)/2) {
                if(Math.abs(tempSum-(totalSum-tempSum)) < maxDiff) {
                    maxDiff = Math.abs(tempSum-(totalSum-tempSum));
                    diff.set(maxDiff);
                    for(int l=0;l<selected.length;l++) {
                        selected[l] = false;
                    }
                    for(int k=0;k<arr1.size();k++) {
                        selected[arr1.get(k)] = true;
                    }
                }
            }
        }
        return maxDiff;
    }
}
