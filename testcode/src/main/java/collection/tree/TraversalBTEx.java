package collection.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class TraversalBTEx {

    public static void main(String[] args) {

        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TraversalBTEx rb = new TraversalBTEx();
        rb.buildTree(pre, in);
        TreeTraversal.preOrderTree(rb.buildTree(pre, in));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();


        for (int i = 0; i < preorder.length; i++) {
            list.add(preorder[i]);
        }

        TreeNode node = null;

        //for(int i=0;i< inorder.length;i++){
        // if(inorder[i]==list.get(0)){
        //    list.remove(0);
        node = createTree(inorder, 0, inorder[0], list);
        // }
        // }
        return node;
    }

    private TreeNode createTree(int[] inorder, int i, int data, List<Integer> list) {
        TreeNode node = null;
        if (list.size() <= 0)
            return null;
        if (i == -1 || i > inorder.length)
            return null;
        System.out.println(list.get(0) + " from incoming i:: " + i);
        if (inorder[i] == list.get(0)) {
            list.remove(0);
            node = new TreeNode(inorder[i]);
            System.out.println(i + " :i and left data: " + inorder[i]);
            node.left = createTree(inorder, --i, data, list);
            System.out.println(i + " :i and right data: ");
            node.right = createTree(inorder, i++, data, list);
        } else {
            //i++;
            System.out.println(i + " :i and else data: " + inorder[i]);
            node = createTree(inorder, ++i, data, list);
        }

        return node;

    }
}
