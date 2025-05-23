package src.recursion.repeatTrial;

import java.util.ArrayList;
import java.util.List;

//Return all possible partitions of given string so that all substrings are palindrome
// S = "aabaa" ---> Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
//Input : s = "baa", Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aabaa";

        List<List<String>> ans = new ArrayList<>();
        stringPartitionPalindromeSplitter(str,new ArrayList<>(),ans,0);
        System.out.println("Palindrome partition: "+ans);
    }

    private static void stringPartitionPalindromeSplitter(String str, List<String> temp, List<List<String>> ans, int index)  {
        if(index==str.length())
            ans.add(new ArrayList<>(temp));
        for(int pos=index;pos<str.length();pos++) {
            if (isPalindrome(str,index,pos)) {
                temp.add(str.substring(index,pos+1));
                stringPartitionPalindromeSplitter(str,temp,ans,pos+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int startInd, int endInd) {
        while (startInd<=endInd) {
            if(str.charAt(startInd)!=str.charAt(endInd))
                return false;
            startInd++;
            endInd--;
        }
        return true;
    }
}
