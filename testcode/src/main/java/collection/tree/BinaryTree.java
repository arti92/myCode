package collection.tree;


import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class BinaryTree {

    static Scanner sc;
    static int count = 0;

    /**
     * Working Binary Tree
     */
    public static TreeNode createTreeArray(int[] root, int i, String name) {
        // TreeNode node = null;
        // System.out.println(name + " from incoming i:: " + i);
        if (i >= root.length)
            return null;
      /*  System.out.println(i+" :i and left data: "+root[i]);
        node.left = createTreeArray(++i, root);
        System.out.println(i+" :i and right data: "+root[i]);
        node.right = createTreeArray(++i, root);*/

        //if(i < root.length){
        TreeNode node = new TreeNode(root[i]);
        //  System.out.println(i + " :i and left data: " + root[i]);
        node.left = createTreeArray(root, 2 * i + 1, "left");
        //  System.out.println(i + " :i and right data: " + root[i]);
        node.right = createTreeArray(root, 2 * i + 2, "right");
        //}

        return node;
    }

    //PreOrder Traversal
    //InOrder Traversal
    //PostOrder Traversal

    public static void main(String[] args) {
        System.out.println("binary tree");
        //[5,1,-1,4,3,-1,-1,6,-1,-1,-1]
        sc = new Scanner(System.in);
      /* int i = 0 ;
        TreeNode node = createTree(i);
        System.out.println("node:: " + node.data);
        inOrderTree(node);
        System.out.println();
        preOrderTree(node);//5 1 4 3 6
        System.out.println();
        postOrderTree(node);*/

        // int[] root = {2,4,7,-1,-1,-1,-1,1,8,-1,3,-1,-1};
        //int[] root = {5, 1, 4, -1, -1, 3, 6};
        count = 0;
        // int[] root = {1, 2, 3, 4, 5, 6};
        int[] root = {10, 9, 8, 7, 6, 5, 4, 2};
        TreeNode node = createTreeArray(root, 0, "root");
        System.out.println("preorder......");
        // preOrderTree(createTreeArray(root, 0, "Root"));//5 1 4 3 6
        System.out.println();
        TreeTraversal tt = new TreeTraversal();
        TreeTraversal.preOrderTree(node);
        System.out.println(".....inorder.....");
        TreeTraversal.inOrderTree(node);
        System.out.println("....post order...");
        TreeTraversal.postOrderTree(node);
        System.out.println(".....level order ....q..");
        tt.levelOrderTravarsalUsingQueue(node);
        // System.out.println("levelOrderTravarsalUsingQueue");
        // tt.levelOrderTravarsalUsingQueue(node);
        System.out.println("levelOrderTravarsalUsingRecusrsion");
        tt.levelOrderTravarsalUsingRecursion(node);
        System.out.println("finished");
        // System.out.println("node count:: " + getNodeCount(node));
        // System.out.println();
        //     getTreeHeight(node);
        //count = count==0?count:count-1;
        //System.out.println("last count:: "+count);
        // System.out.println(hasPathSum(node, 8,"root"));
        // System.out.println("path sum:: ");
        // System.out.println(getPathSum(node,8));

        //     System.out.println(countNodes(node));
        //       searchElement(node,7);
        //   deleteElement(node, 4);

        // System.out.println("level order");
        // System.out.println(testLevelOrder(node));
        System.out.println("level order");
        System.out.println(levelOrder(node));
        System.out.println("reverse level order");
        System.out.println(levelOrderBottom(node));

        //  BinaryTreeExamples btExample = new BinaryTreeExamples();
        //  Boolean isValid = btExample.isValidBST(createTree(0, root));
        //  System.out.println("isvalid:: " + isValid);
    }

    //require NLR - preorder
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return op;
        List<Integer> nodes = new ArrayList<>();
        //nodes.add(root.val);
        // op.add(nodes);
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println("q data");
            for (TreeNode node : queue) {
                System.out.print(node.val + " , ");
            }
            nodes = new ArrayList<>();
            System.out.println();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) { // to add level values in nodes we added for so for 2nd level 1st 2 get added
                TreeNode tempNode = queue.poll();
                nodes.add(tempNode.val); //added values which is q for processing
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                    //nodes.add(tempNode.left.val);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                    //nodes.add(tempNode.right.val);
                }
            }
            if (nodes.size() > 0)
                op.add(nodes);
        }
        return op;

    }

    public static List<List<Integer>> levelOrderReverse(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return op;
        //List<Integer> nodes = new ArrayList<>();
        //nodes.add(root.val);
        // op.add(nodes);
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println("q data");
            for (TreeNode node : queue) {
                System.out.print(node.val + " , ");
            }
            List<Integer> nodes = new ArrayList<>();
            System.out.println();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) { // to add level values in nodes we added for so for 2nd level 1st 2 get added
                TreeNode tempNode = queue.poll();
                nodes.add(tempNode.val); //added values which is q for processing
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                    //nodes.add(tempNode.left.val);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                    //nodes.add(tempNode.right.val);
                }
            }
            if (nodes.size() > 0)
                op.add(nodes);
        }
        return op;

    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        //Collections.reverse(res);
        return res;
    }

    private static void helper(TreeNode node, int level) {
        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val);

        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public static List<List<Integer>> testLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        List<List<Integer>> al = new ArrayList<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            System.out.println("q data");
            for (TreeNode node : q) {
                System.out.print(node.val + " , ");
            }
            List<Integer> all = new ArrayList<Integer>();
            int qsize = q.size();
            System.out.println("qsize: " + qsize);
            for (int i = 0; i < qsize; i++) {
                TreeNode front = q.getFirst();
                all.add(front.val);
                q.removeFirst();
                if (front.left != null) {
                    q.addLast(front.left);
                }
                if (front.right != null) {
                    q.addLast(front.right);
                }
            }
            al.add(all);
            // for(int x:all){
            //     System.out.print(x+" ");
            // }
            // System.out.print("\n");
        }
        return al;
    }

    /*private static List<List<Integer>> getLevelOrder(TreeNode root, List<List<Integer>> op) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            List<Integer> nodes = new ArrayList<>();
            if (tempNode.left != null){
                queue.add(tempNode.left);
                nodes.add(tempNode.left.val);
            }
            if (tempNode.right != null){
                queue.add(tempNode.right);
                nodes.add(tempNode.right.val);
            }
            op.add(nodes);
        }


        return op;
    }
*/
    private static List<List<Integer>> getNodeLevelOrder(TreeNode root, List<List<Integer>> op) {
        if (root == null)
            return null;
        List<Integer> nodes = new ArrayList<>();
        System.out.println(root.val);
        if (root.left != null)
            nodes.add(root.left.val);
        if (root.right != null)
            nodes.add(root.right.val);
        if (nodes.size() > 0)
            op.add(nodes);
        getNodeLevelOrder(root.left, op);
        getNodeLevelOrder(root.right, op);

        return op;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum, String name) {

        // System.out.println(getNodeVal(root));//will give sum of all nodes or number of nodes
        //System.out.println(targetSum+" ::val:: "+getPathSum(root,targetSum));
        //System.out.println(getPathSum(root,targetSum)==targetSum?true:false);
        System.out.println("sum:: " + targetSum + " name:: " + name);
        if (root == null) return false;

        else if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
        else {
            System.out.println(" root data:: " + root.val);
            return hasPathSum(root.left, targetSum - root.val, "left")
                    || hasPathSum(root.right, targetSum - root.val, "right");
        }
        //  return false;

    }

    private static int getPathSum(TreeNode root, int targetSum) {
        int val = 0;
        if (root == null)
            return 0;
        if (targetSum == 0)
            return 0;

        if (targetSum != 0) {
            System.out.println(root.val + " :left " + targetSum);
            val = getPathSum(root.left, targetSum - root.val);
        }
        if (targetSum != 0) {
            System.out.println(root.val + "  right:: " + targetSum);
            val = getPathSum(root.right, targetSum - root.val);
        }

        //  System.out.println(root.val+" :valpre:: right:: "+targetSum);


        // val+=  getPathSum(root.left,targetSum)+ getPathSum(root.right,targetSum)+root.val;

        return targetSum;
    }


    //sum calculated subtree wise
    private static int getNodeVal(TreeNode root) {

        //int val= 1; //will give node count
        int val = root.val; //will give sum of all nodes
        System.out.println("val:: " + val);
        if (root == null)
            return 0;

        count += root.val;
        //System.out.println(root.val+" :val:: sum:: "+count);
        if (root.left != null) {
            val += getNodeVal(root.left);
        }
        if (root.right != null) {
            val += getNodeVal(root.right);
        }
        // val+=  getNodeVal(root.left)+ getNodeVal(root.right)+ root.val;
        System.out.println(root.val + " :valpre:: sumpre:: " + val);
        return val;
    }

    private static int getNodeCount(TreeNode node) {
        int i = 0;
        if (node == null)
            return 0;
        System.out.println("left count i ::" + i);
        i = getNodeCount(node.left) + getNodeCount(node.right) + 1;
        System.out.println(node.val + " :: right count i ::" + i);
        return i;
    }

    //will give height og left tree
    private static TreeNode getleftTreeHeight(TreeNode node) {
        if (node == null)
            return null;
        while (node != null) {
            count++;
            System.out.println("count:: " + count);
            node = getleftTreeHeight(node.left);
        }
        return node;
    }

    private static TreeNode getTreeHeight(TreeNode node) {
        if (node == null)
            return null;
        while (node != null) {
            count++;
            System.out.println("right tree height count:: " + count);
            node = getTreeHeight(node.right);
        }
        return node;
    }

    private static TreeNode getNodeCounts(TreeNode root) {
        if (root == null)
            return null;

        //in static variable make sure assign count=0 in main function
        count++;
        System.out.println(root.val + " ::node count:: " + count);
        if (root.left != null) {

            root.left = getNodeCounts(root.left);
        }
        if (root.right != null) {
            root.right = getNodeCounts(root.right);
        }
        return root;
    }

    public static int countNodes(TreeNode root) {

        getNodeCounts(root);
        return count;
    }

    private static TreeNode searchElement(TreeNode root, int element) {

        if (root == null)
            return null;
        System.out.println("root val:: " + root.val);

        if (root.val == element) {
            System.out.println("matched");
            return root;
        }
        if (root.left != null)
            root.left = searchElement(root.left, element);
        if (root.right != null)
            root.right = searchElement(root.right, element);

        return root;
    }

    //not working
    private static TreeNode deleteElement(TreeNode root, int element) {

        TreeNode temp = getReplaceValue(root);
        System.out.println("rightmost node:: " + temp.val);

        if (root == null)
            return null;
        if (root.val == element) {
            root.val = temp.val;
            root = removeReplaceData(root);
            return root;
        }
        if (root.left != null)
            root.left = deleteElement(root.left, element);
        if (root.right != null)
            root.right = deleteElement(root.right, element);

        return root;
    }

    private static TreeNode removeReplaceData(TreeNode temp) {
        while (temp.right.right != null) {
            temp = removeReplaceData(temp.right);
        }
        temp.right = null;
        return temp;
    }

    private static TreeNode getReplaceValue(TreeNode node) {
        TreeNode temp = node;
        while (temp.right != null) {
            temp = getReplaceValue(temp.right);
        }
        return temp;
    }


    private static TreeNode createTreeFromArray(int[] root) {
        TreeNode node = null;
        int j = 1, k = 2;
        //for(int i=0;i< root.length;i++){
        node = createTreeArray(root, 0, "root");
        //node = insertLevelOrder(root, node, 0);
        // }
        System.out.println("in pre:: " + node.val);
        // TreeTraversal.preOrderTree(node);
        System.out.println("finished...");
        return null;
    }

    // Function to insert nodes in level order
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                            int i) {
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            // root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }


    //NLR - node.data - left - right
    public static void preOrderTree(TreeNode root) {

        if (root == null) return;

        System.out.print(root.val + " ");
        preOrderTree(root.left);
        preOrderTree(root.right);
    }
}
