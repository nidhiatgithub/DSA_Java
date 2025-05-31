package src.recursion.dynamicProgramming;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

//Unbounded Knapsack
//Complexity with pure recursion - 3^n
// with MOM
public class MinimumCostForTickets {
    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15}; // 1 day pass, 7 day pass, 30 day pass

        AtomicInteger recCount = new AtomicInteger(0);
        System.out.println("Minimum cost for tickets: "+minCostFinder(days, costs, new HashMap<Integer, Integer>(), 0,0, recCount ));
        System.out.println("Recursive function counter: "+recCount.intValue());
    }

    private static int minCostFinder(int[] days, int[] costs, HashMap<Integer,Integer> dpMom, int pos, int reachability, AtomicInteger recCount) {
        recCount.set(recCount.intValue()+1);
        if(pos>days.length-1) {
            return 0;
        }

        if(reachability >= days[pos]) {
            return minCostFinder(days, costs, dpMom, pos+1, reachability, recCount);
        }

        if(dpMom.get(pos) != null) {
            return dpMom.get(pos);
        }

        dpMom.put(pos,Math.min( Math.min(
            costs[0]+minCostFinder(days,costs,dpMom,pos+1,reachability+1, recCount),
                costs[1]+minCostFinder(days,costs,dpMom,pos+1, reachability+7, recCount)),
                costs[2]+minCostFinder(days,costs,dpMom,pos+1,reachability+30, recCount)
        ));
        return dpMom.get(pos);
    }
}
