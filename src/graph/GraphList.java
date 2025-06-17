package src.graph;

import java.util.*;

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

    class WeightedNode {
        int node;
        int weight;

        public WeightedNode() {
            node = 0;
            weight = 0;
        }
        public WeightedNode(int i, int j) {
            node = i;
            weight = j;
        }

        public int getNode() {
            return this.node;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    class PairWeightedNode extends WeightedNode {
        int prevNode;
        int totalPrevWeight;
        public int getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(int val) {
            prevNode = val;
        }

        public int getTotalPrevWeight() {
            return totalPrevWeight;
        }

        public void setTotalPrevWeight(int totalPrevWeight) {
            this.totalPrevWeight = totalPrevWeight;
        }

        public PairWeightedNode(int prevNode, int totalPrevWeight, int node, int weight) {
            super(node,weight);
            prevNode = prevNode;
            this.totalPrevWeight = totalPrevWeight;
        }
    }


    List<List<Integer>> adjList;

    List<List<WeightedNode>> adjWeightedList;

    GraphList(int nodes) {
        adjList = new ArrayList<>(nodes);
        adjWeightedList = new ArrayList<>(nodes);
        for (int i=0; i<nodes; i++) {
            adjList.add(new ArrayList<Integer>());
            adjWeightedList.add(new ArrayList<WeightedNode>());
        }
    }

    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void addWeightedEdge(int i, int j, int weight) {
        adjWeightedList.get(i).add(new WeightedNode(j, weight));
    }

    //shortest path weight from 0 to each node n
    // shortest path weight from 0->(n-1) and (n-1)->(n)

    //2nd strategy -- DFS and keep saving minimum weight to the node
    public int[] findShortestPath() {
        int[] minDistance = new int[adjWeightedList.size()];
        Arrays.fill(minDistance, -1);

        //Maintain Stack for nodes
        LinkedList<PairWeightedNode> stack = new LinkedList<PairWeightedNode>();
        stack.offer(new PairWeightedNode(-1, 0, 0,0));
        PairWeightedNode currentNode = stack.pollLast();
        do{
            int currentNodeMinWeight = 0;
            if( minDistance[currentNode.getNode()] == -1 || currentNode.getWeight()+ currentNode.getTotalPrevWeight()<minDistance[currentNode.getNode()]) {
                currentNodeMinWeight = minDistance[currentNode.getNode()] = currentNode.getWeight()+ currentNode.getTotalPrevWeight();
            }
            List<WeightedNode> adjNodes = adjWeightedList.get(currentNode.getNode());
            for(WeightedNode adjNode: adjNodes) {
                stack.offer(new PairWeightedNode(currentNode.getNode(), currentNodeMinWeight,
                        adjNode.getNode(), adjNode.getWeight()));
            }

            currentNode = stack.pollLast();
        } while (currentNode != null);

        return minDistance;
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

    public void displayAdjWeightedList() {
        for (int i=0;i<adjWeightedList.size();i++) {
            System.out.print(i + ": ");
            for (WeightedNode node: adjWeightedList.get(i)) {
                System.out.print(node.getNode() + "/"+node.getWeight()+ "  ");
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

    //Detect whether cycle exist in graph
    //Detect whether all nodes are connected
    public boolean isValidTree() {
        boolean isValidTree = true;

        boolean[] visited = new boolean[adjList.size()];
        Arrays.fill(visited, false);

        HashSet<Integer> bfsTraversal = new HashSet<>();

        LinkedList<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, -1));
        Pair currentNode = queue.pollFirst();

        do{

            for(Integer adjNode: adjList.get(currentNode.getNode1())) {
                if (visited[adjNode] && currentNode.getNode2() != adjNode) {
                    //Cycle exist
                    return false;
                }
                if (!visited[adjNode])
                    queue.offer(new Pair(adjNode,currentNode.getNode1()));
            }
            visited[currentNode.getNode1()] = true;
            bfsTraversal.add(currentNode.getNode1());
            currentNode=queue.pollFirst();
        }while (currentNode != null);

        if(bfsTraversal.size() < adjList.size()) // Not connected graph
            isValidTree = false;
        return isValidTree;
    }
}
