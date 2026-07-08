public class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    // Her node kendi verisini ve çocuklarını tutar.
    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
