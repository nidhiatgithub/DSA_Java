package src.mockInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreFinder {
    public static void main(String[] args) {
        int[] shots = {3, 5, 10};
        int score = 20;
        int[] ways = new int[7];

//        scoreGeneratorRaw(shots, score);
//        scoreGenerator(shots, ways, score, 0);
//        AtomicInteger totalWays = new AtomicInteger(0);
//        waysFinder(shots, score, totalWays);
//        System.out.println("Total no of ways: "+ totalWays);

        System.out.println("take No take approach counter:"+ takeNoTakeApproachCountRecursive(score, shots,0));

//        int[][] memo = new int[score+1][shots.length];
//        for (int[] row: memo) {
//            Arrays.fill(row,-1);
//        }
//        System.out.println("take No take recursive approach memo approach counter:"+ takeNoTakeApproachCountRecursiveMemo(score, shots,0, memo));
    }

//    private static void scoreGeneratorRaw(int[] shots, int score)  {
//        ArrayList<int[]> waysList= new ArrayList<>();
//        for (int i=0; i<6; i++) {
//            for (int j=0; j< shots.length; j++)
//                ways[i] = shots[j];
//            }
//        }
//    }

    private static void waysFinder(int[] shots, int score, AtomicInteger totalWays) {
        if(score == 0)
        {
            totalWays.set(totalWays.intValue()+1);
            return;
        }
        if(score<0)
            return;
        for(int i=0;i<shots.length-1;i++){
            waysFinder(shots, score-shots[i], totalWays);
        }
    }

    /**
     *
     * generates all permutations of ways of scoring
     * , [3, 3, 3, 3, 3, 5, 0]
     *  , [3, 3, 3, 3, 5, 3, 0]
     *  , [3, 3, 3, 5, 3, 3, 0]
     *  , [3, 3, 5, 3, 3, 3, 0]
     *  , [3, 5, 3, 3, 3, 3, 0]
     *  , [5, 3, 3, 3, 3, 3, 0]
     *  , [5, 5, 5, 5, 0, 0, 0]
     *  , [5, 5, 10, 0, 0, 0, 0]
     *  , [5, 10, 5, 0, 0, 0, 0]
     *  , [10, 5, 5, 0, 0, 0, 0]
     *  , [10, 10, 0, 0, 0, 0, 0]
     * @param shots
     * @param ways
     * @param totalSum
     * @param index
     */
    private static void scoreGenerator(int[] shots, int[] ways, int totalSum, int index) {
        System.out.println("score generator: "+ Arrays.toString(ways) + ", " +totalSum + " , " +index);
        if(totalSum==0){
            System.out.println(" , "+ Arrays.toString(ways));
            return;
        }

        if(totalSum<0 || index>=7) {
            return;
        }

        for(int i=0; i<shots.length-1; i++)
        {
            ways[index]=shots[i];
            for(int j=index+1; j<ways.length; j++)
                ways[j]=0;
            scoreGenerator(shots, ways, totalSum-shots[i], index+1);
        }
    }
//3 3 3 3 3 3

private static int takeNoTakeApproachCountRecursive(int total, int[] shots, int index) {
    if(total==0)
        return 1;
    if(total<0 || index==shots.length)
        return 0;

    System.out.println("inside take:" + (total-shots[index]) +", "+index);
    int take = takeNoTakeApproachCountRecursive(total-shots[index], shots, index);


    System.out.println("inside notake:" + total +", "+(index+1));
    int noTake = takeNoTakeApproachCountRecursive(total, shots, index+1);
    return take+noTake;
}

    private static int takeNoTakeApproachCountRecursiveMemo(int total, int[] shots, int index, int[][] memo) {
        if(total==0)
            return 1;
        if(total<0 || index==shots.length)
            return 0;

        if(memo[total][index] != -1)
            return memo[total][index];
//        System.out.println("inside takeNoTake:" + total +", "+ Arrays.toString(shots)+", "+index);

        int take = takeNoTakeApproachCountRecursiveMemo(total-shots[index], shots, index, memo);
        int noTake = takeNoTakeApproachCountRecursiveMemo(total, shots, index+1, memo);
        return memo[total][index]=take+noTake;
    }
}