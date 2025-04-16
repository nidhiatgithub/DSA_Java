package src.recursion;

import java.util.Stack;

public class ParenthesisRecursive {
    public static void main(String[] args) {
        Stack<String> results = new Stack<>();
        int size = 4;
        backtrack(size, "", 0, 0, results);
        System.out.println("result: "+results);
    }

    private static void backtrack(int size, String str, int left, int right, Stack<String> results) {
        if(str.length() == 2*size) {
            results.push(str);
            return;
        }
        if(left<size)
            backtrack(size, str+"(", left+1, right, results);
        if (right<size)
            backtrack(size, str+")", left, right+1, results);
    }
}
