package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class QuickSort {

    /**
     * O(nlogn)
     *
     * @param args
     */
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        System.out.println("quick sort");
        //int[] arr = {5, 2, 3, 6, 1};
        // qs.quickSort(arr); // infinte as left and right arr size in unkonwn

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(1);
        // qs.quickSortList(list);

        int[] arr = {3, 6, 10, 12, 13, 24, 70, 90};
        //int[] arr = {5, 2, 3, 6, 1};
        qs.quickSortUsingPart(arr, 0, arr.length - 1); // infinte as left and right arr size in unkonwn


    }

    private void quickSortUsingPart(int[] arr, int leftIndex, int rightIndex) {

        if (arr == null || arr.length == 0) {
            return;
        }
        if (leftIndex >= rightIndex)
            return;


        //when pivot started from last index ...it took more to sort hence took middle one
        int middle = leftIndex + (rightIndex - leftIndex) / 2;
        int pivot = arr[middle];

        int i = leftIndex, j = rightIndex;

        //till i and j not overlap each other
        while (i <= j) {
            //start from left for comapring
            while (arr[i] < pivot && i <= rightIndex) {
                i++;
            }
            //start from right for comapring
            while (arr[j] > pivot && j >= leftIndex) {
                j--;
            }
            //when condision doesn meet swap them
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //for new pivot
        if (leftIndex < j) {
            quickSortUsingPart(arr, leftIndex, j);
        }
        //for new pivot
        if (rightIndex > i)
            quickSortUsingPart(arr, i, rightIndex);
        System.out.println("sorted array:: " + Arrays.toString(arr));
    }

    private void quickSortList(List<Integer> list) {

        if (list.size() <= 1)
            return;

        int pivot = list.get(0);

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int j = 0, k = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < pivot) {
                leftList.add(list.get(i));
            } else {
                rightList.add(list.get(i));
            }
        }

        quickSortList(leftList);
        quickSortList(rightList);
        int l = 0, r = 0, i = 0;
        //merge
        while (l < leftList.size())
            list.set(i++, leftList.get(l++));

        list.set(i++, pivot);

        while (r < rightList.size())
            list.set(i++, rightList.get(r++));
/*
we can not use new list other wise second last elements not getted sorted out
if we use existing list then second last array will get as a sorted array
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(leftList);
        sortedList.add(pivot);
        sortedList.addAll(rightList);*/

        System.out.println(list + "sorted list:: ");
    }

    // can not use becoz arr are not dynamically created so loop will never end as we dont no the size of
    // array and all 0 gets compared repetatily in infinite loop
    private void quickSort(int[] arr) {
        if (arr.length <= 1)
            return;

        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        int pivot = arr[0];
        int j = 0, k = 0;
        //compare and divide
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivot) {
                leftArr[j++] = arr[i];
            } else {
                rightArr[k++] = arr[i];
            }
        }//for

        System.out.println("left array:: " + Arrays.toString(leftArr));
        quickSort(leftArr);
        System.out.println("right array:: " + Arrays.toString(rightArr));
        quickSort(rightArr);

        //merge
        int a = 0;
        for (int l = 0; l < leftArr.length; l++) {
            arr[a++] = leftArr[l];
        }
        arr[a++] = pivot;
        for (int r = 0; r < leftArr.length; r++) {
            arr[a++] = rightArr[r];
        }
        System.out.println("merged array:: " + Arrays.toString(arr));
    }
}
