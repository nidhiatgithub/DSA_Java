package src.recursion.dynamicProgramming;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

//[Better Approach] Using Memoization - O(n * k^2) Time and O(n * k) Space

//Egg dropping threshold for: n eggs 2, f  36 floor is: 8, counter of recursion: 1331

//Memo:
//-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
//-1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 6 6 6 6 6 6 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8
public class EggDroppingMemoization {
    public static void main(String[] args) {
        int n=2,f=36;
        int[][] memo = new int[n][f];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        AtomicInteger counter = new AtomicInteger(0);
        System.out.printf("Egg dropping threshold for: n eggs %s, f  %s floor is: %s, counter of recursion: %s", n, f, eggDropThresholdFinder(n,f, memo, counter), counter.intValue());

        System.out.println("\nMemo: ");
        for(int[] row: memo) {
            for(int i: row)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    private static int eggDropThresholdFinder(int n, int f, int[][] memo, AtomicInteger counter) {
        counter.set(counter.intValue()+1);
        System.out.println("inside recursive function: "+n+", "+f+"\n");
        if(f==0 || f==1)
            return f;
        if(n==1)
            return f;
        if(memo[n-1][f-1] != -1)
            return memo[n-1][f-1];
        int minMoves = Integer.MAX_VALUE;

        for(int i=1; i<=f; i++) {
            int currMoves = 1+ Math.max(eggDropThresholdFinder(n-1,i-1, memo,counter), eggDropThresholdFinder(n, f-i, memo,counter));
            minMoves = Math.min(currMoves, minMoves);
        }
        System.out.printf("inside recursive function result: %s, %s, %s\n",n,f,minMoves);
        return memo[n-1][f-1]=minMoves;
    }
}
