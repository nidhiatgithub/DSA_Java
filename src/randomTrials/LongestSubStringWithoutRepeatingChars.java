package src.randomTrials;

import java.util.HashMap;

//Input: "abcabcbb"
//output 3
public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {
        String inputStr = "wehkidwjhgtuospm";
        System.out.println("Longest substring size: "+longestSubStringLengthFinder(inputStr));
    }

    private static int longestSubStringLengthFinder(String inputStr) {
        int maxLength = 0;
        HashMap<Character,Integer> indexMap=new HashMap<Character, Integer>();

        int subStrEnd=0; int subStrStart=0;
        while (subStrEnd<inputStr.length()) {
            if(!indexMap.containsKey(inputStr.charAt(subStrEnd))) {
                indexMap.put(inputStr.charAt(subStrEnd), subStrEnd);
            } else {
                maxLength=Math.max(maxLength, subStrEnd-subStrStart);
                subStrStart=Math.max(subStrStart, indexMap.get(inputStr.charAt(subStrEnd))+1);
                indexMap.replace(inputStr.charAt(subStrEnd),subStrEnd);

            }
            subStrEnd++;
        }
        return Math.max(maxLength, subStrEnd-subStrStart);
    }
}
