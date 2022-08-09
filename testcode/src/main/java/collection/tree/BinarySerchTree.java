package collection.tree;


/**
 * @author Arti.Jadhav
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Insert , delete, and serch operations on binary search tree(BSt)
 */
public class BinarySerchTree {
    public static void main(String[] args) {
        System.out.println("BST");
        int[] root = {8, 3, 10, 1, 6, 14, 4, 13, 7};
        TreeNode node = null;
        BinarySerchTree bst = new BinarySerchTree();
       /* node =bst.insertBST( 1,node);
        System.out.println("next........");
        node = bst.insertBST( 2,node);
        System.out.println("next........");
        node =bst.insertBST( 5,node);
        System.out.println("next........");
        node = bst.insertBST( 3,node);
        System.out.println("next........");
        node =bst.insertBST( 6,node);*/
        for (int i = 0; i < root.length; i++) {
            node = bst.insertBST(root[i], node);
        }
        preOrderTree(node);
        System.out.println();

        TreeTraversal tt = new TreeTraversal();
        System.out.println("levelOrderTravarsalUsingQueue");
        tt.levelOrderTravarsalUsingQueue(node);
        System.out.println("levelOrderTravarsalUsingRecursion");
        tt.levelOrderTravarsalUsingRecursion(node);
        System.out.println("reverse level order");
        System.out.println(levelOrderBottom(node));

       /* node = bst.deleteElementBst(node, 88888);
        System.out.println("after delete");
        preOrderTree(node);
        System.out.println();
        int key = 100;
       TreeNode isNode = bst.searchElement(node, key);
       if(isNode!=null && isNode.val == key)
           System.out.println("val is present:: ");
       else
           System.out.println("val is not present....");
        System.out.println("after serch");
        preOrderTree(isNode);
        System.out.println();
        System.out.println("actual node:: ");
        preOrderTree(node);*/


    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        //Collections.reverse(res);
        return res;
    }

    /***
     * verry very gr8 logic
     * @param node
     * @param level
     */
    private static void helper(TreeNode node, int level) {
        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val); //as per levels its added values in respective array
        System.out.print(level + " level:: " + node.val + " , ");

        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    private static TreeNode createBST(int[] root, int i, TreeNode parent) {

        int j = 0;
        if (i >= root.length)
            return null;

        TreeNode node = new TreeNode(root[i]);

        if (parent == null)
            parent = node;
        System.out.println("parent node:: " + parent.val);

        if (parent.val > root[i]) {
            System.out.println(i + " parent left node:: " + parent.val);
            parent.left = node;
            System.out.println(i + " parent left node val:: " + parent.left.val);
            node.left = createBST(root, ++i, parent);
        } else if (parent.val < root[i]) {
            System.out.println(i + " parent right node:: " + parent.val);
            parent.right = node;
            System.out.println(i + " parent right val node:: " + parent.right.val);
            node.right = createBST(root, ++i, parent);
        } else {
            node = createBST(root, ++i, parent);
        }


        return node;
    }

    //NLR - node.val - left - right
    public static void preOrderTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTree(root.left);
        preOrderTree(root.right);
    }

    private Boolean searchElementBst(TreeNode node, int key) {

        if (node == null)
            return null;

        if (node.val == key)
            return true;
        while (node.val == key) {
            if (key < node.val)
                node = searchElement(node.left, key);
            else if (key > node.val)
                node = searchElement(node.right, key);
        }

        return false;
    }

    private TreeNode searchElement(TreeNode node, int key) {

        TreeNode temp = null;
        if (node == null)
            return null;

        if (node.val == key) {
            temp = node;
            return temp;
        }
        while (node != null && node.val != key) {
            if (key < node.val)
                node = searchElement(node.left, key);
            else if (key > node.val)
                node = searchElement(node.right, key);
        }
        return node;
    }

    //nodes start modifiying becoz of recursion,parent gets node left n right  modified values in recusrion
    private TreeNode deleteElementBst(TreeNode node, int key) {

        if (node == null)
            return null;

        //navigate throughtout the tree
        if (key < node.val) {
            node.left = deleteElementBst(node.left, key);//assign left to its parent as it is recursive calls
        } else if (key > node.val) {
            node.right = deleteElementBst(node.right, key); //assign right to its parent
        }// in this else val is matched
        else if (key == node.val) {
            // node with one child or no child
            if (node.right == null || node.left == null) {
                //1) to leaf node which don't have any left or right child
                //recursivaly it will assign null to its parent node(node.left or right whichever one is assigned)
                TreeNode temp = null;

                //2) to node which have either left or right node it will assign that node to its parent node
                temp = node.left == null ? node.right : node.left;
                //if temp contains value means one child is present which can be left or right and that will be assign

                //NO Need of extra check as temp can be null or can have left or right node
                //whichever present that will assign back to its parent
                //if(temp==null){
                return temp;
                //}

            }//3) means node have both child
            else {
                //now need to replace the key node val to either min of right or max of left
                //let replace min of right
                TreeNode nodeSuccesor = null;
                nodeSuccesor = getSuccesor(node.right);
                System.out.println();
                System.out.println("min val:: " + nodeSuccesor.val);

                //replace nodesuccesor to current node val(as it matched with key)
                node.val = nodeSuccesor.val;

                //now delete dupliacte val with same logic
                //as we know it present in right subtree so only delete from right subtree
                node.right = deleteElementBst(node.right, node.val);
            }
        }//no element in tree
        else
            return null;
        return node;
    }

    private TreeNode getSuccesor(TreeNode node) {
        if (node == null)
            return null;

        //the min of right subtree will be last left leaf node of that subtree
        //the max of left subtree will be last right leaf node of that subtree

        //loop till we find left leaf node
        while (node.left != null) {
            node = getSuccesor(node.left);
        }
        return node;
    }

    /**
     * Working BST
     *
     * @param key
     * @param parent
     * @return
     */
    //cannot use parent if this meth is static
    private TreeNode insertBST(int key, TreeNode parent) {
        //TreeNode node = new TreeNode(key);

        if (parent == null) {
            System.out.println("key:: " + key);
            parent = new TreeNode(key);
        }

        //do comparision recursivaly and then create node and again add these recursivaly
        if (parent.val > key) {
            System.out.println(parent.val + " left:: " + key);
            parent.left = insertBST(key, parent.left);
        } else if (parent.val < key) {
            System.out.println(parent.val + " right:: " + key);
            parent.right = insertBST(key, parent.right);
        }
        return parent;
    }
}

