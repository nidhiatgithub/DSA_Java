package src.recursion.repeatTrial;

import java.util.ArrayList;

//n=3,sum=9
public class NdigiSum {
    public static void main(String[] args) {
        int n=3;
        int sum=9;
        nDigiFinder(new ArrayList<>(), n, sum);
    }

    private static void nDigiFinder(ArrayList<Integer> sol, int n, int remainingSum) {
        if (sol.size()==n) {
            if(remainingSum==0)
                System.out.print(sol+" ,");
            return;
        }
        for (int i=1;i<=9;i++) {
            sol.add((Integer) i);
            nDigiFinder(sol, n, remainingSum-i);
            sol.remove(sol.size()-1);
        }

    }
}
