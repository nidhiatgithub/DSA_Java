package src.graph;

public class GraphListMain {
    public static void main(String[] args) {
//        int nodes = 5;
//        GraphList graphList = new GraphList(nodes);
//        graphList.addEdge(0,1);
//        graphList.addEdge(0,2);
//        graphList.addEdge(1,2);
//        graphList.addEdge(2,4);
//        graphList.addEdge(4,3);
//
//        System.out.println("Adjacency List representation: ");
//        graphList.displayAdjList();
//
//        System.out.println("BFS Traversal of graph: ");
//        graphList.bfsTraversal();
//
//        System.out.println("\nDFS Traversal of graph: ");
//        graphList.dfsTraversal();
//
//        System.out.println("\nDetect cycle in graph: "+graphList.detectCycleUpdated());

        GraphList graph = new GraphList(6);
        graph.addWeightedEdge(0,1,2);
        graph.addWeightedEdge(1,2,3);
        graph.addWeightedEdge(2,3,6);
        graph.addWeightedEdge(0,4,1);
        graph.addWeightedEdge(4,2,2);
        graph.addWeightedEdge(4,5,4);
        graph.addWeightedEdge(5,3,1);

        System.out.println("Weighted graph Adjacency List initialized:");
        graph.displayAdjWeightedList();

        System.out.println("Finding shortest path result:");
        int[] minDistances = graph.findShortestPath();

        for (int minDistance: minDistances)  {
            System.out.print(minDistance + ", ");
        }
    }
}
