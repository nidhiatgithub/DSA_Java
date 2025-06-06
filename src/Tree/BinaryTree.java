package src.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public int height(Node root) {
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int diameter (Node node) {
        int diameter = 0;
        int lHeight = node != null ? height(node.left): 0;
        int rHeight = node != null ? height(node.right): 0;

        diameter = lHeight+rHeight+2;
        int childMaxDiameter = Math.max(node != null ? diameter( node.left) : 0, node != null ? diameter(node.right) : 0);
        return Math.max(diameter, childMaxDiameter);
    }

    public void inOrderTraversal(Node node) {
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.data+" ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(Node node) {
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //O(n) time and O(n) space
    public void levelOrderTraversal(Node node) {
        if(node == null)
            return;

        Queue queue = new LinkedList<Node>();
        queue.offer(node);
        Node temp = (Node) queue.poll();
        do{
            System.out.print(temp.data+" ");
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);

            temp = (Node)queue.poll();

        } while (temp != null);

    }

    public void postOrderTraversal(Node node) {
        if(node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+" ");
    }

    public Node insertLevelOrder(int[] inputArr, int index) {
        Node root = null;

        if(index<inputArr.length) {
            root = new Node(inputArr[index]);
            root.left = insertLevelOrder(inputArr,2*index+1);
            root.right = insertLevelOrder(inputArr,2*index+2);
        }
        return root;
    }

    public Node lowestCommonAnscestors() {
        return null;    
    }
}
