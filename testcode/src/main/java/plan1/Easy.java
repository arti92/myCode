package plan1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class Easy {
    /**
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     */
    //by binary search
    public int search(int[] nums, int target) {

        if (nums.length == 0)
            return 0;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if (target < nums[mid]) {
                    r = mid - 1;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to
     * find the first bad version. You should minimize the number of calls to the API.
     */
    public int firstBadVersionByRec(int n) {
        if (n == 0)
            return 0;
        if (n == 1 && isBadVersion(n) == true)
            return 1;

        return recusrionSerch(0, n, n);

    }

    //working
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int firstBadVersionMoreTime(int n) {
        if (n == 0)
            return 0;
        if (n == 1 && isBadVersion(n) == true)
            return 1;

        int l = 0;
        int h = n;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (isBadVersion(mid) == true && isBadVersion(mid - 1) == false)
                return mid;
            else {
                if (isBadVersion(mid) == false)
                    l = mid + 1;
                else if (isBadVersion(mid + 1) == true)
                    h = mid - 1;
            }
        }
        return 0;
    }

    private int recusrionSerch(int l, int r, int n) {

        if (l == r) {
            if (isBadVersion(l) == true && isBadVersion(l - 1) == false)
                return l;
            else return 0;
        }
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        if (isBadVersion(mid) == true && isBadVersion(mid - 1) == false)
            return mid;
        //left side
        if (isBadVersion(mid - 1) == true) {
            return recusrionSerch(0, mid - 1, n);
        } else if (isBadVersion(n) == true) {
            return recusrionSerch(mid + 1, n, n);
        }
        return mid;
    }

    public boolean isBadVersion(int version) {
        List<Integer> ver = new ArrayList<Integer>();
        ver.add(2);
        ver.add(3);
        ver.add(4);
        ver.add(5);
        if (ver.contains(version))
            return true;
        return false;
    }


    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0)
            return 0;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if (target < nums[mid]) {
                    r = mid - 1;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                }
            }
        }
        System.out.println("l:: " + l + " r:: " + r);
        return l;
    }
}
