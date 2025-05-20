package src.recursion.takeuforward;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

//Return all possible partitions of given string so that all substrings are palindrome
// S = "aabaa" ---> Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
//Input : s = "baa", Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
public class palindromePartitioning {
    public static void main(String[] args) {
        String str = "aabaa";
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        palindromePartitioner(str, 0, result, path);
        System.out.println("Palindrome partitioner: "+ result);
    }

    private static void palindromePartitioner(String str, int index, List<List<String>> result, List<String> path) {
        if(index==str.length())
        {
            //Very important to create new ArrayList from path as path is getting mutated 
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i< str.length(); i++) {
            if(isPalindrome(str, index, i)){
                path.add(str.substring(index, i+1));
                palindromePartitioner(str, i+1, result, path);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int startInd, int endInd) {
        while (startInd<=endInd) {
            if(str.charAt(startInd) != str.charAt(endInd)) {
                return false;
            }
            startInd++;
            endInd--;
        }
        return true;
    }
}
