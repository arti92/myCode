package collection.tree;

/**
 * @author Arti.Jadhav
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A Tree is typically traversed in two ways:
 * Breadth First Traversal (Or Level Order Traversal)
 * Depth First Traversals
 * Inorder Traversal (Left-Root-Right)
 * Preorder Traversal (Root-Left-Right)
 * Postorder Traversal (Left-Right-Root)
 */
//All four traversals require O(n) time as they visit every node exactly once.
public class TreeTraversal {

    /*public TreeTraversal(T data) {
        super(data);
    }

    public static class TreeNode<T> {
        public TreeNode<T> left;
        public TreeNode<T> right;
        public int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }*/
    //Level order traversal of a tree is breadth first traversal for the tree.

    //LNR - left - node.data - right
    public static void inOrderTree(TreeNode root) {

        if (root == null)
            return;
        inOrderTree(root.left);
        System.out.print(root.val + " ");
        inOrderTree(root.right);

    }

    //DST
    //NLR - node.data - left - right
    public static void preOrderTree(TreeNode root) {

        if (root == null) return;

        System.out.print(root.val + " ");
        preOrderTree(root.left);
        preOrderTree(root.right);
    }

    //LRN- left - right - node.data
    public static void postOrderTree(TreeNode root) {
        if (root == null) return;

        postOrderTree(root.left);
        postOrderTree(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * calculate the height of tree
     * then use for loop till height and print elements at that height
     * so reach till height need to traves till that
     * and worst case scenario - right handed tree will take O(n^2) timeperiod
     *
     * @param root
     */
    public void levelOrderTravarsalUsingRecursion(TreeNode root) {
        int height = getHeight(root, "root");
        System.out.println("height:: " + height);

        List<List<Integer>> all = new ArrayList<>();
        //to print in reverse order
        for (int i = height - 1; i >= 0; i--) {
            // printLevelsByOl(root, i,"root");
            List<Integer> nodes = new ArrayList<>();
            printLevels(root, i, nodes);
            System.out.println("nodes:: " + nodes);
            all.add(nodes);
        }
        System.out.println(all);
    }

    private void printLevels(TreeNode root, int height, List<Integer> nodes) {
        int l = height, r = height;
        // System.out.println(" l:: "+l+" r:: "+r);
        if (height == 0) {
            System.out.print(root.val + " , ");
            nodes.add(root.val);
            return;
        } else {
            if (root.left != null)
                printLevels(root.left, --l, nodes);
            if (root.right != null)
                printLevels(root.right, --r, nodes);
        }

    }

    private void printLevelsByOl(TreeNode root, int height, String name) {


        if (root == null)
            return;
        System.out.println("height:: " + height + " name:: " + name);
        System.out.println("root val: " + root.val);
        if (height == 0) {
            System.out.print(root.val + " , ");
            return;
        } else {
            //if(root.left!=null)
            printLevelsByOl(root.left, height - 1, "left");
            //if(root.right!=null)
            printLevelsByOl(root.right, height - 1, "right");
        }
    }

    private int getHeight(TreeNode root, String name) {
        if (root == null)
            return 0;
        int l, r = 0;
        //if(root.left!=null)
        //System.out.println(" val:: " + root.val + " name:: " + name);
        l = getHeight(root.left, "left");
        //if(root.right!=null)
        r = getHeight(root.right, "right");
        // System.out.println("l:: " + l + "r:: " + r);
        //+1 to increase there size with each iterations
        if (l > r)
            return l + 1;
        return r + 1;
    }

    /**
     * add root in q and then take elemet from q (to print val) and will add its left and right to q again
     * till no elemnt to add or poll will keep doing
     * <p>
     * so will poll current element and add its left n right -- in fifo manner these left n right will again get poll
     * and
     * there resp children gets add
     * <p>
     * so we keeping children's to fifo q and  iterate over childers hench level wise print
     *
     * @param root
     */

    public static void levelOrderTravarsalUsingQueue(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println();
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll(); //root , again children get and there children will add dequeued
            System.out.print(tempNode.val + " ");
            if (tempNode.left != null)
                queue.add(tempNode.left); // adding children's //enqueued
            if (tempNode.right != null)
                queue.add(tempNode.right);// adding children's
        }
    }

    public static void main(String[] args) {
        System.out.println("TreeTraversal...");
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 2};

        TreeTraversal treeTraversal = new TreeTraversal();
        // treeTraversal.levelOrderTravarsalUsingQueue();
    }
}
