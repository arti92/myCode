package array;

import java.util.Arrays;

/**
 * @author Arti.Jadhav
 */
public class InsertArray {

    /*Input: [1,0,2,3,0,4,5,0]
    Output: null
    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]*/

    //half working - array size not increased
    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i++;
            }
        }

        //print array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /* Input:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     Output: [1,2,2,3,5,6]*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m, j = 0; i < nums1.length; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);

        //print array
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    /**
     * In java Array size never increased dynamically,so need to create new array
     */
    public void insertIntoArray(int[] arr, int target, int position) {
        int[] newArray = new int[arr.length + 1]; //created new array with extra length for target
        System.out.println("main array : " + Arrays.toString(arr));
        System.out.println("new array : " + Arrays.toString(newArray));
        //inserting at back
        //copy all element of previous array to new array
        if (position == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            newArray[arr.length] = target; //placing target at the end of array
            System.out.println("at last: " + Arrays.toString(newArray));
        } else if (position == 0) {
            //inserting at start
            newArray[0] = target;
            for (int i = 0; i < arr.length; i++) {
                newArray[i + 1] = arr[i];
            }
            System.out.println("at first: " + Arrays.toString(newArray));
        } else {

            //this much part is enough for all position but only for head n tail upper code present
            for (int i = 0; i < position; i++) {
                newArray[i] = arr[i];
            }
            newArray[position] = target;

            //complicated logic
           /* for (int i = position+1; i <= arr.length; i++) {
                newArray[i] = arr[i-1];
            }*/
            //simple soln
            for (int i = position; i < arr.length; i++) {
                newArray[i + 1] = arr[i];
            }
            System.out.println("at position: " + Arrays.toString(newArray));
        }


    }
}
