package src.graph;

import java.util.LinkedList;

//Find the order of characters based on new language rules
// Input - baa, abcd, abca, cab, cad
//Output - bdac (Create a directed graph based on rules)
public class AlienDictionary   {
    public static void main(String[] args) {
        LinkedList<String> inputAlienSortedWords = new LinkedList<>();
        inputAlienSortedWords.add("baa");
        inputAlienSortedWords.add("abcd");
        inputAlienSortedWords.add("abca");
        inputAlienSortedWords.add("cab");
        inputAlienSortedWords.add("cad");

        GraphMap graphMap = parseAlienWords(inputAlienSortedWords);
        graphMap.displayGraph();

        graphMap.bfsTraversal();
    }

    public static GraphMap parseAlienWords(LinkedList<String> inputAlienSortedWords) {
        GraphMap graphMap = new GraphMap();
        String str1, str2;
        str1 = inputAlienSortedWords.pollFirst();
        str2 = inputAlienSortedWords.pollFirst();

        do {
            int index = 0;
            Character ch1 = str1.charAt(index);
            Character ch2 = str2.charAt(index);
            do{
                if(ch1==ch2)
                {
                    index++;
                    ch1 = str1.charAt(index);
                    ch2 = str2.charAt(index);
                } else {
                    graphMap.addEdge(ch1, ch2);
                    break;
                }

            } while (ch1 != null || ch2 != null);
            str1 = str2;
            str2 = inputAlienSortedWords.pollFirst();
        }while (str2 != null);

        return graphMap;
    }


}
