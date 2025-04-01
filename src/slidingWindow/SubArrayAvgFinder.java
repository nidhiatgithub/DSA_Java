package src.slidingWindow;

import src.util.CommonUtil;
import java.io.IOException;
import java.util.ArrayList;

//Sliding window easy
public class SubArrayAvgFinder {
    public static void main(String[] args) throws IOException {
        System.out.println("Given an array, find the average of all contiguous subarrays of size K in it.");
        ArrayList<Integer> inputList = CommonUtil.readArray();

        System.out.println("Enter size of array");
        int size = CommonUtil.readInteger();

        System.out.println("Avg of subArray:"+ subArrayAvgList(inputList, size));

    }

    private static ArrayList subArrayAvgList(ArrayList<Integer> inputList, int size) {
        ArrayList<Float> outputList = new ArrayList<Float>();

        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < inputList.size(); windowEnd++) {
            windowSum = windowSum + inputList.get(windowEnd);

            if (windowEnd >= size - 1) {
                float f = (float) windowSum /size;
                outputList.add(f);
                windowSum -= inputList.get(windowStart);
                windowStart++;
            }
        }

        return outputList;
    }


}
