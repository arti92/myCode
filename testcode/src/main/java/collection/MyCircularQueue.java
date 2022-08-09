package collection;

/**
 * @author Arti.Jadhav
 */
class MyCircularQueue {

    public static class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
            next = null;
        }
    }

    int index = 0;
    int k = 0;
    Node head, rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.k = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        Node newNode = new Node(value);
        if (isFull())
            return false;
        if (head == null)
            head = rear = newNode;
        else {
            rear.next = newNode;
            rear = newNode;
        }
        index++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        Node temp = head;
        if (isEmpty())
            return false;
        if (head.next == null)
            head = rear = null;
        else {
            head = temp.next;
            temp.next = null;
        }
        index--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        return rear.data;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if (index == k)
            return true;
        return false;
    }
}