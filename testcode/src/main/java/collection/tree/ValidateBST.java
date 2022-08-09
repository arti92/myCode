package collection.tree;

/**
 * @author Arti.Jadhav
 */
class ValidateBST {
    public static void main(String[] args) {

        ValidateBST bt = new ValidateBST();

        //  System.out.println("isValidd " + bt.isValidBST(null));
    }

    public boolean isValidBST(TreeNode root) {

        return validate(root, root.left, root.right);
      /*  if(root.right==null || root.left==null)
            return false;
        if (!(root.val > root.left.val && root.val < root.right.val))
            return false;

        return true;*/
    }

    private boolean validate(TreeNode parent, TreeNode left, TreeNode right) {

        //System.out.println("parent:: "+parent.data);
        if (parent == null)
            return true;

        if (left != null && (parent.data <= left.data))
            return false;

        if (right != null && (parent.data >= right.data))
            return false;

        return validate(parent.left, parent, right) && validate(parent.right, left, parent);
    }


}
