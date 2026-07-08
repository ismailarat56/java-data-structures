public class BinaryTree {
    TreeNode root;

    // Tree oluşturulurken root node belirlenir.
    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // Root, tree'nin en üst node'udur.
    public void printRoot() {
        System.out.println("Root: " + root.data);
    }

    // Preorder: Root -> Left -> Right
    public void preorder(TreeNode node) {
        System.out.print(preorderText(node));
    }

    // Inorder: Left -> Root -> Right
    public void inorder(TreeNode node) {
        System.out.print(inorderText(node));
    }

    // Postorder: Left -> Right -> Root
    public void postorder(TreeNode node) {
        System.out.print(postorderText(node));
    }

    // Preorder sonucunu metin olarak hazırlar.
    private String preorderText(TreeNode node) {
        if (node == null) {
            return "";
        }

        String result = node.data;
        String left = preorderText(node.left);
        String right = preorderText(node.right);

        if (!left.isEmpty()) {
            result += " " + left;
        }

        if (!right.isEmpty()) {
            result += " " + right;
        }

        return result;
    }

    // Inorder sonucunu metin olarak hazırlar.
    private String inorderText(TreeNode node) {
        if (node == null) {
            return "";
        }

        String result = "";
        String left = inorderText(node.left);
        String right = inorderText(node.right);

        if (!left.isEmpty()) {
            result += left + " ";
        }

        result += node.data;

        if (!right.isEmpty()) {
            result += " " + right;
        }

        return result;
    }

    // Postorder sonucunu metin olarak hazırlar.
    private String postorderText(TreeNode node) {
        if (node == null) {
            return "";
        }

        String result = "";
        String left = postorderText(node.left);
        String right = postorderText(node.right);

        if (!left.isEmpty()) {
            result += left + " ";
        }

        if (!right.isEmpty()) {
            result += right + " ";
        }

        result += node.data;

        return result;
    }
}
