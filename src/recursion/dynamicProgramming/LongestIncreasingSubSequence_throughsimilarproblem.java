package src.recursion.dynamicProgramming;

//Similar problem which solution need to be found -
// for each index, find length of longest subsequence ending at index
//e.g. {0,1,0,3,2,3} -> {1,2,1,3,3,4}
//Find max of LIS - 4 is answer

//Complexity is O(n*n)
//Space complexity is O(n)
public class LongestIncreasingSubSequence_throughsimilarproblem {
    public static void main(String[] args) {
        int inputArr[] = {0,1,0,3,2,3};
        int maxSubSeqSize=lisFinder(inputArr);
        System.out.println("Longest subsequence size:"+maxSubSeqSize);
    }

    private static int lisFinder(int[] inputArr) {
        int maxSubSeqSize=1;
        int[] lis = new int[inputArr.length];
        for(int i=0;i<inputArr.length;i++) {
            //initialize to 1 as each element itself is longest subsequence of size 1
            lis[i] = 1;
        }
        for(int i=1;i<inputArr.length;i++) {
            //check in left side of index
            for(int left=0;left<i;left++) {
                if(inputArr[left]<inputArr[i] && lis[left]>=lis[i]) {
                    lis[i] = lis[left]+1;
                }
            }
            maxSubSeqSize=Math.max(maxSubSeqSize,lis[i]);
        }
        return maxSubSeqSize;
    }
}
