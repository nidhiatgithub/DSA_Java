package src.recursion.bitmesh;

import java.util.ArrayList;
import java.util.Arrays;

//Input: arr = ["un","iq","ue"]
//Output: 4
//Explanation: All the valid concatenations are:
//- ""
//- "un"
//- "iq"
//- "ue"
//- "uniq" ("un" + "iq")
//- "ique" ("iq" + "ue")
//Maximum length is 4.
public class MaxLenConcatUnique {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList<String>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        arr.add("tj");
        arr.add("fg");
        arr.add("pl");
//        arr.add("iq");
//        arr.add("ue");
//        arr.add("ui");
//        arr.add("io");
//        arr.add("pl");
//
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        long freeMemory = rt.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.println("\ntotalMemory:"+totalMemory+"\n Used memory: "+usedMemory);
        System.out.println("max unique combination length:" + maxLength(arr));
    }

    private static int isUnique(String str)
    {
        int freq[] = new int[26];
        Arrays.fill(freq,0);
        for (int i=0;i<str.length();i++) {
            freq[str.charAt(i)-97]=(freq[str.charAt(i)-97])+1;
            if(freq[str.charAt(i)-97]>1) {
                return 0;
            }
        }
        return str.length();
    }

    private static int maxLength(ArrayList<String> arr) {
        int ans=0;
        int n=arr.size();
        double total=Math.pow(2,n);
        String curr="";
        for(int i=0;i<total;i++) {
            curr="";
            for(int j=0;j<n;j++) {
                if((i&(1<<j))!=0)
                    curr+=arr.get(j);
            }
            ans = Math.max(ans, isUnique(curr));
        }
        return ans;
    }
}
