package src.recursion;

//similar to scoreFinder
public class PartitionCounter {
    static int counter = 0;
    public static void main(String[] args) {
        int n = 9, m =5;
        System.out.println("partiion counter: "+partitionCount(n, m, 1));

    }

    private static int partitionCount(int n, int m, int index) {
        if(n==0)
            return 1;
        if(n<0 || index>m)
            return 0;
        return partitionCount(n-index, m, index) + partitionCount(n, m, index+1);
    }
}
