package src.graph;

import java.util.*;

public class GraphMap {
    LinkedHashMap <Character, HashSet<Character>> graphMap;

    public GraphMap() {
        graphMap = new LinkedHashMap<>();
    }

    public void addEdge(Character from, Character to) {
        if(graphMap.get(from) == null)
        {
            HashSet<Character> adjSet = new HashSet<>();
            adjSet.add(to);
            graphMap.put(from, adjSet);
        } else {
            graphMap.get(from).add(to);
        }
    }

    public void displayGraph() {
        for(Character key: graphMap.keySet()) {
            System.out.print(key +": -> ");
            for(Character ch:graphMap.get(key)) {
                System.out.print(ch+", ");
            }
            System.out.println();
        }
    }

    public void bfsTraversal() {
        LinkedList<Character> stack = new LinkedList<>();
        ArrayList<Character> visited = new ArrayList<>();
        stack.offer((Character) graphMap.keySet().toArray()[0]);

        Character node = stack.pollFirst();
        do {
            HashSet<Character> hashSet = graphMap.get(node);
            if(hashSet != null)
            for(Character ch:hashSet.stream().toList())
                if(!visited.contains(ch))
                    stack.offer(ch);
            System.out.print(node);

            visited.add(node);
            node = stack.pollFirst();
        }while (node != null);
    }
}
