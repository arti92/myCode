package collection;

/**
 * @author Arti.Jadhav
 */
public class MyCircularDeque {

    public static class Node {
        Integer data;
        Node next;
        Node prev;

        public Node(Integer data) {
            this.data = data;
            prev = next = null;
        }
    }

    int size = 0;
    int index = 0;

    Node head, tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        Node newNode = new Node(value);
        if (isFull())
            return false;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            /*
            newNode.next=head;
            head = newNode;*/
        }
        index++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        Node newNode = new Node(value);
        if (isFull())
            return false;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        index++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        Node temp = head;
        if (head.next == null)
            head = tail = null;
        else {
            head = temp.next;
            head.prev = null;
        }
        index--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        Node temp = tail;
        if (head.next == null)
            head = tail = null;
        else {
            tail = temp.prev;
            tail.next = null;
        }
        if (tail == null)
            head = null;
        index--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty())
            return -1;
        return tail.data;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if (index == size)
            return true;
        return false;
    }
}
