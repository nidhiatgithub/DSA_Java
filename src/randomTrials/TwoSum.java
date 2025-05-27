package src.randomTrials;

//Given nums = [2, 7, 11, 15], target = 9, Output [0,1]
public class TwoSum {
    public static void main(String[] args) {
        int inputArr[]={2,7,11,15};
        int targetSum = 9;

        for(int ind=0;ind<inputArr.length;ind++) {
            int ind2=indexOf(inputArr,targetSum-inputArr[ind]);
            if( ind2!=-1) {
                System.out.print(ind+", "+ind2);
                return;
            }
        }
        System.out.print("-1,-1");
    }

    private static int indexOf(int[] inputAr, int element) {
        for(int i=0;i<inputAr.length;i++) {
            if(inputAr[i]==element)
                return i;
        }
        return -1;
    }
}
