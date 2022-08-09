package collection.treeV2;

/**
 * @author Arti.Jadhav
 */
class AvlTreeNode {
    int val;
    int height;
    AvlTreeNode left;
    AvlTreeNode right;

    public AvlTreeNode(int val) {
        this.val = val;
    }
}

public class AVLTree {

    private static int getBalanceFactor(AvlTreeNode node) {
        return getHeight(node.right) - getHeight(node.left);
    }

    private static void updateHeight(AvlTreeNode node) {

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static int getHeight(AvlTreeNode node) {
        return node == null ? -1 : node.height;
    }

    public static void main(String[] args) {
        System.out.println("test AVL Tree");
        AvlTreeNode node = null;

        Integer[] root = {40, 20, 10, 25, 30, 22, 50};


       /* for (int i = 0; i < 3; i++) {
            node = createBSTTree(root, i, node);
        }
        System.out.println("level order traversal:::");
        System.out.print("[");
        printTree(node);
        System.out.println();
        // node = RotateTreeLeft(node);
        node = rebalanceAvlTree(node);*/
        for (int i = 0; i < root.length; i++) {
            node = insertAvlTree(node, root[i]);
            //  System.out.println("in[");
            //printTree(node);
            node = rebalanceAvlTree(node);
            //System.out.println("re[");
            //printTree(node);
        }
        System.out.print("after balance rotation:: [");
        printTree(node);

/*
        for (int i = 0; i < root.length; i++) {
            node = insertAvlBSTree(node, root[i]);
        }
        System.out.print("after balance rotation:: [");
        printTree(node);*/

    }

    private static AvlTreeNode insertAvlBSTree(AvlTreeNode node, int val) {
        if (node == null)
            node = new AvlTreeNode(val);

        else if (val < node.val) {
            node.left = insertAvlBSTree(node.left, val);
            if (getBalanceFactor(node) == -2) {
                if (val < node.left.val)
                    node = RotateTreeRight(node);
                else {
                    node.left = RotateTreeLeft(node.left);
                    node = RotateTreeRight(node);
                }
            }
        } else if (val > node.val) {
            node.right = insertAvlBSTree(node.right, val);
            if (getBalanceFactor(node) == 2) {
                if (val > node.right.val)
                    node = RotateTreeLeft(node);
                else {
                    node.right = RotateTreeRight(node.right);
                    node = RotateTreeLeft(node);
                }
            }
        }

        updateHeight(node);
        return node;
    }

    private static void printTree(AvlTreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + ",");
        printTree(node.left);
        printTree(node.right);
    }


    private static AvlTreeNode createBSTTree(Integer[] root, Integer i, AvlTreeNode node) {
        if (node == null)
            return new AvlTreeNode(root[i]);

        if (root[i] < node.val)
            node.left = createBSTTree(root, i, node.left);

        if (root[i] > node.val)
            node.right = createBSTTree(root, i, node.right);

        updateHeight(node);
        // node = rebalanceAvlTree(node);

        return node;
    }

    private static AvlTreeNode insertAvlTree(AvlTreeNode node, int val) {
        if (node == null)
            return new AvlTreeNode(val);

        if (val < node.val)
            node.left = insertAvlTree(node.left, val);

        if (val > node.val)
            node.right = insertAvlTree(node.right, val);

        updateHeight(node);
        return node;
    }

    private static AvlTreeNode insertAndBalanceTree(AvlTreeNode node, int val) {
        if (node == null)
            return new AvlTreeNode(val);

        if (val < node.val) {
            node.left = insertAndBalanceTree(node.left, val);
            if (getBalanceFactor(node) < -1) {
                int leftBalance = getBalanceFactor(node.left);
                if (leftBalance > 0) {
                    node = RotateTreeLeft(node.left);
                    node = RotateTreeRight(node);
                } else if (leftBalance <= 0) {
                    node = RotateTreeRight(node);
                }
            }
        } else if (val > node.val) {
            node.right = insertAndBalanceTree(node.right, val);
            if (getBalanceFactor(node) > 1) {
                int rightBalance = getBalanceFactor(node.right);
                //RL Rotation (if right child is left heavy -ve val)
                if (rightBalance < 0) {
                    node = RotateTreeRight(node.right);
                    node = RotateTreeLeft(node);
                }//LL Rotation (if right child is right heavy(>0) or balanced (=0))
                else if (rightBalance >= 0) {
                    node = RotateTreeLeft(node);
                }
            }
        }

        updateHeight(node);
        return node;
    }

    private static AvlTreeNode rebalanceAvlTree(AvlTreeNode node) {

        //right - left {-1.0,1} allowed hence check < -1 or > +1 (child can be balanced hence 0 considered)
        int balanceFactor = getBalanceFactor(node);

        //-ve hence left heavy (either RR Rotation or LR Rotation )
        if (balanceFactor < -1) {
            int leftBalance = getBalanceFactor(node.left);
            //LR Rotation (if left child is right heavy)
            if (leftBalance > 0) {
                node.left = RotateTreeLeft(node.left);
                node = RotateTreeRight(node);
            }//RR Rotation (if left child is left heavy(<0) or balanced (=0))
            else
                //if (leftBalance <= 0) {
                node = RotateTreeRight(node);
            //}
        } // +ve hence right heavy (either LL Rotation or RL Rotation)
        else if (balanceFactor > 1) {
            int rightBalance = getBalanceFactor(node.right);

            //RL Rotation (if right child is left heavy -ve val)
            if (rightBalance < 0) {
                node.right = RotateTreeRight(node.right); // it roatate only 2 keys(last) , so reattacged for final rotatation
                node = RotateTreeLeft(node);
            }//LL Rotation (if right child is right heavy(>0) or balanced (=0))
            else
                //if (rightBalance >= 0) {
                node = RotateTreeLeft(node);
            //}
        }

        return node;
    }

    private static AvlTreeNode RotateTreeRight(AvlTreeNode node) {

        AvlTreeNode leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private static AvlTreeNode RotateTreeLeft(AvlTreeNode node) {
        AvlTreeNode rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
    }


}
