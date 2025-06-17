package src.graph;

//Given a graph, check whether it's a valid tree
// Graph is a valid tree if no cycle and no free node
public class GraphValidTree {
    public static void main(String[] args) {
        GraphList graph1 = new GraphList(5);
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(0,2);
        graph1.addEdge(3,4);
        graph1.displayAdjList();
        System.out.print("IsValidTree:"+graph1.isValidTree()+"\n");

        GraphList graph2 = new GraphList(5);
        graph2.addEdge(0,1);
        graph2.addEdge(0,3);
        graph2.addEdge(0,2);
        graph2.addEdge(3,4);
        graph2.addEdge(1,2);
        graph2.displayAdjList();
        System.out.print("\n IsValidTree: "+graph2.isValidTree());

        GraphList graph3 = new GraphList(6);
        graph3.addEdge(0,1);
        graph3.addEdge(0,3);
        graph3.addEdge(0,2);
        graph3.addEdge(3,4);
        graph3.addEdge(1,2);
        graph3.addEdge(5,5);
        graph3.displayAdjList();
        System.out.print("\n IsValidTree: "+graph3.isValidTree());
    }
}
