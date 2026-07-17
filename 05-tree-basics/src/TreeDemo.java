public class TreeDemo {
    public static void main(String[] args) {
        // Node'ları oluşturuyoruz.
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");

        // Tree bağlantılarını kuruyoruz.
        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.right = nodeF;

        // Binary tree root node ile başlar.
        BinaryTree tree = new BinaryTree(nodeA);

        tree.printRoot();

        System.out.println();
        System.out.println("Preorder:");
        tree.preorder(tree.root);

        System.out.println();
        System.out.println();
        System.out.println("Inorder:");
        tree.inorder(tree.root);

        System.out.println();
        System.out.println();
        System.out.println("Postorder:");
        tree.postorder(tree.root);

        System.out.println();
    }
}
