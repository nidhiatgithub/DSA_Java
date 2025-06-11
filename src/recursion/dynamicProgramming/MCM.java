package src.recursion.dynamicProgramming;

//Input: arr[] = {40, 20, 30, 10, 30}
//Output: 26000
//Explanation: There are 4 matrices of dimensions 40×20, 20×30, 30×10, 10×30.
//Let the input 4 matrices be A, B, C, is, and D.
//The minimum number of multiplications is obtained by putting parenthesis in the following way (A(BC))D.
//The minimum is 20*30*10 + 40*20*10 + 40*10*30

//Time complexity - exponential, space complexity - 1
import java.util.concurrent.atomic.AtomicInteger;

public class MCM {
    public static void main(String[] args) {
        int[] inputMatArray = {40, 20, 30, 10, 30};
        AtomicInteger counter = new AtomicInteger(0);
        System.out.println(minMatMultFinder(inputMatArray, 1,inputMatArray.length-1, counter));
        System.out.println("Recursion counter: "+counter);
    }

    private static int minMatMultFinder(int[] p, int i, int j, AtomicInteger counter) {
        counter.set(counter.intValue()+1);
        System.out.println("Inside minMatMultFinder: "+i +", "+j);
        if(i == j)
            return 0;
        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++) {
            int count = minMatMultFinder(p, i, k,counter) + minMatMultFinder(p, k+1, j,counter) +
                    p[i-1]*p[k]*p[j];
            min = Math.min(count, min);
        }

        return min;
    }
}
