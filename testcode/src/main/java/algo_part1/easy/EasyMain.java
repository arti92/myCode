package algo_part1.easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class EasyMain {
    static List<Integer> ver = new ArrayList<Integer>();

    EasyMain() {
        for (int i = 3; i <= 10; i++) {
            ver.add(i);
        }
        System.out.println("added");
    }

    public static void main(String[] args) {

        System.out.println("main start");
        EasyMain em = new EasyMain();
        int[] nums = {1};
        //System.out.println(em.search(nums, 14));
        //System.out.println("version:: " + em.firstBadVersion(9));
        //  System.out.println("sorted:: " + em.sortedSquares(nums));
        em.sortedSquares(nums);
    }

    /**
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100]
     */
    public int[] sortedSquares(int[] nums) {

        for (int n = 0; n < nums.length; n++) {
            nums[n] = nums[n] * nums[n];
        }
        if(nums.length <=1 )
            return nums;
        return mergeSqSort(nums);
    }

    private int[] mergeSqSort(int[] nums) {
        int l = 0, r = 0;
        if (nums.length <= 1)
            return null;
        int mid = nums.length / 2;
        int leftArr[] = new int[mid];
        int rightArr[] = new int[nums.length - mid];

        //add left array
        for (int a = 0; a < mid; a++) {
            leftArr[a] = nums[a];
        }

        //add right array
        for (int a = mid; a < nums.length; a++) {
            rightArr[r] = nums[a];
            r++;
        }
       // System.out.println("left:: " + Arrays.toString(leftArr));
       // System.out.println("right:: " + Arrays.toString(rightArr));
        mergeSqSort(leftArr);
        mergeSqSort(rightArr);

        mergeAll(leftArr, rightArr, nums);
        System.out.println("sorted arrays:: " + Arrays.toString(nums));
        return nums;
    }

    private int[] mergeAll(int[] leftArr, int[] rightArr, int[] nums) {

        int l = 0, r = 0, i = 0;
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) {
                nums[i++] = leftArr[l++];
            } else {
                nums[i++] = rightArr[r++];
            }
        }

        while (l< leftArr.length)
            nums[i++] = leftArr[l++];
        while (r< rightArr.length)
            nums[i++] = rightArr[r++];

        System.out.println("sorted arrays:: " + Arrays.toString(nums));
        return nums;
    }

    public int firstBadVersion(int n) {

        if (isBadVersion(n)) {
            int start = 0;
            int end = n;
            while (start <= end) {
                BigInteger startB = BigInteger.valueOf(start);
                BigInteger endB = BigInteger.valueOf(end);
                BigInteger midDivide = new BigInteger("2");
                BigInteger add = BigInteger.valueOf(start + end);
                BigInteger data = add.divide(midDivide);
                int mid = data.intValue();

                System.out.println("mid:: " + mid);
                if (!isBadVersion(mid - 1) && isBadVersion(mid))
                    return mid;
                else {
                    if (isBadVersion(mid)) {
                        end = mid - 1;
                    } else if (!isBadVersion(mid)) {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isBadVersion(int version) {
        if (ver.contains(version))
            return true;
        return false;
    }


    public int search(int[] nums, int target) {
        return serchNum(nums, target, 0, nums.length - 1);
    }

    private int serchNum(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        System.out.println("start: " + start + "end: " + end + "mid: " + mid);
      /*  if (start == end) {
            if (nums[start] == target)
                return start;
            else
                return -1;
        }*/
        if (start > end)
            return -1;
        if (mid < 0)
            return -1;
        if (target == nums[mid])
            return mid;
        if (target < nums[mid])
            return serchNum(nums, target, start, mid - 1);
        else if (target > nums[mid])
            return serchNum(nums, target, mid + 1, end);
        return -1;
    }

}
