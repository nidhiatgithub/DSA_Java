package src.recursion.repeatTrial;

//Backtracking
//More 1's than 0's
public class NbitBinary {
    public static void main(String[] args) {
        int n=4;
        nBitBinaryGenerator("", n, 0);
    }
    private static void nBitBinaryGenerator(String temp, int n, int extraOnes) {
        if(temp.length()==n) {
            System.out.print(temp + ", ");
            return;
        }
        if(extraOnes>0)
            nBitBinaryGenerator(temp+"0", n, extraOnes-1);
        nBitBinaryGenerator(temp+"1", n, extraOnes+1);
    }
}
