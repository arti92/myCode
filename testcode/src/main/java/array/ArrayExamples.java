package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class ArrayExamples {
    /*
    Input:
    [4,3,2,7,8,2,3,1]

    Output:
    [5,6]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> output = new ArrayList<>();
        if (nums.length == 0)
            return output;

        for (int i = 1; i <= nums.length; i++) {
            output.add(i);
        }
        int length = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (output.contains(nums[i])) {
                output.remove(output.indexOf(nums[i]));
                //output.remove()
            }

        }
        System.out.println(output.toString());
        return output;
    }

    public List<Integer> findDisappearedNumber(int[] nums) {

        List<Integer> output = new ArrayList<>();
        if (nums.length == 0)
            return output;

        /*for(int i=1;i<= nums.length;i++){
            output.add(i);
        }*/
        int length = nums.length;
        int count = 0;
        boolean isPresent = false;

        for (int i = 0; i < nums.length; i++) {
            /*if(output.contains(nums[i])){
                output.remove(output.indexOf(nums[i]));
                //output.remove()
            }*/
            isPresent = false;
            count = 0;
            for (int j = 0; j <= nums.length; j++) {

                if (j == nums[i]) {
                    isPresent = true;
                    count = j;
                    break;
                }
                count = j;
            }
            if (!isPresent)
                System.out.println(count + " cnt" + i);
        }
        System.out.println(output.toString());
        return output;
    }

    public int searchInsert(int[] nums, int target) {
        int index = nums.length;
        if (nums[0] > target)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            if (nums[i] > target && nums[i - 1] < target)
                index = i;
        }

        return index;
    }

    public int[] twoSumOld(int[] nums, int target) {
        int size = 1;
        int[] output = new int[nums.length];
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            size = 1;
            output = new int[nums.length];
            l = 0;
            output[l] = i;
            int k = l + 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                System.out.println(nums[i] + " :i##j: " + nums[j] + " sum:: " + sum);
                size++;
                output[k] = j;
                if (sum == target) {
                    System.out.println("j:: " + output);
                    System.out.println("size:: " + size);
                    int[] lastoutput = new int[size];
                    for (int z = 0; z < size; z++) {
                        System.out.println("zzzz:: " + output[z]);
                        lastoutput[z] = output[z];
                    }
                    return lastoutput;
                }

                k++;
                System.out.println("j:: " + j);
            }
            System.out.println("i:: " + i);
            l++;
        }

        System.out.println("size::" + size);


        return output;
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            Integer diff = (Integer) (target - nums[i]);
            if (hash.containsKey(diff)) {
                int toReturn[] = {hash.get(diff), i};
                return toReturn;
            }

            hash.put(nums[i], i);

        }

        return null;
    }
}
