package src.Tree;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree t = initialize();
        System.out.println("Initialized tree");
        System.out.print("Inorder traversal: ");
        t.inOrderTraversal(t.root);

        System.out.print("\npreOrder traversal: ");
        t.preOrderTraversal(t.root);

        System.out.print("\npostOrder traversal: ");
        t.postOrderTraversal(t.root);

        System.out.print("\nLevel order traversal: ");
        t.levelOrderTraversal(t.root);

        System.out.println("\nHeight of the tree:"+t.height(t.root));
        System.out.println("\nTree diameter: "+t.diameter(t.root));
    }

    static BinaryTree initialize () {
        int[] inputArr = {5,8,6,3,7,9};
        BinaryTree t = new BinaryTree();
        t.root = t.insertLevelOrder(inputArr,0);
        return t;
    }

    static BinaryTree initialize1() {
        BinaryTree bt = new BinaryTree();
        bt.root = bt.insertLevelOrder(new int[]{4},0);
        bt.root.left = bt.insertLevelOrder(new int[] {5,6},0);
        bt.root.left.right = bt.insertLevelOrder(new int[] {8,9,10,11,12,13,14},0);
        return bt;
    }

    static BinaryTree initialize2() {
        return null;
    }
}
