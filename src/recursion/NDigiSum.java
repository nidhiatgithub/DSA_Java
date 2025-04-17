package src.recursion;

import java.util.Arrays;

public class NDigiSum {
    public static void main(String[] args) {
        int n = 3;
        int sum = 5;
        findNDigitNums(n, sum);
    }

    private static void findNDigitNums(int n, int sum) {
        int[] out = new int[n];
        for (int i=1; i<=9; i++) {
            out[0] = i;
            findNDigitsNumUtil(n, sum-i, out, 1);
        }
    }

    private static void findNDigitsNumUtil(int n, int sum, int[] out, int index) {
        if(index==n && sum == 0) {
            System.out.println(Arrays.toString(out) + " ");
            return;
        }

        if(index>=n || sum< 0 )
            return;

        for (int i=0; i<=9; i++) {
            out[index] = i;
            findNDigitsNumUtil(n, sum-i, out, index+1);
        }
    }
}
