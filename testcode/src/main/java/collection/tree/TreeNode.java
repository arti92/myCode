package collection.tree;

/**
 * @author Arti.Jadhav
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public int data;

    public TreeNode(int val) {
        this.val = val;
        this.data = val;
    }

    public TreeNode() {

    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
