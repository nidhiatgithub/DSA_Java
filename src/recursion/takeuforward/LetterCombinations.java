package src.recursion.takeuforward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Mobile keypad
// 2 represent - abc, 3 represents def
// input digits - 23, output - ad,ae,af,bd,be,bf,cd,ce,cf
public class LetterCombinations {
    public static void main(String[] args) {
        HashMap<Integer, String> keyPad = new HashMap<Integer, String>() {{
            put(1, "");
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }};
        String input= "235";
        List<String> ansList = new ArrayList<>();
        wordsGenerator(keyPad, input, 0, "", ansList);
        System.out.println("Word Combinations: "+ ansList);
    }

    private static void wordsGenerator(HashMap<Integer, String> keyPadMap, String inputDigits, int index, String temp, List<String> ansList) {
        if(index==inputDigits.length()) {
            ansList.add(temp);
            return;
        }
        String currentStr =  keyPadMap.get(Integer.parseInt(String.valueOf(inputDigits.charAt(index))));
        for(int i=0; i<currentStr.length();i++) {
            wordsGenerator(keyPadMap, inputDigits, index+1, temp + currentStr.charAt(i), ansList);
        }
    }
}
