package src.slidingWindow;

import src.util.CommonUtil;
import java.io.IOException;
import java.util.HashMap;

//Sliding window medium
public class LongestSubStr_kDistinctChar {
    public static void main(String[] args) throws IOException {
        System.out.println("Given an array, length Longest Substring with K Distinct Characters (medium)");
        String inputStr = CommonUtil.readString();

        System.out.println("Enter no of distinct characters required");
        int size = CommonUtil.readInteger();

        System.out.println("length of Longest Substring with K Distinct Characters:"+ longestSubStr_KDistinct(inputStr, size));

    }

    private static int longestSubStr_KDistinct(String inputStr, int size) {
        int maxLength = 0;
        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
        int subArrStart = 0;

        for(int subArrEnd = 0; subArrEnd<inputStr.length(); subArrEnd++) {
            char subArrEndChar = inputStr.charAt(subArrEnd);
            if (!freqMap.containsKey(subArrEndChar)) {
                freqMap.put(subArrEndChar, 0);
            }
            freqMap.replace(subArrEndChar,freqMap.get(subArrEndChar)+1);

            if(freqMap.size() > size) {
                if( freqMap.get(subArrStart) ==null || freqMap.get(subArrStart) == 0)
                    freqMap.remove(inputStr.charAt(subArrStart));
                else if (freqMap.get(subArrStart) > 0)
                    freqMap.replace(subArrEndChar,freqMap.get(subArrEndChar)-1);

                subArrStart++;
            }

            maxLength = Math.max(maxLength, subArrEnd-subArrStart +1 );
        }
        return maxLength;
    }

}
