package array;

/**
 * @author Arti.Jadhav
 */
public class InplaceArray {

    /*
    Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]
     */
    public int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                //move all elemnts
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = -1;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }

        return arr;
    }

    /*
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
     */

    public void moveZeroes(int[] nums) {
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }

        }

        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }

    }

    /*
    Input: [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     */

    public int[] sortArrayByParity(int[] nums) {

        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
                        temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }

        }

        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }

        return nums;
    }

    /*
    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

    Input: [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
     */
    public void sortedSquares(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }
}
