package src.recursion.dynamicProgramming;

public class CoinsSum {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        System.out.println("Total ways for coins:"+totalWaysFinder(coins,sum,0));
    }

    private static int totalWaysFinder(int[] coins, int sum, int index) {
        if(sum==0) {
            return 1;
        }
        if (sum<0 || index==coins.length)
            return 0;

        int take = totalWaysFinder(coins, sum-coins[index], index);
        int noTake = totalWaysFinder(coins, sum,index+1);
        return take+noTake;
    }
}
