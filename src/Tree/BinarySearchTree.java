package src.Tree;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree {

    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree.Node insertLevelOrder(int[] inputArr, int index) {
        BinarySearchTree.Node root = null;

        if(index<inputArr.length) {
            root = new BinarySearchTree.Node(inputArr[index]);
            root.left = insertLevelOrder(inputArr,2*index+1);
            root.right = insertLevelOrder(inputArr,2*index+2);
        }
        return root;
    }

    //Recursion - o(N)
    public boolean isBSTUtil(Node node, int min, int max) {
        if(node==null) return true;
        if(node.data>max || node.data < min) {
            return false;
        }
        return isBSTUtil(node.left,min,node.data-1) && isBSTUtil(node.right, node.data+1, max);
    }

    //Log(n)
    public boolean isBSTSearch(Node node, int data) {
        if(node==null)
            return false;
        if(node.data == data)
            return true;
        return data < node.data ? isBSTSearch(node.left, data) : isBSTSearch(node.right, data);
    }

    public void bstInsert(Node node, int data) {
        if(data<node.data) {
            if(node.left == null){
                node.left=new Node(data);
            } else {
                bstInsert(node.left,data);
            }
        } else if(data > node.data) {
            if(node.right == null){
                node.right=new Node(data);
            } else {
                bstInsert(node.right,data);
            }
        }
    }

    public Boolean isLeaf(Node node)
    {
        return node.left == null && node.right == null;
    }

    private Node getSucessor(Node current) {
        current = current.right;
        while (current != null && current.left != null )
            current = current.left;
        return current;
    }

    public Node bstDelete(Node node, int data) {

        if(node == null)
            return node;

        if(node.data < data) {
            node.right = bstDelete(node.right, data);
        } else if(node.data > data) {
            node.left = bstDelete(node.left, data);
        } else {
            //This is the case when node data is equal to data which needs to be found
            //Only right child
            if(node.left == null)
                return node.right;

            //only left child
            if(node.right == null)
                return node.left;

            //If both children nodes are present,
            // Find successor node - Node -> RIGHT 's left node
            // copy successor data in the node and delete successor
            Node node1 = getSucessor(node);
            node.data = node1.data;
            bstDelete(node.right, node1.data);
        }
        return node;
    }

    public void inOrderTrversal(Node node) {
        if(node == null)
            return;
        inOrderTrversal(node.left);
        System.out.print(node.data+ " -> ");
        inOrderTrversal(node.right);
    }

    public Node lowestCommonAncestor(Node root, Node node1, Node node2) {
        if(root == null || root == node1 || root == node2)
            return root;
        Node leftLCA = lowestCommonAncestor(root.left, node1, node2);
        Node rightLCA = lowestCommonAncestor(root.right, node1, node2);
        if(leftLCA == null)
            return rightLCA;
        if(rightLCA == null)
            return leftLCA;
        return root;
    }

    public void traverseDFS(Node node) {
        LinkedList<Node> stack = new LinkedList<>();
        do {
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
            System.out.print(node.data+", ");
            node = stack.isEmpty() ? null : stack.pop();
        } while (node != null);
    }

    //In-order traversal and kth element in list
    public void kthSmallestElement(Node root, AtomicInteger k) {
        if(root==null)
            return;
        kthSmallestElement(root.left,k);
        if(k.intValue()==1) {
            System.out.print(root.data);
            return;
        }
        k.set(k.intValue()-1);
        kthSmallestElement(root.right,k);
    }
}
