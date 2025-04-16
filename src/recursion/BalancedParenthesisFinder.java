package src.recursion;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;

//for integer
public class BalancedParenthesisFinder {
    public static void main(String[] args) throws IOException {
        System.out.println("BalancedParenthesisFinder of given number");

        System.out.println("Enter size of parenthesis array to be found:");
        int size = CommonUtil.readInteger();

        ArrayList<Character> inArray = new ArrayList<>();
        for (int i=1;i<=size-1;i++) {
            if(i>size/2)
                inArray.add(')');
            else
                inArray.add('(');
        }

        permutate(inArray, 0);

//        System.out.println("Count of Subarrays With Exactly K Distinct Elements:"+ atMostKDistinct(inputArray));

    }

    private static void permutate(ArrayList<Character> inArrayList, int idx) {
//        System.out.println("inside permutate method: " + inArrayList + " " + idx);
        if(idx == inArrayList.size()-1)
            System.out.println("permutation: "+"(, " + inArrayList + " ");

        for (int i=idx; i<inArrayList.size(); i++){
            swap(inArrayList, idx, i);
            permutate(inArrayList, idx+1);
            swap(inArrayList, idx, i);
        }
    }

    private static void swap(ArrayList<Character> inArrayList, int start, int end) {
        if(start == end) {
//            System.out.println("inside swapping indexes : "+ start + " ,"+ end);
            return;
        }

//        System.out.println("swapping indexes: "+ start + " ,"+ end);
        Character temp = inArrayList.get(start);
        inArrayList.set(start, inArrayList.get(end));
        inArrayList.set(end, temp);
    }
}