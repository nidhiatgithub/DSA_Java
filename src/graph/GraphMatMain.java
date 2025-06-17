package src.graph;

public class GraphMatMain {
    public static void main(String[] args) {
//        GraphMat graph = new GraphMat(4);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,2);
//        graph.addEdge(2,3);
//        System.out.println("Adjacency Matrix Representation");
//        graph.displayMatrix();
//
//        int tran[][] = graph.transitiveClosure();
//        System.out.println("Transitive closure:");
//        for (int[] row: tran) {
//            for (int val: row) {
//                System.out.print(val+" ");
//            }
//            System.out.println();
//        }

        //Weighted directed graph
        int V = 6;
        GraphMat graphMat = new GraphMat(V);
//        graphMat.addWeightedEdge(0,1,2);
//        graphMat.addWeightedEdge(0,2,1);

        graphMat.addWeightedEdge(0,1,2);
        graphMat.addWeightedEdge(0,4,1);
        graphMat.addWeightedEdge(1,2,3);
        graphMat.addWeightedEdge(2,3,6);
        graphMat.addWeightedEdge(4,2,2);
        graphMat.addWeightedEdge(4,5,4);
        graphMat.addWeightedEdge(5,3,1);

        System.out.println("Weighted Matrix after initialization:");
        graphMat.displayMatrix();

        System.out.println("Array of shortest distance:");
//        int[] path = graphMat.shortestPathDFS();
//        for(int distance:path) {
//            System.out.print(distance+", ");
//        }
    }
}
