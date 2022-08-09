package algo;

/**
 * @author Arti.Jadhav
 */
public class HeapSort {

    public void insertArray(int[] a) {

        for (int i : a) {
            insertIntoArray(a, i);
        }
    }


    public void insertIntoArray(int[] arr, int a) {

        int[] heap = new int[arr.length + 1];

        heap[0] = a;
        for (int j : arr) {

        }
        if (heap[0] > a)
            heap[1] = a;

    }

    public int deleteFromArray() {

        return -1;
    }

    public int getArray() {

        return -1;
    }
}
