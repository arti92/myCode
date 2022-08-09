package algo;

/**
 * @author Arti.Jadhav
 */
public class BinarySearchRotatingArray {
    //for rotating array
    public int search(int[] nums, int target) {

        if (nums.length <= 0)
            return -1;

        int l = 0;
        int h = nums.length - 1;

        if (l == h && nums[l] == target)
            return l;

        if (nums[l] == target)
            return l;
        if (nums[h] == target)
            return h;
        return search(nums, l, h, target);
        /*int mid1 = (l + h) / 2;
        if (nums[mid1] == target)
            return mid1;

        //min elemnt present in left
        if (nums[mid1] < target) {
            l= mid1;
            int index = serchIndex(nums, l, h, target);
            if (index != -1)
                return index;
        }
        //min elemts present in right
        if (nums[mid1] > target) {
            h = mid1;
           return serchIndex(nums, l, h, target);
        }
*/


    }

    int serchIndex(int[] nums, int l, int h, int target) {
        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target)
                return mid;

            //target present in left
            if (target < nums[mid])
                h = mid - 1;
            else
                //target present at right
                l = mid + 1;

        }
        return -1;
    }

    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }
}
