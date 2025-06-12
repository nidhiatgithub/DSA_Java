package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphList {

    class Pair{
        int node1; //To
        int node2; // From

        public Pair(int i, int i1) {
            node1=i;
            node2=i1;
        }

        public int getNode1() {
            return node1;
        }

        public int getNode2() {
            return node2;
        }
    }
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

    public void addUnDirectedEdge(int i, int j) {
        adjList.get(i).add(j);
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

    //time and space complexity O(N), O(N)
    public void bfsTraversal() {
        LinkedList<Integer> queue = new LinkedList();
        LinkedList<Integer> visited = new LinkedList<Integer>();
        Integer node=0;
        do {
            if(!visited.contains(node.intValue())) {
                visited.add(node.intValue());
                System.out.print(node.intValue() + ", ");
                for (Integer i: adjList.get(node))
                    queue.offer(i);
            }
            node = queue.poll();
        } while (node != null);
    }

    public void dfsTraversal() {
        LinkedList<Integer> stack = new LinkedList();
        LinkedList<Integer> visited = new LinkedList<Integer>();
        Integer node=0;
        do {
            if(!visited.contains(node.intValue())) {
                visited.add(node.intValue());
                System.out.print(node.intValue() + ", ");
                for (Integer i: adjList.get(node))
                    stack.offer(i);
            }
            node = stack.pollFirst();
        } while (node != null);
    }

    //Directed graph detect cycle using BFS
    public boolean detectCycle() {
        boolean isCycle = false;
        LinkedList<Pair> queue = new LinkedList();
        LinkedList<Integer> visited = new LinkedList<Integer>();
        Pair node=new Pair(0,0);
        do {
            if(!visited.contains(node.getNode1())) {
                visited.add(node.getNode1());
                System.out.print(node.getNode1() + ", ");
                for (Integer i: adjList.get(node.getNode1())) {
                    if(node.getNode2() != i) {
                        queue.offer(new Pair(i,node.getNode1()));
                    } else {
                        node = queue.poll();
                        continue;
                    }
                }
            } else
            {
                isCycle = true;
                break;
            }
            node = queue.poll();
        } while (node != null);
        return isCycle;
    }

    //Using BFS in undirected graph
    public boolean detectCycleUpdated() {
        LinkedList<Pair> queue = new LinkedList<>();
        int[] visited = new int[adjList.size()];
        queue.offer(new Pair(0,-1));

        Pair currentPair = queue.poll();

        do{
            Integer currentNode = currentPair.getNode1();
            Integer prevNode = currentPair.getNode2();
            List<Integer> nextNodes = adjList.get(currentNode);
            visited[currentNode] = 1;

            //Iterate all the nextNodes and put to queue if it's not already visited
            //if nextNode already exist in visited list other than parent node, then cycle exit and return true
            for (Integer nextNode: nextNodes) {
                if(visited[nextNode] != 1) {
                    queue.offer(new Pair(nextNode,currentNode));
                } else if(nextNode != prevNode)
                    return true;
            }
            currentPair = queue.poll();
        }while (currentPair != null);

        return false;
    }
}
