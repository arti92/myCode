package array;

/**
 * @author Arti.Jadhav
 */
public class SearchArray {
    /*
    Input: arr = [7,1,14,11]
    Output: true
    Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
     */
    public boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int doub = arr[i] * 2;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == doub && i != j)
                    return true;
            }

        }
        return false;
    }

    /*
    Example 1:

        Input: [2,1]
        Output: false
        Example 2:

        Input: [3,5,5]
        Output: false
        Example 3:

        Input: [0,3,2,1]
        Output: true
     */
    public boolean validMountainArray(int[] nums) {

        if (nums.length <= 1)
            return false;

        for (int i = 0; i < nums.length / 2; i++) {
            int firstDiff = nums[i + 1] - nums[i];
            System.out.println(firstDiff);
            if (firstDiff < 0 && i + 1 < nums.length / 2)
                return false;
        }

        for (int i = nums.length; i > nums.length / 2; i--) {
            int diff = nums[i - 2] - nums[i - 1];
            System.out.println(diff);
            if (diff < 0 && i - 1 < nums.length / 2)
                return false;
        }

        return true;
    }
}
