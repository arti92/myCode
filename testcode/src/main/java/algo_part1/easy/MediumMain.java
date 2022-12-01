package algo_part1.easy;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Arti.Jadhav
 */
public class MediumMain {
    public static void main(String[] args) {
        System.out.println("medium");

      /*  MediumMain mm = new MediumMain();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        mm.rotate(nums, 3);
        */
    }

    public void rotate(int[] rotate, int count) {

        int[] nums = Arrays.copyOf(rotate, rotate.length);
        int l = 0;

        int k = count % nums.length;
        System.out.println("k: " + k);
        for (int i = nums.length - k; i < nums.length; i++) {
            rotate[l] = nums[i];
            l++;
        }
        System.out.println(Arrays.toString(rotate));
        for (int i = 0; i < nums.length - k; i++) {
            rotate[l] = nums[i];
            if (l <= nums.length)
                l++;
        }
        System.out.println(Arrays.toString(rotate));

    }

    public void rotateArr(int[] rotate, int count) {

        int rotation = count % rotate.length;

        for (int i = rotate.length - rotation; i < rotate.length; i++) {

            /*for(){

            }*/

        }

        System.out.println(Arrays.toString(rotate));

    }
}
