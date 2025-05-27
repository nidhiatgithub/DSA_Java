package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationGenerator {
    public static void main(String[] args) {
        char[] elements = {'d', 'i', 'n', 'a','m', 'h', 's'};
        int combinationSize = 2;

        List<String> combinations = new ArrayList<>();
        generateCombinations(elements, combinationSize, 0, "", combinations);

        System.out.println("Combinations:");
        for (String combination : combinations) {
            System.out.print(combination+", ");
        }
    }

    public static void generateCombinations(char[] elements, int combinationSize, int startIndex, String current, List<String> combinations) {
        // Base case: when the combination reaches the desired size
        if (current.length() == combinationSize) {
            combinations.add(current);
            return;
        }

        // Recursive case: add the next element and recurse
        for (int i = startIndex; i < elements.length; i++) {
            generateCombinations(elements, combinationSize, i + 1, current + elements[i], combinations);
        }
    }
}