package src.recursion.repeatTrial;

public class Combination {
    public static void main(String[] args) {
        char[] inputArr = {'1','2','3','4'};
        int size=2;
        combinationGenerator(inputArr,"",2,0);

    }

    private static void combinationGenerator(char[] inputArr, String temp, int size, int index) {
       if(temp.length()==size)
           System.out.print(temp+", ");
        for(int i=index;i<inputArr.length;i++) {
            combinationGenerator(inputArr,temp+inputArr[i],size,i+1);
        }
    }
}
