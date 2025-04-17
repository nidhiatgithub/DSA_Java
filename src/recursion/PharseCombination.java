package src.recursion;

import java.util.ArrayList;

/**
 * Input: list 1 —> [John, Emma]list 2 —> [Plays, Hates, Watches]list 3 —> [Cricket, Soccer, Chess] Output: John Plays CricketJohn Plays SoccerJohn Plays ChessJohn Hates CricketJohn Hates SoccerJohn Hates Chess
 */
public class PharseCombination {
    public static void main(String[] args) {
        String[] list1 = {"John", "Emma"};
        String[] list2 = {"plays", "hates"};
        String[] list3 = {"cricket", "badminton"};

        ArrayList<String> phrases = new ArrayList<>();
        generatePharses(list1, list2, list3, phrases);
        System.out.println("Total: "+ phrases.size() + "Result pharses: " + phrases);


        ArrayList<String[]> inputList = new ArrayList<>();
        inputList.add(list1);
        inputList.add(list2);
        inputList.add(list3);
//        ArrayList<String> phrases1 = new ArrayList<>();
        generatePhrasesRecursive(inputList, "", 0);
//        System.out.println("Total: "+ phrases1.size()+"Result pharses: " + phrases1);

    }

    private static void generatePharses(String[] list1, String[] list2, String[] list3, ArrayList<String> results) {
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                for (int k = 0; k < list3.length; k++) {
                    results.add(list1[i] + " " + list2[j] + " " + list3[k]);
                }
            }
        }
    }

    private static void generatePhrasesRecursive(ArrayList<String[]> inputList, String result, int listIndex) {

        if (listIndex == inputList.size())
        {
            System.out.println(result);
            return;
        }
        for (int i=0; i< inputList.get(listIndex).length; i++) {
            String out = result + " " + inputList.get(listIndex)[i];
            generatePhrasesRecursive(inputList, out, listIndex+1);
        }


//        if (idx1 > list1.length-1 || idx2 > list2.length-1 || idx3>list3.length-1)
//            return;
//        results.add(list1[idx1] + " " + list2[idx2] + " " + list3[idx3]);
//        generatehrasesRecursive(list1, idx1+1, list2, idx2, list3, idx3, results);
//        generatehrasesRecursive(list1, idx1+1, list2, idx2+1, list3, idx3, results);
//        generatehrasesRecursive(list1, idx1+1, list2, idx2+1, list3, idx3+1, results);
    }
}
