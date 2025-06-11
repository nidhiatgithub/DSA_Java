package src.Tree;

import java.util.ArrayList;
import java.util.List;

public class GraphList {
    List<List<Integer>> adjList;

    GraphList(int nodes) {
        adjList = new ArrayList<>(nodes);
        for (int i=0; i<nodes; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void displayAdjList() {
        for (int i=0;i<adjList.size();i++) {
            System.out.print(i + ": ");
            for (int j: adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
