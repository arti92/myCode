package collection;

import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class PriorityQEx {

    /*
    Input: nums = [1,2,3,3,4,4,5,6], k = 4
    Output: true
    Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

    Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
     */
    //slinding window
    public boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer n : nums)
            pq.add(n);

        while (pq.size() != 0) {
            int small = pq.peek();
            for (int i = 0; i < k; i++) {
                if (!pq.contains(small + i))
                    return false;
                else {
                    pq.remove(small + i);
                }


            }
        }
        return true;
    }

    public boolean isPossibleDivideOld(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        if (nums.length % k != 0)
            return false;

        if (k == 1 && nums.length == k)
            return true;

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]); //will add in sorted order
        }
        LinkedList<Integer> tempList = new LinkedList<>();
        PriorityQueue<Integer> pqTemp = new PriorityQueue<>(k);
        int numOfSets = 0;

        // for(int i=0;i< pq.size();i++){
        while (pq.size() != 0) {
            if (pqTemp.isEmpty())
                pqTemp.add(pq.remove()); //for 1st element
            if (pqTemp.size() == k) {
                System.out.println("set: " + pqTemp);
                if (!(pqTemp.peek() + 1 == pqTemp.toArray(new Integer[k])[1]))
                    return false;
                numOfSets++;
                pqTemp = new PriorityQueue<>(k);   //reassign as one set is completed
                if (!tempList.isEmpty()) {
                    //  for (Integer l : tempList) {
                    int l = tempList.size() - 1;
                    while (l >= 0 && !pq.contains(tempList.get(l))) {
                        pq.add(tempList.get(l));
                        tempList.remove(l);
                        l--;
                    }
                    //}
                }
            }
            if (pqTemp.contains(pq.peek()))
                tempList.push(pq.remove());
            else if (pq.size() != 0)
                pqTemp.add(pq.remove());
        }

        System.out.println("sets: " + pqTemp);
        /* if (pqTemp.size() == k && numOfSets>=0)*/
        if (pqTemp.size() == k && numOfSets >= 0 && (pqTemp.peek() + 1 == pqTemp.toArray(new Integer[k])[1]))
            return true;

        return false;
    }

    /*
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
     */
    /*
        complaxity is nlogk
     */
    public int findKthLargest(int[] nums, int k) {

        if (k > nums.length)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int j = k; j < nums.length; j++) {
            if (pq.peek() < nums[j]) {
                pq.poll();
                pq.add(nums[j]);
            }
        }
        System.out.println("pq:: " + pq);
        return pq.peek();
    }

    public boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : hand) pq.add(num);
        while (!pq.isEmpty()) {
            int smallest = pq.peek();
            for (int i = 0; i < W; i++) {
                if (!pq.contains(smallest + i)) return false;
                else pq.remove(smallest + i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("pq example");
        PriorityQEx pq = new PriorityQEx();
        // int[] nums = {34,80,89,15,38,69,19,17,97,98,26,77,8,31,79,70,103,3,13,21,81,53,33,14,60,68,33,59,84,23,97,90,76,82,66,83,23,22,16,18,98,25,16,61,84,100,4,68,101,25,23,9,10,55,2,67,39,52,102,99,40,11,83,24,81,53,96,23,13,24,99,67,22,51,31,58,78,88,5,15,24,32,81,91,96,16,54,22,56,69,14,82,32,34,83,24,37,82,54,21};
        // System.out.println(pq.isPossibleDivide(nums, 4));

        // int[] nums = {82, 83, 84, 88,81, 82, 83, 84,81, 89, 90, 91};
        int[] nums = {5, 6, 7, 8, 9, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 12, 13, 14, 15, 19};
        System.out.println(pq.isPossibleDivideOld(nums, 5));
        System.out.println("new code");
        System.out.println(pq.isPossibleDivide(nums, 5));
        System.out.println("other code");
        System.out.println(pq.isNStraightHand(nums, 5));

       /* int[] nums = {3, 2, 1, 4, 6, 5};
        System.out.println(pq.findKthLargest(nums, 2));*/

    }

}

