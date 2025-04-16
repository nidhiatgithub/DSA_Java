package src.recursion;

import src.util.CommonUtil;

import java.util.ArrayList;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println("Enter the array separated by , ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(", ");
        System.out.println("String is palindrome: "+isPalindrome(inputArray, 0, inputArray.size()-1));
    }

    private static boolean isPalindrome(ArrayList<Integer> integerArrayList, int start, int end) {
        if(start >= end)
            return true;
        if(integerArrayList.get(start) != integerArrayList.get(end))
            return false;
        return isPalindrome(integerArrayList, start+1, end-1);
    }
}
