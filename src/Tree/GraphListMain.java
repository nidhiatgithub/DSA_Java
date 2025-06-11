package src.Tree;

import java.util.List;

public class GraphListMain {
    public static void main(String[] args) {
        int nodes = 4;
        GraphList graphList = new GraphList(nodes);
        graphList.addEdge(0,1);
        graphList.addEdge(0,2);
        graphList.addEdge(1,2);
        graphList.addEdge(2,3);

        System.out.println("Adjacency List representation: ");
        graphList.displayAdjList();
    }
}
