package collection.treeV2;

import collection.tree.BinaryTree;
import collection.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
//Mostly DFS prob
public class EasyTree {

    public static void main(String[] args) {
        System.out.println("easy examples");
        EasyTree et = new EasyTree();
        int[] root = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode treeNode = BinaryTree.createTreeArray(root, 0, "root");

        // et.rangeSumBST(treeNode, 7, 15);

        // int[] root2 = {2, 1, 3};
        // TreeNode treeNode2 = BinaryTree.createTreeArray(root2, 0, "root");
        //System.out.println("op");
        //List<Integer> mergeList = et.mergeTrees(treeNode, treeNode2);
        // System.out.println("mergeList:: "+mergeList);

        //int add = recursionTest(5);
        //System.out.println("addition of all numbers"+add);
        // System.out.println("sum of left leaves:: " + et.sumOfLeftLeaves(treeNode));

        //System.out.println("print node string with ():: " + et.preorderStringTraversal(treeNode));

        // List<String> list = new ArrayList<>();
        //System.out.println("get binaryTreePaths till leaf list:: " + et.treeTraversal(treeNode, "", list));

        //int h = et.getHeight(treeNode);
        //System.out.println("Height:: " + h);

        //List<Integer> list1 = new ArrayList<>();
        //System.out.println("pre order list:: " + et.preorderTraversal(treeNode, list1));

        System.out.println(et.minDepth(treeNode));
    }

    private Integer minDepth(TreeNode treeNode) {

        String treeNodeVal = treeNode.val + "->";
        List<Integer> list = new ArrayList<>();
        List<Integer> sizeList = new ArrayList<>();
        System.out.println();
        minDepthRec(treeNode, list, sizeList);
        System.out.println("list:: " + sizeList);
        return 0;
    }

    private void minDepthRec(TreeNode treeNode, List<Integer> list, List<Integer> sizeList) {
        if (treeNode == null)
            return;
        list.add(treeNode.val);

        if (treeNode.left == null && treeNode.right == null) {

            System.out.println("before list:: " + list);
            sizeList.add(list.size());
            System.out.println("mid list:: " + sizeList);
            list = new ArrayList<>();
            System.out.println("after list:: " + list);
            System.out.println("leaf:: " + treeNode.val);
            // return left+1;
        }
        minDepthRec(treeNode.left, list, sizeList);
        minDepthRec(treeNode.right, list, sizeList); //adding
        // parent right node

        // return 0;
        // return 0;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = getPath(root, low, high);
        System.out.println("list of paths:: " + list);

        List<Integer> arrl = list.stream().filter(integer -> (integer >= low && integer <= high))
                .collect(Collectors.toList());
        System.out.println("arrl:: " + arrl);
        Integer arr = list.stream().filter(integer -> integer >= low && integer <= high)
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("sum:: " + arr);
        return arr;
    }

    public List<Integer> getPath(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();

        if ((root.right != null && root.right.val < low) || (root.left != null && root.left.val > high)) {
            list.add(root.val);
            return list;
        }

        list.add(root.val);
        list.addAll(getPath(root.left, low, high));
        list.addAll(getPath(root.right, low, high));

        return list;
    }


    //FIXME: how addAll working?
    public List<Integer> mergeTrees(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        int l, r = 0;
        if (root1 == null && root2 != null) {
            root1 = new TreeNode(0);
        }
        //return null;

        if (root1 != null && root2 == null) {
            root2 = new TreeNode(0);
        }
        if (root1 == null && root2 == null)
            return new ArrayList<>(); // how this break addAll() ...how it doesnt go in infinte loop

        list.add(root1.val + root2.val);

        // System.out.print(root1.val + " :: " + root2.val + ",");
        list.addAll(mergeTrees(root1.left, root2.left)); // may be for blank list, addAll return false hence breaking
        // the loop
        list.addAll(mergeTrees(root1.right, root2.right));

        return list;
        //   return null;
    }

    private static int recursionTest(int i) {
        if (i == 0)
            return 0; // to break recursion
        return i + recursionTest(i - 1); //5+4 ....and so on
    }

    //left leave nodes
    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeavesHelper(root, false);
    }

    private int sumOfLeftLeavesHelper(TreeNode root, boolean isLeftNode) {

        if (root == null)
            return 0;

        if (isLeftNode) {
            if (root.left == null && root.right == null) // check for leaf node
                return root.val;
        }
        //addision for returned root.val data (keep record of all addistions)
        return sumOfLeftLeavesHelper(root.left, true)
                + sumOfLeftLeavesHelper(root.right, false);

        //return root.val;
    }

    private String preorderStringTraversal(TreeNode treeNode) {

        if (treeNode == null)
            return "";

        if (treeNode.left == null && treeNode.right == null)
            return treeNode.val + "";

        if (treeNode.right == null)
            return treeNode.val + "(" + preorderStringTraversal(treeNode.left) + ")";

        return treeNode.val + "(" + preorderStringTraversal(treeNode.left) + ")" + "("
                + preorderStringTraversal(treeNode.right) + ")";

    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        return treeTraversal(root, "", list);
    }

    private int getHeight(TreeNode root) {
        int l, r = 0;
        if (root == null)
            return 0;
        l = getHeight(root.left);
        r = getHeight(root.right);
        //NOTE: once all node get iterates,
        // then below code will execute and will increment the val,
        if (l > r)
            return l + 1;
        return r + 1;
    }

    //For getting path till leaf
    public List<String> treeTraversal(TreeNode root, String treePath, List<String> list) {
        if (root == null)
            return null;
        //will add for each leaf node
        if (root.left == null && root.right == null) {
            treePath = treePath + root.val;
            list.add(treePath);
        }
        // get every traversal node val when pass in method
        //will append with every path node
        treeTraversal(root.left, treePath + root.val + "->", list);
        treeTraversal(root.right, treePath + root.val + "->", list);

        return list;
    }

    //NLR
    private List<Integer> preorderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null)
            return null;

        System.out.print(treeNode.val + " , ");
        list.add(treeNode.val);
        preorderTraversal(treeNode.left, list);
        preorderTraversal(treeNode.right, list);
        return list;
    }
}
