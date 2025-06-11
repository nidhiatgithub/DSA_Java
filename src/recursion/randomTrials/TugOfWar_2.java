package src.recursion.randomTrials;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

//Backtracking
//two subsets and track minimum absolute difference between their sums
//If n is even, both subsets must have exactly n/2 elements.
//If n is odd, one subset must have (n−1)/2 elements and the other must have (n+1)/2 elements.

//Complexity - 2^n

// int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
//totalMemory:532676608
// Used memory: 6365064
//
//Complexity:2047
//Time taken:4241600
public class TugOfWar_2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        int sum1=0,sum2=0;
        AtomicInteger diff=new AtomicInteger(10000);
        boolean selected[] = new boolean[arr.length];
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        AtomicInteger loopCount=new AtomicInteger(0);
        arraySplitter(arr, arr1, arr2,0,sum1,sum2,diff,selected,loopCount);

        //print first list
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

        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        long freeMemory = rt.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("\ntotalMemory:"+totalMemory/(1024*1024)+" MB\n Used memory: "+usedMemory/(1024*1024)+" MB\n");
        long endTime = System.nanoTime();
        long elapsedTime = endTime-startTime;
        System.out.println("\nComplexity:"+loopCount.intValue());
        System.out.println("Time taken:"+elapsedTime);
    }

    static void arraySplitter(int[] arr, ArrayList<Integer> arr1, ArrayList<Integer> arr2, int currentIndex, int sum1, int sum2, AtomicInteger diff, boolean selected[],AtomicInteger loopCount) {
        loopCount.set(loopCount.intValue()+1);
        int n=arr.length;
        //Size of array is even
        if(n%2==0 ? arr1.size()==n/2 : arr1.size()==(n-1)/2) {
            {
                if(Math.abs(sum2-sum1)<diff.intValue()) {
                    diff.set(Math.abs(sum2-sum1));
                    for(int i=0;i<n;i++)
                        selected[i]=false;
                    for(int j=0;j<arr1.size();j++)
                        selected[arr1.get(j)]=true;
                }
            }
            return;
        }

        if(currentIndex==n) {
            return;
        }

        int sum=0;

        arr1.add(currentIndex);
        arraySplitter(arr, arr1, arr2, currentIndex+1, sum1+arr[currentIndex], sum2, diff, selected,loopCount);
        arr1.removeLast();
        arr2.add(currentIndex);
        arraySplitter(arr, arr1, arr2, currentIndex+1, sum1, sum2+arr[currentIndex], diff, selected,loopCount);
        arr2.removeLast();
    }















































}
