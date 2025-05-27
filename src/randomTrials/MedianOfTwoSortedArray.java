package src.randomTrials;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,9};
        int[] arr2 = {4,5,6};

        int[] mergedArr=mergeArrays(arr1,arr2);
        if(mergedArr.length%2==0) {
            int ele1=mergedArr[(mergedArr.length/2)];
            int ele2=mergedArr[(mergedArr.length / 2) - 1];
            System.out.println("Median: " +((float)(ele2) + (float)ele1)/2);
        }else {
            System.out.println("Median: " +mergedArr[(mergedArr.length/2)+1]);
        }

    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr2.length+arr1.length];
        int i=0;int j=0;int k=0;
        while (i<arr1.length||j<arr2.length) {
            if(i==arr1.length)
                mergedArr[k++]=arr2[j++];
            else if (j==arr2.length) {
                mergedArr[k++]=arr1[i++];
            } else
                mergedArr[k++]=arr1[i]<arr2[j] ? arr1[i++] : arr2[j++];
        }
        return mergedArr;
    }
}
