package collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Arti.Jadhav
 */
public class App {
    public static void main(String[] args) {
        System.out.println("main");

        /*
         *deque:: A linear collection that supports element insertion and removal at
         * both ends.  The name <i>deque</i> is short for "double ended queue"
         * and is usually pronounced "deck".
         *
         * this interface defines methods to access the elements at both
         * ends of the deque.
         *
         * This interface extends the {@link Queue} interface.  When a deque is
         * used as a queue, FIFO (First-In-First-Out) behavior results.  Elements are
         * added at the end of the deque and removed from the beginning.  The methods
         * inherited from the {@code Queue} interface are precisely equivalent to
         * {@code Deque} methods
         *
         *
         * <p>Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
         * interface should be used in preference to the legacy {@link Stack} class.
         * When a deque is used as a stack, elements are pushed and popped from the
         * beginning of the deque.  Stack methods are precisely equivalent to
         * {@code Deque} methods
         *
         * deque can be achived by arraydeque or linkedlist(circuler)
         * arraydeque faster then ll
         *
         * prefer arraydeque insted of stack, as stack extends vector hence stack is slower n legacy class
         */


        ArrayDeque<Integer> ad = new ArrayDeque<>();
        //can be used as queue or stack

        //as a queue
        ad.add(1);
        ad.add(2);
        ad.add(3);
        ad.remove();
        System.out.println("as a queue::  " + ad);
        //in squeue data goes as 1 2 3 alsi in deque data goes as 1 2 3
        //in remove 1st element removed

        ad.push(11);
        ad.push(12);
        ad.push(13);
        ad.pop();
        System.out.println("as a stack::  " + ad);
        //in stack data goes as 1 2 3 bt in deque data goes as 3 2 1 while push
        //as data goes in reverse so pop actully removed 1st bt it seems like filo
        //so that poll an remove cam behave same

        LinkedList<Integer> llAsStack = new LinkedList<>();
        llAsStack.push(1);
        llAsStack.push(2);
        llAsStack.push(3);
        llAsStack.poll();
        System.out.println("llstack: " + llAsStack);


        System.out.println("pr qu");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(2);
        System.out.println("pq:: " + pq);
        // System.out.println(pq.poll());
        // System.out.println(pq.remove());
        // System.out.println(pq.poll());
        // System.out.println(pq.remove());
        System.out.println(pq.peek());


    }
}
