package array;

/**
 * @author Arti.Jadhav
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("main:: ");
        //Given a binary array, find the maximum number of consecutive 1s in this array.
        int array[] = new int[7725];
        for(int i=0;i<10;i++){
            array[i]=1;
        }
      //  IntroArray.consecutiveNum(array);

        //Given an array nums of integers, return how many of them contain an even number of digits.
       // int[] nums = {12,345,2,6,7896};
      //  IntroArray.getEvenDigit(nums);

        //Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
        int[] nums = {-4,-1,0,3,10};
        IntroArray.sortedArray(nums);

    }
}
