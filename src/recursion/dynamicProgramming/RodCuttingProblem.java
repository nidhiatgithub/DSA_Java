package src.recursion.dynamicProgramming;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

// 1 ROD, given length lets say 8 mtr
// price array
public class RodCuttingProblem {
    public static void main(String[] args) {
        int rodLength = 8;
        int[] price = {1,5,8,9,10,17,17,20};
        System.out.println(maximizeProfitRodCutter(rodLength, price));
    }

    private static int maximizeProfitRodCutter(int rodLength, int[] price) {
        if(rodLength==0) {
            return 0;
        }
        int ans = 0;
        for(int j=1;j<=rodLength;j++) {
            ans = Math.max(ans, price[j-1] + maximizeProfitRodCutter(rodLength-j, price));
        }
        return ans;
    }
}
