package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
public class DeleteArray {

    /*  Given nums = [3,2,2,3], val = 3,

      Your function should return length = 2, will remove 3 from array n will return remaining array length.*/
    //will return any arrau
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int le = length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                length--;
                le = length;
                if (nums[length] != val) {
                    nums[i] = nums[length];
                    // index++;
                }

                while (le > 0 && index >= 0 && le > index && nums[le - index] == val) {
                    le--;
                    nums[i] = nums[le - index];
                    index++;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("len" + length);
        return length;
    }
      /*  Given nums = [3,2,2,3], val = 3,

      Your function should return length = 2, will remove 3 from array n will return remaining array length.*/

    public int removeElementsh(int[] nums, int val) {
        int counter = 0;
        String output = "";
        for (int value : nums) {
            if (value != val) {
                output += "#" + value;
                counter++;
            }
        }
        for (int i = 0; i < counter; i++) {
            nums[i] = Integer.parseInt(output.split("#")[i + 1]);
        }
        return counter;
    }

    public int removeElements(int[] nums, int val) {
        int counter = nums.length;
        int temp = 0;
        int i = 0;

        while (i < nums.length) {

            if (nums[i] == val) {
                //numList.remove(i);
                counter--;
                temp = nums[i];
                nums[i] = nums[counter];
                nums[counter] = temp;

            }
            if (nums[i] != val)
                i++;
        }

        for (int k = 0; k < counter; k++) {
            System.out.println(nums[k]);
        }

        return counter;
    }


    public int removeElementColl(int[] nums, int val) {
        int length = nums.length;
        int temp = 0;
        int le = length;
        Integer[] numArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> numList = new ArrayList<>(Arrays.asList(numArray));
        int i = 0;
        while (i < numList.size()) {
            if (numList.get(i) == val) {
                numList.remove(i);
            }
            if (i < numList.size() && numList.get(i) != val)
                i++;
        }
        for (int j = 0; j < numList.size(); j++) {
            nums[j] = numList.get(j);
        }
        return numList.size();
    }


    private static void calculateLengthCollection(int[] array, int input) {

        List<Integer> collect = Arrays.stream(array)
                .mapToObj(Integer::valueOf).collect(Collectors.toList());

        collect.removeIf(d -> d.equals(new Integer(input)));

        for (int i = 0; i < collect.size(); i++) {
            array[i] = collect.get(i);
        }

    }

    //remove duplicate elemets from sorted array

    /**
     * Given nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
     * <p>
     * It doesn't matter what values are set beyond the returned length.
     *
     * @param nums
     */
    public int removeDuplicates(int[] nums) {
        int place = 0;
        if (nums.length > 0) {
            int tempVal = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (tempVal < nums[i]) {
                    tempVal = nums[i];
                    place++;
                    nums[place] = tempVal;
                }

            }
            place = place + 1;
        }


        return place;
    }
}
