package src.Tree;

public class GraphMatMain {
    public static void main(String[] args) {
        GraphMat graph = new GraphMat(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        System.out.println("Adjacency Matrix Representation");
        graph.displayMatrix();

        int tran[][] = graph.transitiveClosure();
        System.out.println("Transitive closure:");
        for (int[] row: tran) {
            for (int val: row) {
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
