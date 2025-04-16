package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class SubArrayKDistinctCounter {
    public static void main(String[] args) throws IOException {
        System.out.println("Count Subarrays With Exactly K Distinct Elements");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        System.out.println("Enter size of subarray of size k:");
        int size = CommonUtil.readInteger();

        System.out.println("Count of Subarrays With Exactly K Distinct Elements:"+ atMostKDistinct(inputArray, size));

    }

    // time complexity o nlogn and space complexity o 1
    private static int atMostKDistinct(ArrayList<Integer> integerArrayList, int k) {
        int res = 0;
        int start = 0;
        int end = 0;
        Hashtable<Integer, Integer> freqMap = new Hashtable<Integer, Integer>();

        while (end < integerArrayList.size()) {
            if (freqMap.containsKey(integerArrayList.get(end)))
                freqMap.replace(integerArrayList.get(end), freqMap.get(integerArrayList.get(end))+1);
            else
                freqMap.putIfAbsent(integerArrayList.get(end), 1);

            if(freqMap.size() == k){
                res++;
                System.out.println("subArray:"+freqMap);
            }
            while (freqMap.size() > k) {
                freqMap.replace(integerArrayList.get(start),freqMap.get(integerArrayList.get(start)) != null ? freqMap.get(integerArrayList.get(start))-1 : 0);
                if(freqMap.get(integerArrayList.get(start)) != null && freqMap.get(integerArrayList.get(start)) == 0) {
                    freqMap.remove(integerArrayList.get(start));
                }
                start++;
                if(freqMap.size() == k) {
                    res++;
                    System.out.println("subArray:"+freqMap);
                }

            }
            end++;
        }

        while (freqMap.size() >= k) {
            freqMap.replace(integerArrayList.get(start),freqMap.get(integerArrayList.get(start)) != null ? freqMap.get(integerArrayList.get(start))-1 : 0);
            if(freqMap.get(integerArrayList.get(start)) != null && freqMap.get(integerArrayList.get(start)) == 0) {
                freqMap.remove(integerArrayList.get(start));
            }
            start++;
            if(freqMap.size() == k){
                System.out.println("subArray:"+freqMap);
                res++;
            }

        }
        return res;
    }
}

