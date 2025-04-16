package src.arrayCodingProblems;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

/**
 * input entered by user: [7, 2, 1, 3]
 * Next smallest palindrome:[7, 2, 2, 7]
 *
 * input entered by user: [5, 6, 6, 9]
 * Next smallest palindrome:[5, 7, 7, 5]
 *
 * input entered by user: [5, 8, 1, 9, 3]
 * Next smallest palindrome:[5, 8, 2, 8, 5]
 *
 * input entered by user: [7, 9, 9, 7]
 * Next smallest palindrome:[8, 0, 0, 8]
 *
 * input entered by user: [7, 8, 9, 6, 5]
 * Next smallest palindrome:[7, 9, 0, 9, 7]
 *
 * input entered by user: [1, 2, 2, 1]
 * Next smallest palindrome:[1, 3, 3, 1]
 *
 * input entered by user: [6, 9, 9, 9, 9, 6]
 * Next smallest palindrome:[7, 0, 0, 0, 0, 7]
 *
 * input entered by user: [9, 9, 9]
 * Next smallest palindrome: 1 0 0 1
 */

/**
 * In time complexity o(n)
 */
public class NextSmallestPalindrome {
    public static void main(String[] args) throws IOException {
        System.out.println("Given a number, find the next smallest palindrome");

        System.out.println("Enter the array separated by  ");
        ArrayList<Integer> inputArray = CommonUtil.readArray(" ");

        if(isAllNines(inputArray)) {
            System.out.print("Next smallest palindrome: 1 ");
            for (int i=1; i<inputArray.size(); i++) {
                System.out.print("0 ");
            }
            System.out.print("1");
        } else {
            System.out.println("Next smallest palindrome:"+ nextSmallestPalindrome(inputArray));
        }
    }

    // time complexity o n and space complexity o 1
    private static ArrayList<Integer> nextSmallestPalindrome(ArrayList<Integer> inArrayList) {

        boolean biggerTakenCare = false;
        int carryForward = 0;
        int mid = inArrayList.size() / 2;
        int i=-1; int j = -1;

        if(inArrayList.size() % 2 == 0) {
            i = mid-1;
            j=mid;

        } else {
            i = mid;
            j = mid;
        }

        while (i>=0 && j < inArrayList.size()) {
            if (inArrayList.get(i) == inArrayList.get(j)) {
                if(i==j) {
                    if (inArrayList.get(i) == 9){
                        inArrayList.set(i, 0);
                        carryForward = 1;
                    } else {
                        inArrayList.set(i,inArrayList.get(i) + 1);
                        biggerTakenCare = true;
                    }
                } else if(!biggerTakenCare){
                    if (inArrayList.get(i) == 9){
                        inArrayList.set(i, 0);
                        inArrayList.set(j, 0);
                        carryForward = 1;
                    } else {
                        inArrayList.set(i,inArrayList.get(i) + 1);
                        inArrayList.set(j,inArrayList.get(j) + 1);
                        biggerTakenCare = true;
                    }
                }
            } else if(inArrayList.get(i) < inArrayList.get(j)) {
                if (biggerTakenCare) {
                    inArrayList.set(j, inArrayList.get(i));
                } else {
                    if (inArrayList.get(i) == 9){
                        inArrayList.set(i, 0);
                        inArrayList.set(j, 0);
                        carryForward = 1;
                    } else {
                        inArrayList.set(i, inArrayList.get(i) + 1);
                        inArrayList.set(j, inArrayList.get(i));
                    }
                }
            } else if(inArrayList.get(i) > inArrayList.get(j)) {
                inArrayList.set(i, inArrayList.get(i) + carryForward);
                inArrayList.set(j, inArrayList.get(i));
                 carryForward = 0;
                biggerTakenCare = true;
            }

            i--;
            j++;
        }

        return inArrayList;
    }

    private static boolean isAllNines(ArrayList<Integer> integerArrayList) {
        for(int i=0; i< integerArrayList.size(); i++) {
            if(integerArrayList.get(i) != 9)
                return false;
        }
        return true;
    }
}
