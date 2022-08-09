package collection.treeV2;

import collection.tree.TreeNode;
import collection.tree.TreeTraversal;

import java.util.*;
import java.util.stream.Collectors;

public class BstEasy {
    public static void main(String[] args) {
        System.out.printf("BST easy probs");
        BstEasy be = new BstEasy();

        //  Integer[] root = {4, 2, 6, 1, 3, 5,9};
        Integer[] root = {90, 69, 49, 89, 52, 99};
        OperationsOnTree oot = new OperationsOnTree();
        TreeNode treeNode = oot.createBinarySearchTree(root);
        System.out.printf("level order traversal:::");
        TreeTraversal.levelOrderTravarsalUsingQueue(treeNode);
        System.out.println();
        //be.findTargetNew(treeNode, 9);
        //  be.lowestCommonAncestor(root,2,8);
        //be.isValidBST(treeNode);
        //System.out.println("modes:: " + be.findMode(treeNode));
        //be.sumOfLeaf(treeNode);
        System.out.println("min diff:: " + be.minDiffInBST(treeNode));
        System.out.printf("....end");

    }

    private void sumOfLeaf(TreeNode treeNode) {
        System.out.println("leaf tree sum:: " + sumLeftNodeLeftTree(treeNode, false));
        // System.out.println("only child root node of tree:: " + sumLeftNode(treeNode, true));
    }

    //all leaf nodes
    private int sumLeftNodeLeftTree(TreeNode root, boolean isLeft) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null && isLeft) {
            //System.out.println(" vals:: " + root.val);
            return root.val;
        }
        //  return sumLeftNodeLeftTree(root.left, true) + root.val;
        int val = root.val
                // (respective parent)
                + sumLeftNodeLeftTree(root.left, true)
                //( provide left all child values)
                + sumLeftNodeLeftTree(root.right, true)
                //(provide right child nodes)
                ; // sum of all nodes
        //and goes on subtree vise

        //it calculate sub tree wise
        // 2 ->6, 6 -> 11, 4->21 for  4,2,6,1,3,5
        // 2,1,3 - 6--- 6,5 ---11 , 4---2,6,1,3,5 ---21
        System.out.println(root.val + " valss:: " + val);
        return val;
    }

    //only child nodes
    private int sumLeftNode(TreeNode root, boolean isLeft) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return sumLeftNode(root.left, true) + sumLeftNode(root.right, true); // all child nodes
        // return sumLeftNode(root.left, true) + sumLeftNode(root.right, false); //only left child nodes of full tree
        //return sumLeftNode(root.left, true); //only left child nodes of left tree ( only 1 node - left most node)
    }

    public int minDiffInBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();

        //pathList.add(root.val);
        traverseTreeDiff(root, list, pathList);
        System.out.println("list:: " + list);
        System.out.println("min list:: " + Collections.min(list));
        return 0;
    }

    private void traverseTreeDiff(TreeNode root, List<Integer> list, List<Integer> pathList) {

        if (root == null)
            return;
        Set<Integer> lists = pathList.stream().map(l -> Math.abs(l - root.val)).collect(Collectors.toSet());
        list.addAll(lists);
        System.out.println("list:: " + list);
        pathList.add(root.val);
        System.out.println("pathList: " + pathList);

        traverseTreeDiff(root.left, list, pathList);
        traverseTreeDiff(root.right, list, pathList);
    }

    private void traverseTreeDiff(TreeNode root, List<Integer> list, int min, int max, String s) {

        if (root == null)
            return;

        // if (root.left != null)
      /*  if(s.equalsIgnoreCase("left")) {
            System.out.println("left:: "+root.val+" min:: "+min+" max:: "+max);
            list.add(min - root.val);
        }

        //if (root.right != null)
        if(s.equalsIgnoreCase("right")) {
            System.out.println("right:: "+root.val+" min:: "+min+" max:: "+max);
            list.add(root.val - max);
        }*/

        if (min > root.val)
            list.add(min - root.val);
        else if (min < root.val)
            list.add(root.val - min);


        if (max > root.val)
            list.add(max - root.val);
        else if (max < root.val)
            list.add(root.val - max);

        traverseTreeDiff(root.left, list, Math.min(root.val, min), Math.max(root.val, max), "left");
        traverseTreeDiff(root.right, list, Math.min(root.val, min), Math.max(root.val, max), "right");

    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> mapCount = new HashMap<>();
        traverseTreeFind(root, mapCount);
        System.out.println("map:::");
        mapCount.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " :: " + s.getValue()));
        int size = Math.max((int) mapCount.values().stream().filter(v -> v > 1).count(), 0);
        int[] mode = new int[size];
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
            if (entry.getValue() > 1) {
                mode[c] = entry.getKey();
                c++;
            }
        }
        return mode;
    }

    private void traverseTreeFind(TreeNode root, HashMap<Integer, Integer> mapCount) {
        if (root == null)
            return;

        if (!mapCount.isEmpty() && mapCount.get(root.val) != null && mapCount.get(root.val) > 0) {
            int count = mapCount.get(root.val) + 1;
            mapCount.put(root.val, mapCount.get(root.val) + 1);
        } else
            mapCount.put(root.val, 1);

        traverseTreeFind(root.left, mapCount);
        traverseTreeFind(root.right, mapCount);
    }

    public boolean isValidBST(TreeNode root) {

        boolean isValid;
        List<Integer> leftNodeList = new ArrayList<>();
        List<Integer> rightNodeList = new ArrayList<>();

        HashMap<String, List<Integer>> map = new HashMap<>();
        leftNodeList.add(root.val);
        map.put("left", leftNodeList);
        map.put("right", rightNodeList);

        isValid = traverseTree(root.left, leftNodeList, map, "left");
        System.out.println("list :: " + leftNodeList);
        System.out.println(isValid + " left");
        leftNodeList = new ArrayList<>();
        rightNodeList = new ArrayList<>();
        if (isValid) {
            rightNodeList.add(root.val);
            map.put("right", rightNodeList);
            map.put("left", leftNodeList);
            isValid = traverseTree(root.right, leftNodeList, map, "right");
        }
        System.out.println(isValid + " right");
        System.out.println("list2 :: " + rightNodeList);

        int min = Integer.MIN_VALUE;
        int max = (int) Double.MAX_VALUE;
        isValid = traverseTreeByMinMax(root, min, max);

        System.out.println("op:: " + isValid);
        return isValid;
    }

    private boolean traverseTreeByMinMax(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val < min || root.val > max)
            return false;

        return traverseTreeByMinMax(root.left, min, root.val) && traverseTreeByMinMax(root.right, root.val, max);
    }

    private boolean traverseTree(TreeNode root, List<Integer> leftList, HashMap<String, List<Integer>> map, String level) {
        boolean isValid = true;
        if (root == null)
            return true;

        // if (level.equalsIgnoreCase("left")) {

        if (!map.isEmpty() && map.get("left").stream().anyMatch(val -> val < root.val)) {
            return false;
        }
        // } else if (level.equalsIgnoreCase("right")) {
        if (!map.isEmpty() && (map.get("right").stream().anyMatch(val -> val > root.val))) {
            return false;
        }
        map.get(level).add(root.val);

        //  }

        //leftList.add(root.val);
        isValid = traverseTree(root.left, leftList, map, "left");
        if (isValid)
            isValid = traverseTree(root.right, leftList, map, "right");
        return isValid;
    }

    private Boolean findTargetNew(TreeNode treeNode, int i) {


        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

    //Not working
    public boolean findTarget(TreeNode root, int k) {

        int largestVal = getRightMostNode(root);
        int smallestVal = getLeftMostNode(root);
        System.out.printf("largetsVal::" + largestVal);
        int diff = Math.abs(Math.abs(k) - largestVal);
        int diffS = Math.abs(k - smallestVal);

        if (diff >= largestVal || diff == 0)
            return false;
        else if (diffS <= smallestVal || diffS == 0)
            return false;
        else
            return true;

        // return false;
    }

    private int getLeftMostNode(TreeNode root) {
        if (root.left == null)
            return root.val;
        return getRightMostNode(root.left);
    }

    private int getRightMostNode(TreeNode root) {
        if (root.right == null)
            return root.val;
        return getRightMostNode(root.right);
    }
}
