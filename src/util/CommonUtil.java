package src.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonUtil {

    /**
     * Read from console and return array of integer seaparated by ", "
     * @return
     */
    public static ArrayList readArray(String... delimiter) {
        ArrayList ar = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array elements");
        String input = sc.nextLine();

        Scanner tokenizer = new Scanner(input);

        tokenizer.useDelimiter(delimiter == null || delimiter.length == 0 ? ", " :   delimiter[0]);
        while (tokenizer.hasNext()) {
            String s = tokenizer.next();
            ar.add(Integer.parseInt(s));
        }
        System.out.println("input entered by user: "+ ar);

        return ar;
    }

    public static int readInteger() throws IOException {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String readString() throws IOException {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static void swap(ArrayList<Integer> integerArrayList, int start, int end) {
        if(start == end) {
            System.out.println("inside swapping indexes : "+ start + " ,"+ end);
            return;
        }

        System.out.println("swapping indexes: "+ start + " ,"+ end);
        int temp = integerArrayList.get(start);
        integerArrayList.set(start, integerArrayList.get(end));
        integerArrayList.set(end, temp);
    }
}
