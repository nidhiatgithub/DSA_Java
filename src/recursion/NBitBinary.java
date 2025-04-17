package src.recursion;


/**
 *Input : 4
 * Output : 1111 1110 1101 1100 1011 1010
 */
public class NBitBinary {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("N bit binary numbers with more 1's than 0's: ");
        nBitBinaryGeneratorRec("", 0, n);
    }
    private static void nBitBinaryGeneratorRec(String str, int extraOnes, int remainingPlaces) {
        if(remainingPlaces == 0)
        {
            System.out.println(str);
            return;
        }

        nBitBinaryGeneratorRec(str + "1" , extraOnes+1, remainingPlaces-1);
        if (extraOnes>0)
            nBitBinaryGeneratorRec(str+"0", extraOnes-1, remainingPlaces-1);
    }
}
