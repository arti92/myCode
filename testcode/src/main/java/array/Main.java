package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("main:: ");
        //intro();

        insert();
        // merge();

        //delete
        // removeElement();
        // removeDuplicateElement();

        //serach
        //  checkIfExist();
        //validMountainArray();

        //Inplace Array
        //replaceElements();
        //moveZeroes();
        //sortArrayByParity();
        //sortedSquares();

        //array example
        //  findDisappearedNumbers();
        //  serchInsert();

        //twoSum();

    }

    private static void twoSum() {
        ArrayExamples ae = new ArrayExamples();
        int[] nums = {1, 1, 2, 3, 4};
        int target = 9;
        int[] op = ae.twoSum(nums, target);
        System.out.println("op:");
        for (int i = 0; i < op.length; i++) {

            System.out.print(op[i]);
        }
    }

    private static void serchInsert() {
        ArrayExamples ae = new ArrayExamples();
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println("index:: " + ae.searchInsert(nums, target));
    }

    private static void findDisappearedNumbers() {

        ArrayExamples ex = new ArrayExamples();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = ex.findDisappearedNumbers(nums);

        System.out.println("list:: " + list);
    }

    private static void sortedSquares() {
        InplaceArray ia = new InplaceArray();
        int[] nums = {-4, -1, 0, 3, 10};
        ia.sortedSquares(nums);
    }

    private static void sortArrayByParity() {
        InplaceArray ia = new InplaceArray();
        int[] nums = {3, 1, 2, 4};
        ia.sortArrayByParity(nums);
    }

    private static void moveZeroes() {
        InplaceArray ia = new InplaceArray();
        int[] nums = {0, 0, 0, 0, 1};
        ia.moveZeroes(nums);
    }

    private static void replaceElements() {
        InplaceArray ia = new InplaceArray();
        int[] nums = {17, 18, 5, 4, 6, 1};
        ia.replaceElements(nums);//not working
    }

    private static void validMountainArray() {
        SearchArray sa = new SearchArray();
        int[] nums = {2, 1};
        System.out.println(sa.validMountainArray(nums));//not working code
    }

    private static void checkIfExist() {
        SearchArray sa = new SearchArray();
        int[] nums = {0, 0};
        System.out.println(sa.checkIfExist(nums));
    }

    private static void removeDuplicateElement() {
        DeleteArray da = new DeleteArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int place = da.removeDuplicates(nums);//will return 4
        for (int i = 0; i < place; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void removeElement() {
        DeleteArray da = new DeleteArray();
        int[] nums1 = {3, 2, 2, 3};
        int m = 2;
        da.removeElementColl(nums1, m);//will return 4
    }

    private static void merge() {
        InsertArray iarr = new InsertArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        iarr.merge(nums1, m, nums2, n);
    }

    private static void insert() {
        InsertArray iarr = new InsertArray();
        int[] nums = {2, 0, 3, 4, 0, 5, 0, 6, 7};
        // iarr.duplicateZeros(nums);
        iarr.insertIntoArray(nums, 22, 4);

    }

    private static void intro() {
        //Given a binary array, find the maximum number of consecutive 1s in this array.
        int array[] = new int[7725];
        for (int i = 0; i < 10; i++) {
            array[i] = 1;
        }
        //  IntroArray.consecutiveNum(array);

        //Given an array nums of integers, return how many of them contain an even number of digits.
        // int[] nums = {12,345,2,6,7896};
        //  IntroArray.getEvenDigit(nums);

        //Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
        int[] nums = {-4, -1, 0, 3, 10};
        IntroArray.sortedArray(nums);
    }
}
