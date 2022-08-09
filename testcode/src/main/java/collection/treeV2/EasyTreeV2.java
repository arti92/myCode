package collection.treeV2;

import collection.tree.BinaryTree;
import collection.tree.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Arti.Jadhav
 */
// BFS Examples
//By Recursion - get height, upto that height print all nodes
//By Q - add level wise node in Q and go on
public class EasyTreeV2 {
    public static void main(String[] args) {

        System.out.println("avrage levels...");
        EasyTreeV2 etv = new EasyTreeV2();

        OperationsOnTree oot = new OperationsOnTree();

        //  int[] root = {1, 2, 3, 4, 5, 6, 7, 8};
        // TreeNode treeNode = BinaryTree.createTreeArray(root, 0, "root");

        Integer[] nodes = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode treeNode = oot.createBinaryTree(nodes);
        // System.out.println("Addition of level nodes:: " + etv.printLevelNodes(treeNode));
        //System.out.println("Average of levels:: " + etv.averageOfLevels(treeNode));
        // System.out.println("is cousines:: " + etv.isCousins(treeNode, 4, 5));
        // System.out.println("deepest sum:: " + etv.deepestLeavesSum(treeNode));
        List<Integer> list = new ArrayList<>();
        System.out.println("min depath:: " + etv.minDepth(treeNode, list, 1));
        System.out.printf("list:: " + list);
        int i = list.get(0);
        //System.out.println("print level nodes bt using Q");
        //etv.printLevelNodesByQ(treeNode);
    }

    // will give minimum height/Depth, bt will nt work for left /right sided tree - as min depth will be 1
    public Integer minDepth(TreeNode root, List<Integer> list, Integer i) {

        Integer l = 0, r = 0;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            System.out.printf(i + "leaf nodes:: " + root.val);
            list.add(i);
            return root.val;
        }
        l = minDepth(root.left, list, ++i);
        l = minDepth(root.right, list, ++i);

       /* if (l < r){
        list.add(r+1);
            return r+1;
        }
        return l + 1;*/
        return 0;
    }

    private void printLevelNodesByStack(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);
        while (!stack.empty()) {
            System.out.println("val:: " + stack.peek().val);
            TreeNode tempNode = stack.pop();
            if (tempNode.left != null)
                stack.push(tempNode.left);
            if (tempNode.right != null)
                stack.push(tempNode.right);
        }
    }

    private void printLevelNodesByQ(TreeNode treeNode) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        queue.add(treeNode);
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " :: value:: " + queue.peek().val);
            TreeNode tempNode = queue.poll();
            // System.out.println("val:: "+tempNode.val);
            if (tempNode.left != null) {
                leftList.add(tempNode.left.val);
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                rightList.add(tempNode.right.val);
                queue.add(tempNode.right);
            }
        }
        System.out.println(" ::left list:: " + leftList);
        System.out.println(" ::rightList:: " + rightList);
    }


    public int deepestLeavesSum(TreeNode root) {

        int height = getHeight(root);
        System.out.println("height:: " + height);
        List<Integer> list = new ArrayList<>();
        //  System.out.println("list sum:: "+getSumWithHeight(root, list)+" list:: "+list);
        return getSum(root, height - 1);

    }

    private int getSum(TreeNode root, int height) {
        int l = height, r = height;

        if (root == null)
            return 0;
        if (height == 0) {
            return root.val;
        }

        return getSum(root.left, --l) + getSum(root.right, --r);
    }

    // not worked - both logic in one method
    private int getSumWithHeight(TreeNode root, List<Integer> list) {
        int l = 0, r = 0;
        if (root == null) {
            return 0;
        }
       /* if(height==0){
            return root.val;
        }*/
        list.add(root.val);

        l = getSumWithHeight(root.left, list);
        r = getSumWithHeight(root.right, list);

        if (l < r) {
            return r + 1;
        }
        return l + 1;
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        int height = getHeight(root);

        System.out.println("height:: " + height);
        for (int i = 0; i < height; i++) {

            Map<Integer, List<Integer>> mapNode = new HashMap<>();
            List<Integer> nodeList = new ArrayList<>();

            isCousinsAtLevel(root, i, mapNode, nodeList, "root", root);
            System.out.println(mapNode + " ::nodeMap:: " + nodeList);

            AtomicBoolean xCousine = new AtomicBoolean(false);
            AtomicBoolean yCousine = new AtomicBoolean(false);
            mapNode.entrySet().stream().forEach(entry -> {
                System.out.println(entry.getKey() + " ::vals:: " + entry.getValue());
                if (entry.getValue().contains(x)) {
                    xCousine.set(true);
                } else if (entry.getValue().contains(y)) {
                    yCousine.set(true);
                } else if (entry.getValue().contains(x) && entry.getValue().contains(y)) {
                    xCousine.set(false);
                    yCousine.set(false);
                }
            });

            if (xCousine.get() == true && yCousine.get() == true)
                return true;
           /* if (nodeLeftList.contains(x) && nodeLeftList.contains(y))
                return false;
            else if (nodeRightList.contains(x) && nodeRightList.contains(y))
                return false;
            else if((nodeLeftList.contains(x) || nodeRightList.contains(y) )&&
                    (nodeLeftList.contains(y) || nodeRightList.contains(x)))
                return true;*/

            // nodeMap.
        }

        return false;
    }

    private void isCousinsAtLevel(TreeNode root, int height, Map<Integer, List<Integer>> nodeMap,
                                  List<Integer> nodeList, String name, TreeNode parentNode) {
        int l = height, r = height;
        if (root == null) {
            return;
        }

        if (height == 0) {
            System.out.println("parent:: " + parentNode.val + " level node val:: " + root.val);
            // if (root.val == x || root.val == y)
           /* if (name.equalsIgnoreCase("left"))
                nodeLeftList.add(root.val);
            else if(name.equalsIgnoreCase("right"))
                nodeRightList.add(root.val);*/
            //already list present
            if (nodeMap.containsKey(parentNode.val)) {
                nodeList = nodeMap.get(parentNode.val);
                nodeList.add(root.val);
                nodeMap.put(parentNode.val, nodeList);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(root.val);
                nodeMap.put(parentNode.val, newList); // for new parent add new list
            }
            return;
        }

        isCousinsAtLevel(root.left, --l, nodeMap, nodeList, "left", root);
        isCousinsAtLevel(root.right, --r, nodeMap, nodeList, "right", root);

       /* return isCousinsAtLevel(root.left, --l, nodeMap, "left") +
                isCousinsAtLevel(root.right, --r, nodeMap, "right");*/
    }

    private List<Double> averageOfLevels(TreeNode treeNode) {

        int height = getHeight(treeNode);

        List<Double> avgList = new ArrayList<>();
        //start from last level - go till first level
        for (int j = 0; j < height; j++) {
            System.out.println("level....");
            //give total of each node on that level
            //System.out.println("total:: "+printLevelNodes(treeNode, j,0));

            //give total of each node on that level
            List<Double> countList = new ArrayList<>();
            System.out.println("addision:: " + avgLevelNodes(treeNode, j, countList));
            Double add = countList.stream().reduce(0.0, Double::sum);
            System.out.println(add + "average:: " + add / countList.size());

            avgList.add(add / countList.size());
        }

        return avgList;
    }

    /**
     * O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in
     * the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).
     * <p>
     * avrage case o(n)
     * worst case o(n^2)
     */
    private int printLevelNodes(TreeNode treeNode, int j, int total) {
        //l and r keep left and right node in synch...hench level wise for both directions
        int l = j, r = j;
        //int total=0;
        if (treeNode == null)
            return 0;
        if (j == 0) {
            //will get level node values...so perform operations on node over here
            System.out.print(treeNode.val + " , "); //print each node
            return treeNode.val; // will give level node
        }

        //node iterator in downward direction and height start decrementing, so when height = means last node
        // for 2nd level - height will be 2 , so for second level -- till height become 0,hench --l
        // as both are run parallel ... addition over here gives total of each node
        return printLevelNodes(treeNode.left, --l, total)
                + printLevelNodes(treeNode.right, --r, total);

        //so that --l will reflect
        //  return l + r;
    }

    private long avgLevelNodes(TreeNode treeNode, int j, List<Double> nodeList) {
        int l = j, r = j;
        if (treeNode == null) {
            return 0;
        }
        if (j == 0) {
            System.out.print(" :: " + treeNode.val + " , "); //print each node
            nodeList.add((double) treeNode.val);
            return treeNode.val; // will give level node
        }

        return avgLevelNodes(treeNode.left, --l, nodeList)
                + avgLevelNodes(treeNode.right, --r, nodeList);
    }

    //Breadth First Serch type ex


    private int getHeight(TreeNode root) {
        int l, r = 0;

        if (root == null)
            return 0;

        l = getHeight(root.left);
        r = getHeight(root.right);

        if (l < r)
            return r + 1;
        return l + 1;
    }
}
