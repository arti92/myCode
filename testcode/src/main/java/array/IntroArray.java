package array;

import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class IntroArray {


    //Given a binary array, find the maximum number of consecutive 1s in this array.
    static int consecutiveNum(int[] nums) {
        int counter = 1;
        int prevCounter = nums[0];
        for(int i=0; i<(nums.length-1); i++){
            if(nums[i]==1 && nums[i+1]==1){
                counter++;
                //  System.out.println(counter+ "cnt: "+i);
            }
            if(nums[i]==0 || i==nums.length-2){
                if(prevCounter < counter && counter > 1)
                    prevCounter = counter;
                counter=1;
            }
        }
        if(prevCounter==0 && nums[nums.length-1]==1)
            prevCounter=1;
        System.out.println("consecutive numbers:: "+prevCounter);
        return prevCounter;
    }

    public static int getEvenDigit(int[] array) {
        int count = 0;
        int counter = 0;

        for(int i=0; i<array.length; i++){
            count = 0;
            while (array[i]!=0){
                array[i]/=10;
                count++;
            }
            if(count%2==0)
                counter++;

        }
        return counter;
    }

    public static int[] sortedArray(int[] nums) {
        int[] squered = new int[nums.length];
        int[] sorted = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            squered[i] = nums[i]*nums[i]; //squerd
        }

       //write soreted code
        int temp;
        for(int j=0;j<squered.length;j++){
            for(int k=j+1;k<squered.length;k++){
                if(squered[j]>squered[k]){
                    temp = squered[j];
                    squered[j]=squered[k];
                    squered[k]=temp;
                }
            }
        }
        return squered;
    }
}
