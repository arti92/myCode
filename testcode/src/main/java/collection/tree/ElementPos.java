package collection.tree;

import java.util.Arrays;

/**
 * @author Arti.Jadhav
 */
public class ElementPos {

    public static void main(String[] args) {
        System.out.println("find 1st nad last position of element");
        int[] root = {0, 0, 1, 1, 1, 2, 4, 4, 4, 4, 5, 5, 5, 6, 8, 8, 9, 9, 10, 10, 10};

        ElementPos ep = new ElementPos();
        ep.searchRange(root, 8);


    }


    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};
        int position = 0;
        // TreeNode node = createTreeForRange(nums, 0, target, position, pos);
        createForRange(nums, 0, target, pos);
        System.out.println(Arrays.toString(pos));
        // TreeTraversal.preOrderTree(node); //NLR
        return null;
    }

    private TreeNode createTreeForRange(int[] nums, int i, int target, int position, int[] pos) {

        if (i >= nums.length)
            return null;
        System.out.println(i + " incoming i and data:: " + nums[i]);
        System.out.println("position:: " + position);

        TreeNode node = new TreeNode(nums[i]);
        if (target == node.data) {
            if (pos[0] == -1)
                pos[0] = i;
            else
                pos[1] = i;
        }
        System.out.println(i + " incoming i and left:: " + nums[i]);
        node.left = createTreeForRange(nums, 2 * i + 1, target, ++position, pos);
        System.out.println(i + " incoming i and right:: " + nums[i]);
        node.right = createTreeForRange(nums, 2 * i + 2, target, ++position, pos);

        return node;
    }

    private void createForRange(int[] nums, int i, int target, int[] pos) {

        if (i >= nums.length)
            return;
        System.out.println(i + " incoming i and data:: " + nums[i]);

        //TreeNode node = new TreeNode(nums[i]);
        if (target == nums[i]) {

            if (pos[0] == -1 || pos[0] > i)
                pos[0] = i;
            if ((pos[0] == -1 && pos[1] == -1) || pos[1] < i)
                pos[1] = i;
          /*
            if(pos[0]==-1) {
                pos[0] = i;
                pos[1] = i;
                System.out.println(" 0 th array:: "+Arrays.toString(pos));
            }
            else
                pos[1]=i;
            if(pos[0] > i)
                pos[0] = i;
            if(pos[1] < i)
                pos[0] = i;*/
        }
        System.out.println(i + " incoming i and left:: " + nums[i]);
        createForRange(nums, 2 * i + 1, target, pos);
        System.out.println(i + " incoming i and right:: " + nums[i]);
        createForRange(nums, 2 * i + 2, target, pos);
    }


}
