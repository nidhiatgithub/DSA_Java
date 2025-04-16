package src.recursion;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

//time complexity o(n)
public class ReverseString {
    public static void main(String[] args) throws IOException {
        System.out.println("Reverse string using recursion");

        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");

        reverseString(inputArray, 0, inputArray.size()-1);
        System.out.println("reverse string result:"+ inputArray );

    }

    // time complexity o nlogn and space complexity o 1
    private static void reverseString(ArrayList<Integer> integerArrayList, int start, int end) {
//        ArrayList<Integer> outputList = new ArrayList<>();
        if (start>=end)
            return;
        int temp = integerArrayList.get(start);
        integerArrayList.set(start, integerArrayList.get(end));
        integerArrayList.set(end, temp);
        reverseString(integerArrayList, start+1, end-1);
    }
}