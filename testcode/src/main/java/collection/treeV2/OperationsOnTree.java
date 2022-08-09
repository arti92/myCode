package collection.treeV2;

import collection.tree.TreeNode;
import collection.tree.TreeTraversal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class OperationsOnTree {

    public static void main(String[] args) {
        System.out.println("different operations on tree..");
        //create
        // Integer[] root = {2, null, 3, null, 4, null, 5, null, 6}; //unstructured tree
        Integer[] root = {4, 2, 7, 1, 3};
        OperationsOnTree oot = new OperationsOnTree();
        // TreeNode treeNode = oot.createBinaryTree(root);
        TreeNode treeNode = oot.createBinarySearchTree(root);
        // TreeNode treeNode = oot.createBSTFromSortedArray(root);
        System.out.printf("level order traversal:::");
        TreeTraversal.levelOrderTravarsalUsingQueue(treeNode);
        TreeNode treeNodes = oot.addInBinarySearchTree(treeNode, 5);
        System.out.println("after add");
        TreeTraversal.levelOrderTravarsalUsingQueue(treeNodes);
        System.out.printf("....end");
    }

    private TreeNode createBSTFromSortedArray(Integer[] root) {

        TreeNode node = null;
        node = createSortedBstRecusrion(root, node, 0, root.length - 1);
        return node;
    }

    private TreeNode createSortedBstRecusrion(Integer[] root, TreeNode node, int start, int end) {

        if (start > end) return null;

        int mid = (start + end) / 2;

        if (node == null) node = new TreeNode(root[mid]);

        node.left = createSortedBstRecusrion(root, node.left, start, mid - 1);

        node.right = createSortedBstRecusrion(root, node.right, mid + 1, end);

        return node;
    }

    /**
     * creatation of binary tree(structured tree)
     * unstructured tree yet to create (containing nulls in between)
     */
    public TreeNode createBinaryTree(Integer[] root) {
        return binaryTreeRecursion(root, 0);
    }

    //binary tree with in between null values -- not working --op 2 3 5 instead of 2 3 4 5 6
    private TreeNode binaryTreeRecursion(Integer[] root, int i) {
        if (i >= root.length) return null;
        if (root[i] == null) return null;
        TreeNode node = new TreeNode(root[i]);
        node.left = binaryTreeRecursion(root, 2 * i + 1);
        node.right = binaryTreeRecursion(root, 2 * i + 2);
        return node;
    }

    static Integer count = 0;

    //TODO : Create for duplicate entries and null entries
    public TreeNode createBinarySearchTree(Integer[] root) {

        TreeNode node = null;

        for (int i = 0; i < root.length; i++) {
            int finalI = i;
            count = Math.toIntExact(Arrays.stream(root).filter(num -> num == root[finalI]).count());
            // System.out.println("i:: "+i+" val:: "+root[i]+" count:: "+count);
            node = bstRecursion(root, i, node);
        }
        return node;
    }

    public TreeNode addInBinarySearchTree(TreeNode node, int val) {

        if (node == null)
            return new TreeNode(val);

        if (val < node.val)
            node.left = addInBinarySearchTree(node.left, val);
        else if (node.val < val)
            node.right = addInBinarySearchTree(node.right, val);

        return node;
    }

    private TreeNode bstRecursion(Integer[] root, Integer val, TreeNode node) {
        if (node == null) {
            node = new TreeNode(root[val]);
        }

        if (node.val > root[val]) node.left = bstRecursion(root, val, node.left);
        if (node.val < root[val]) node.right = bstRecursion(root, val, node.right);

        return node;
    }
}
