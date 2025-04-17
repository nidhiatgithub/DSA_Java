package src.mockInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class ScoreFinder {
    public static void main(String[] args) {
        int[] shots = {5, 3, 10};
        int score = 20;
        int[] ways = new int[7];

//        scoreGeneratorRaw(shots, score);
        scoreGenerator(shots, ways, score, 0);
    }

//    private static void scoreGeneratorRaw(int[] shots, int score)  {
//        ArrayList<int[]> waysList= new ArrayList<>();
//        for (int i=0; i<6; i++) {
//            for (int j=0; j< shots.length; j++)
//                ways[i] = shots[j];
//            }
//        }
//    }


    /**
     *
     * generates all permutations of ways of scoring
     *
     *  , [5, 5, 5, 5, 0, 0, 0]
     *  , [5, 5, 10, 0, 0, 0, 0]
     *  , [5, 3, 3, 3, 3, 3, 0]
     *  , [5, 10, 5, 0, 0, 0, 0]
     *  , [3, 5, 3, 3, 3, 3, 0]
     *  , [3, 3, 5, 3, 3, 3, 0]
     *  , [3, 3, 3, 5, 3, 3, 0]
     *  , [3, 3, 3, 3, 5, 3, 0]
     *  , [3, 3, 3, 3, 3, 5, 0]
     *  , [10, 5, 5, 0, 0, 0, 0]
     *  , [10, 10, 0, 0, 0, 0, 0]
     * @param shots
     * @param ways
     * @param totalSum
     * @param index
     */
    private static void scoreGenerator(int[] shots, int[] ways, int totalSum, int index) {
//        System.out.println("score generator: "+ Arrays.toString(ways) + ", " +totalSum + " , " +index);
        if(totalSum==0){
            System.out.println(" , "+ Arrays.toString(ways));
            return;
        }

        if(totalSum<0 || index>=7) {
            return;
        }

        for(int i=0; i<shots.length; i++)
        {
            ways[index]=shots[i];
            for(int j=index+1; j<ways.length; j++)
                ways[j]=0;
            scoreGenerator(shots, ways, totalSum-shots[i], index+1);
        }
    }
}
//3 3 3 3 3 3