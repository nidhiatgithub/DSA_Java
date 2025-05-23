package src.recursion.repeatTrial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//mobile pad
//234
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
        List<String> ans = new ArrayList<>();
        wordsGenerator(keyPad,ans,"",input,0);
        System.out.println(ans);
    }

    private static void wordsGenerator(HashMap<Integer,String> keyPad, List<String> answer, String temp, String inputDigits,int index) {
        if(temp.length()==inputDigits.length()) {
            answer.add(temp);
            return;
        }

        int num = Integer.parseInt(inputDigits.substring(index,index+1));
        String keyStr = keyPad.get(num);
        for(int j=0;j<keyStr.length();j++) {
            wordsGenerator(keyPad,answer,temp+keyStr.charAt(j),inputDigits,index+1);
        }
    }
}
