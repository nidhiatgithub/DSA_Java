package src.slidingWindow;

import src.util.CommonUtil;
import java.io.IOException;
import java.util.HashMap;

//Sliding window hard
public class NoRepeatSubStr {
    public static void main(String[] args) throws IOException {
        System.out.println("Given an array, length Longest No-repeat Substring (hard)");
        String inputStr = CommonUtil.readString();

        System.out.println("length of Longest Substring with no-repeat Characters:"+ noRepeatLongestSubStr(inputStr));
    }

    private static int noRepeatLongestSubStr(String inputStr) {
        int maxLength = 0;
        HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
        int subArrStart = 0;

        for(int subArrEnd = 0; subArrEnd<inputStr.length(); subArrEnd++) {
            char subArrEndChar = inputStr.charAt(subArrEnd);
            if (!indexMap.containsKey(subArrEndChar)) {
                indexMap.put(subArrEndChar, subArrEnd);
            } else {
                subArrStart = Math.max(subArrStart, indexMap.get(inputStr.charAt(subArrEnd))+1);
                indexMap.replace(subArrEndChar, subArrEnd);
            }

            maxLength = Math.max(maxLength, subArrEnd-subArrStart +1 );
        }
        return maxLength;
    }

}
