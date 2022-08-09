package collection.treeV2;

import collection.tree.TreeNode;
import collection.tree.TreeTraversal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
public class AvlTreeProb {
    public static void main(String[] args) {
        System.out.println("avl tree prob");

        Integer[] root = {1, 2, 3, 7, 9, 11, 12, 14, 15, 17};
        OperationsOnTree oot = new OperationsOnTree();
        TreeNode treeNode = oot.createBinaryTree(root);
        System.out.printf("level order traversal:::");
        TreeTraversal.levelOrderTravarsalUsingQueue(treeNode);
        System.out.println();

        AvlTreeProb avp = new AvlTreeProb();
        //avp.isBalanced(treeNode);
        treeNode = avp.balanceBST(treeNode);//worked
        System.out.printf("balanced order traversal:::");
        TreeTraversal.levelOrderTravarsalUsingQueue(treeNode);
        System.out.println();

    }

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        list = getSortedList(root, list);
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println("soreted list:: " + list);
        TreeNode node = null;
       /* Set<Integer> balanceList = new LinkedHashSet<>();
         binarySearchAlgo(list, balanceList, 0, list.size());
        System.out.println("set");

        balanceList.stream().forEach(l->System.out.print(l+" , "));
        for(Integer set : balanceList){
           node =  insertNode(node,set);
        }*/

        node = insertBalnaceNode(node, list, 0, list.size() - 1);
        // node = helper(list,0,list.size()-1);
        return node;
    }

    //get ecah mid of list and add that in tree for balancing tree
    private void binarySearchAlgo(List<Integer> list, Set<Integer> root, int leftMid, int rightMid) {
        int mid = (leftMid + rightMid) / 2;
        System.out.println("left:: " + leftMid + " mid:: " + mid + " right:: " + rightMid);
        if (rightMid < leftMid || leftMid == mid || rightMid == mid) {
            System.out.println("null:: " + list.get(mid));
            root.add(list.get(mid));
            return;
            //  root = insertNode(root, list.get(mid));
            // return null;
        }
//        root = insertNode(root, list.get(mid));
        root.add(list.get(mid));
        binarySearchAlgo(list, root, leftMid, mid);//once left over
        binarySearchAlgo(list, root, mid, rightMid);//goes to right side of tree

      /*  // while (mid <= 0) {
        if (root.val < list.get(mid))
            binarySearchAlgo(list, root, leftMid, mid);
        else if (root.val > list.get(mid))
            binarySearchAlgo(list, root, mid, rightMid);
        else {
            System.out.println("mid val" + list.get(mid) );
            root = insertNode(root, list.get(mid));
        }*/
        //  }
        // return root;
    }

    private TreeNode insertNode(TreeNode node, Integer val) {

        System.out.println("root val:: " + val);
        if (node == null)
            return new TreeNode(val);

        if (val < node.val)
            node.left = insertNode(node.left, val);
        if (val > node.val)
            node.right = insertNode(node.right, val);

        return node;
    }

    public TreeNode helper(List<Integer> l, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (high + low) / 2;
        TreeNode cur = new TreeNode(l.get(mid));
        cur.left = helper(l, low, mid - 1);
        cur.right = helper(l, mid + 1, high);
        return cur;
    }


    private TreeNode insertBalnaceNode(TreeNode node, List<Integer> list, int leftMid, int rightMid) {

        if (rightMid < leftMid) {
            return null;
        }
        int mid = (leftMid + rightMid) / 2;
        System.out.println("left:: " + leftMid + " mid:: " + mid + " right:: " + rightMid);

        System.out.println("root val:: " + list.get(mid));
        if (node == null)
            node = new TreeNode(list.get(mid));
        //  if (val < node.val)
        node.left = insertBalnaceNode(node.left, list, leftMid, mid - 1);
        //if (val > node.val)
        node.right = insertBalnaceNode(node.right, list, mid + 1, rightMid);
        return node;
    }

    private List<Integer> getSortedList(TreeNode root, List<Integer> list) {
        if (root == null)
            return null;
        getSortedList(root.left, list);
        list.add(root.val);
        getSortedList(root.right, list);
        return list;
    }

    public boolean isBalanced(TreeNode root) {

        System.out.println(itrateBst(root, 0, 0));

        return false;
    }

    private boolean itrateBst(TreeNode root, int lc, int rc) {

        if (root == null) {
            return true;
        }


        System.out.println("lc:: " + lc + " rc:: " + rc);
        if (root.left == null && root.right == null) {
            int diff = rc - lc;
            System.out.println("diff:: " + diff);
            if (diff > 1 || diff < -1)
                return false;
        }

        return itrateBst(root.left, root.left == null ? lc : ++lc, rc)
                && itrateBst(root.right, lc, root.right == null ? rc : ++rc);

    }

    public int getBalanceFactor(TreeNode node) {

        return node.right.val - node.left.val;
    }
}
