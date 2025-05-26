package src.recursion.repeatTrial;

//Print all the permutations
public class Permutation {
    public static void main(String[] args) {
        String str = "abcd";
        permutationPrinter(str,0);
    }

    private static void permutationPrinter(String intputStr, int index) {
        if(index==intputStr.length()-1)
        {
            System.out.print(" "+intputStr+",");
        }
        for(int i=index;i<intputStr.length();i++) {
            intputStr = swap(intputStr,i,index);
            permutationPrinter(intputStr,index+1);
            intputStr = swap(intputStr,i,index);
        }
    }

    private static String swap(String str, int pos1, int pos2) {
        if (str == null || pos1 < 0 || pos2 < 0 || pos1 >= str.length() || pos2 >= str.length()) {
            return str;
        }

        char[] charArray = str.toCharArray();
        char temp = charArray[pos1];
        charArray[pos1] = charArray[pos2];
        charArray[pos2] = temp;

        return new String(charArray);
    }
}
