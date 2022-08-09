package algo;

/**
 * @author Arti.Jadhav
 */
public class BinarySearch {

    public int searchByItration(int[] nums, int target) {

        if (nums.length == 0)
            return -1;

        int l = 0;
        int h = nums.length - 1;

        if (l == h) {
            if (nums[l] == target)
                return l;
            else
                return -1;
        }
        //by itration
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if (target > nums[mid]) {
                    l = mid + 1;
                } else if (target < nums[mid]) {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    public int searchByRecursion(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int l = 0;
        int h = nums.length - 1;
        return searchIndex(nums, l, h, target);
    }

    private int searchIndex(int[] nums, int l, int h, int target) {
        if (l == h) {
            if (nums[l] == target)
                return l;
            else
                return -1;
        }
        if (l > h)
            return -1;

        int mid = (l + h) / 2;

        if (nums[mid] == target)
            return mid;
        if (target < nums[mid])
            return searchIndex(nums, l, mid - 1, target);
        if (target > nums[mid])
            return searchIndex(nums, mid + 1, h, target);

        return -1;
    }
}
