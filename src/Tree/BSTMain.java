package src.Tree;

import java.util.concurrent.atomic.AtomicInteger;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree t = initialize();
        System.out.println("Initialized tree");

        System.out.println("isBST: "+t.isBSTUtil(t.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("BST Search:"+t.isBSTSearch(t.root, 78));

        System.out.println("BST insert call:");
        t.bstInsert(t.root, 11);

        System.out.print("\n DFS: ");
        t.traverseDFS(t.root);

        System.out.print("\nKth smallest element in BST:");
        t.kthSmallestElement(t.root,new AtomicInteger(4));

        System.out.print("\nInOrder traversal: ");
        t.inOrderTrversal(t.root);

        System.out.println("\nBST delete call:");
        t.bstDelete(t.root, 10);

        System.out.print("\nInOrder traversal: ");
        t.inOrderTrversal(t.root);

        System.out.print("\nLowest common ancestor traversal: ");
        System.out.println(t.lowestCommonAncestor(t.root, t.root.left.left, t.root.right).data);

        System.out.println("\nBSTMain end");
    }

    static BinarySearchTree initialize () {
        int[] inputArr = {10,5,18,4,9};//{10,5,18,4,11};//{25,20,36,10,22,30,40,5,12,28,38};
        BinarySearchTree t = new BinarySearchTree();
        t.root = t.insertLevelOrder(inputArr,0);
        return t;
    }

}
