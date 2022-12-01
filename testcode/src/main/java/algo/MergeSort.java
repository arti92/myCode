package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {1, 9, 6, 2, 7};
         mergeSort(array);

        //merge sort using list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(6);
        list.add(2);
        list.add(7);

       // mergeListSort(list);

    }

    private static List<Integer> mergeListSort(List<Integer> list) {
        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();
        System.out.println("original:: " + list);
        if (list.size() <= 1)
            return list;
        int mid = list.size() / 2;
        List<Integer> leftListT = list.subList(0, mid); // creating prob
        List<Integer> rightListT = list.subList(mid, list.size()); //creating prob
        for (int i = 0; i < mid; i++) {
            leftList.add(list.get(i));
        }
        //copy the right half of whole into the new arraylist.
        for (int i = mid; i < list.size(); i++) {
            rightList.add(list.get(i));
        }

        System.out.println(leftListT + " temp left:: " + leftList);
        System.out.println(rightListT + " temp right:: " + rightList);

        mergeListSort(leftList);
        mergeListSort(rightList);

        mergeList(leftList, rightList, list);
        return list;
    }

    private static void mergeList(List<Integer> leftList, List<Integer> rightList, List<Integer> list) {
        // List<Integer> list = new ArrayList<>();
        System.out.println(" ::during merger:: " + list);
        int l = 0, r = 0, i = 0;
        while (l < leftList.size() && r < rightList.size()) {
            if (leftList.get(l) < rightList.get(r)) {
                list.set(i++, leftList.get(l++));
            } else
                list.set(i++, rightList.get(r++));
        }

        while (l < leftList.size())
            list.set(i++, leftList.get(l++));
        while (r < rightList.size())
            list.set(i++, rightList.get(r++));

        System.out.println("sorted list:: " + list);
    }

    private static void mergeSort(int[] array) {

        System.out.println("Arrrraysss:: " + Arrays.toString(array));
        //as nothing to split
        if (array.length <= 1)
            return;
        //divide into two arrays
        int mid = array.length / 2;
        System.out.println("mid:: " + mid);
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        //add data in both arrays
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        System.out.println("left array:: " + Arrays.toString(left));
        int k = 0;
        for (int i = mid; i < array.length; i++) {
            right[k] = array[i];
            k++;
        }
        System.out.println("right array:: " + Arrays.toString(right));

        //recursivally divide
        mergeSort(left);
        mergeSort(right);
        //when there will be only one element present (for left side)
        // merge gets called and will sort left side (last two then last 3)
        //once left side done...right element again sorted and at the end full array gets sorted
        //and sort by comapring right and left
        System.out.println("before merger call");
        merge(left, right, array);
    }

    //compare and merge
    private static void merge(int[] left, int[] right, int[] array) {
        //as nothing to comapre
      /*  if (left.length <= 1)
            return;
        if (right.length <= 1)
            return;*/
        System.out.println("during merge:: " + Arrays.toString(array));
        int l = 0, r = 0, i = 0;
        //int[] sortedArray = new int[left]
        while (l < left.length && r < right.length) {
            //left contain smaller element
            if (left[l] < right[r]) {
                array[i++] = left[l++]; //add small in array and then increase the index
            } else {
                array[i++] = right[r++];
            }
        }

        //extra for remaining elements in array
        while (l < left.length)
            array[i++] = left[l++];
        while (r < right.length)
            array[i++] = right[r++];

        System.out.println("sorted arrays:: " + Arrays.toString(array));
    }
}
