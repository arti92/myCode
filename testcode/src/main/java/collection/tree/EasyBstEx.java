package collection.tree;

/**
 * @author Arti.Jadhav
 */
public class EasyBstEx {
    /*  public int countNegatives(int[][] grid) {
          TreeNode node = null;
          node = createBst(node,grid);


          return -1;
      }

      private TreeNode createBst(TreeNode node, int[][] grid) {
          while (grid.length<0){
              if(grid[0][0] < 1)
                  createBst(node,grid);
          }
          return node;
      }*/
    static int ct = 0;

    public static void main(String[] args) {
        EasyBstEx easy = new EasyBstEx();
        int[][] grid = {{1, -1}, {-1, -1}};
        int[] arr = {0, 2, 1, 0};
        //easy.countNegatives(grid);
        System.out.println("moutain number:: " + easy.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        TreeNode node = null;
        for (int i = 0; i < arr.length; i++) {
            node = createTree(arr[i], node);
        }
        getCount(node);
        return ct == 0 ? ct : ct - 1;
    }


    private TreeNode getCount(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node != null) {
            System.out.println(ct + " ::loop count:: " + node.data);
            ct++;
            node = getCount(node.right);
        }
        return node;
    }


    private TreeNode createTree(int i, TreeNode node) {

        // System.out.println(ct + " ::loop count:: ");

        if (node == null) {
            node = new TreeNode(i);
            return node;
        }
        /*if (node.data > i) {
            ct--;
            node.left = createTree(i, node.left);
        }*/
        if (node.data < i) {
            // ct++;
            node.right = createTree(i, node.right);

        }
        return node;
    }
}
