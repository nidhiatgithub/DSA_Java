package src.recursion.dynamicProgramming;

import java.util.concurrent.atomic.AtomicInteger;

//N no of eggs
//f no of floors
//find minimum no of moves to find threshold floor k above which egg fall will lead to break
//[Naive Approach] Using Recursion - O(n ^ k) Time and O(1) Space

//inside recursive function result: 2, 10, 4  (for 36 floors, this program is running for siginificatly long)
//Egg dropping threshold for: n eggs 2, f  10 floor is: 4, recursion counter: 1535
public class EggDroppingRecursive {
    public static void main(String[] args) {
        int n=2,f=10;
        AtomicInteger counter = new AtomicInteger(0);
        System.out.printf("Egg dropping threshold for: n eggs %s, f  %s floor is: %s, recursion counter: %s", n, f, eggDropThresholdFinder(n,f,counter),counter.intValue());
    }

    private static int eggDropThresholdFinder(int n, int f,AtomicInteger counter) {
        counter.set(counter.intValue()+1);
        System.out.println("inside recursive function: "+n+", "+f+"\n");
        if(f==0 || f==1)
            return f;
        if(n==1)
            return f;
        int minMoves = Integer.MAX_VALUE;

        for(int i=1; i<=f; i++) {
            int currMoves = 1+ Math.max(eggDropThresholdFinder(n-1,i-1,counter), eggDropThresholdFinder(n, f-i,counter));
            minMoves = Math.min(currMoves, minMoves);
        }
        System.out.printf("inside recursive function result: %s, %s, %s\n",n,f,minMoves);
        return minMoves;
    }
}
