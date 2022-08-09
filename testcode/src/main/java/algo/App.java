package algo;

import java.util.Arrays;

/**
 * @author Arti.Jadhav
 */
public class App {

    public static void main(String[] args) {
        System.out.println("algorithm main started");
        //  HeapSort hs = new HeapSort();
        // int[] arr = {5,2,3,1};
        // hs.insertArray(arr);

        //  algo();
        BinarySearchRotatingArray eb = new BinarySearchRotatingArray();
        rotateArray(eb);



    }

    private static void rotateArray(BinarySearchRotatingArray eb) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(eb.search(nums, target));
    }

    private static void algo() {
        int nums[] = {1, 2, 3, 4};
        int target = 5;
        // 0ms and 39.6 memory usage
        BinarySearch it = new BinarySearch();
        System.out.println(it.searchByItration(nums, target));
        System.out.println(Arrays.binarySearch(nums, 3));
        //0 ms and 39.9 memory usage
        //BinarySerchRecurse rec = new BinarySerchRecurse();
        //System.out.println(rec.search(nums,target));
    }
}
