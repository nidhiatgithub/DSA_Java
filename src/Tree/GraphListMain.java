package src.Tree;

import java.util.List;

public class GraphListMain {
    public static void main(String[] args) {
        int nodes = 5;
        GraphList graphList = new GraphList(nodes);
        graphList.addEdge(0,1);
        graphList.addEdge(0,2);
        graphList.addEdge(1,2);
        graphList.addEdge(2,4);
        graphList.addEdge(4,3);

        System.out.println("Adjacency List representation: ");
        graphList.displayAdjList();

        System.out.println("BFS Traversal of graph: ");
        graphList.bfsTraversal();

        System.out.println("\nDFS Traversal of graph: ");
        graphList.dfsTraversal();

        System.out.println("\nDetect cycle in graph: "+graphList.detectCycleUpdated());
    }
}
