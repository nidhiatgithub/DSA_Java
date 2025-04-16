package src.recursion;

import src.util.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

//for character array/ string
public class BalancedParenthesisFinder2 {
    public static void main(String[] args) throws IOException {
        System.out.println("BalancedParenthesisFinder of given number");

        System.out.println("Enter size of parenthesis array to be found:");
        int size = CommonUtil.readInteger();

        if(size % 2 != 0) {
            System.out.println("invalid input");
            return;
        }
        StringBuffer str = new StringBuffer();
        for (int i=1;i<=size-1;i++) {
            if(i>=size/2)
                str.append(')');
            else
                str.append('(');
        }

        ArrayList<String> resultStrings = new ArrayList<>();
        permutate(str, 0, resultStrings);

//        System.out.println("Count of Subarrays With Exactly K Distinct Elements:"+ atMostKDistinct(inputArray));

    }

    private static void permutate(StringBuffer stringBuffer, int idx, ArrayList<String> resultStrings) {
//        System.out.println("inside permutate method: " + inArrayList + " " + idx);
        if(idx == stringBuffer.length()-1)
        {
            String temp = new String(stringBuffer);
            if (!resultStrings.contains(temp) && isBalanced("("+temp))
            {
                resultStrings.add(temp);
                System.out.println("permutation: "+"(" + temp+ " ");
            }

        }

        for (int i=idx; i<stringBuffer.length(); i++){
            swap(stringBuffer, idx, i);
            permutate(stringBuffer, idx+1, resultStrings);
            swap(stringBuffer, idx, i);
        }
    }

    private static void swap(StringBuffer stringBuffer, int start, int end) {
        if(start == end) {
//            System.out.println("inside swapping indexes : "+ start + " ,"+ end);
            return;
        }
        Character temp = stringBuffer.charAt(start);
        stringBuffer.setCharAt(start, stringBuffer.charAt(end));
        stringBuffer.setCharAt(end, temp);
    }

    private static boolean isBalanced(String stringBuffer) {
        Boolean isBalanced = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<stringBuffer.length(); i++)
        {
            if(stringBuffer.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack == null || stack.size()==0 || stack.pop() != '(') {
                    isBalanced = false;
                    break;
                }
            }
        }
        return isBalanced;
    }
}