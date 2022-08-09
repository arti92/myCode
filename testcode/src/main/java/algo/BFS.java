package algo;

import collection.tree.BinaryTree;
import collection.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Arti.Jadhav
 */

/**
 * breadth-first-search  - Tree
 */
public class BFS {
    public static void main(String[] args) {
        System.out.println("breadth-first-search Algo");
        int[] root = {1, 2, 3, 4, 5, 6};
        //for creating tree
        BinaryTree bt = new BinaryTree();
        TreeNode node = bt.createTreeArray(root, 0, "root");
        System.out.println("preorder......");
        bt.preOrderTree(node);//5 1 4 3 6

        int[] root2 = {1, 2, 3, 4, 5};
        TreeNode node2 = bt.createTreeArray(root2, 0, "root");
        System.out.println("preorder node2......");
        bt.preOrderTree(node2);//5 1 4 3 6

        TreeNode nodeRes = mergeTrees(node, node2);
        System.out.println("preorder nodeRes......");

        List<Integer> tree = new ArrayList<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(null);
        tree.add(5);
        //  for (int i = 0; i < tree.size(); i++) {
        nodeRes = createTreeArray(tree, 0);
        //   }
        bt.preOrderTree(nodeRes);//5 1 4 3 6
    }

    public static TreeNode createTreeArray(List<Integer> root, int i) {
        // TreeNode node = null;
        // System.out.println(name + " from incoming i:: " + i);
        if (i >= root.size())
            return null;
      /*  System.out.println(i+" :i and left data: "+root[i]);
        node.left = createTreeArray(++i, root);
        System.out.println(i+" :i and right data: "+root[i]);
        node.right = createTreeArray(++i, root);*/

        //if(i < root.length){
        //  TreeNode node = null;
        if (root.get(i) == null)
            return null;
        TreeNode node = new TreeNode(root.get(i));
        //  System.out.println(i + " :i and left data: " + root[i]);
        node.left = createTreeArray(root, 2 * i + 1);
        //  System.out.println(i + " :i and right data: " + root[i]);
        node.right = createTreeArray(root, 2 * i + 2);
        //}

        return node;
    }

    public static TreeNode mergeTrees(TreeNode root11, TreeNode root21) {

        List<Integer> newNodeList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        //newNodeList.add(root11.data + root21.data);

        q.add(root11);
        q2.add(root21);


        while (!q.isEmpty() && !q2.isEmpty()) {
            TreeNode root1 = q.poll();
            TreeNode root2 = q2.poll();

            root1.data += root2.data;
            System.out.print(" newdata:: " + root1);
            newNodeList.add(root1.data);
            if (root1.left != null && root2.left != null) {
                q.add(root1.left);
                q2.add(root2.left);
            } else if (root1.left == null && root2.left == null) {
                //q.add(null);
                q2.add(null);
            } else if (root1.left == null && root2.left != null) {
                q.add(new TreeNode(0));
                q2.add(root2.left);
            } else if (root1.left != null && root2.left == null) {
                q2.add(new TreeNode(0));
                q.add(root1.left);
            }
            if (root1.right != null && root2.right != null) {
                q.add(root1.right);
                q2.add(root2.right);
            } else if (root1.right == null && root2.right == null) {
                //q.add(null);
                q2.add(null);
            } else if (root1.right == null && root2.right != null) {
                q.add(new TreeNode(0));
                q2.add(root2.right);
            } else if (root1.right != null && root2.right == null) {
                q2.add(new TreeNode(0));
                q.add(root1.right);
            }

           /* if (root1.right != null)
                q.add(root1.right);
            if (root2.left != null)
                q2.add(root2.left);
            if (root2.right != null)
                q2.add(root2.right);*/
            System.out.println("list:: " + newNodeList);
            //  createTreeArray(newNodeList,0);
        }
        return createTreeArray(newNodeList, 0);
    }
}
