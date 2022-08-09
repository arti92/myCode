package collection;

/**
 * @author Arti.Jadhav
 */
class DeNode {
    Integer data;
    DeNode next;

    public DeNode(Integer data) {
        this.data = data;
        next = null;
    }
}

public class MyCircularDeQueueUsingSingle {

    int size = 0;
    int index = 0;

    DeNode head, rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeQueueUsingSingle(int k) {
        this.size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        DeNode newNode = new DeNode(value);
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        } else {
            if (head == null) {
                head = rear = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            index++;
        }
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        DeNode newNode = new DeNode(value);
        if (isFull())
            return false;
        if (head == null)
            head = rear = newNode;
        else {
            rear.next = newNode;
            rear = rear.next;
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
        else {
            if (head.next == null)
                head = rear = null;
            else {
                DeNode nextNode = head;
                head = nextNode.next;
            }
            index--;
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        if (head.next == null)
            head = rear = null;
        else {
            DeNode reNode = rear;
            DeNode temp = head;
            while (temp.next != rear) {
                temp = temp.next;
            } //wll reach till 2nd last
            rear = temp;  //assign 2nd last to rear so last node will collect by garbage collector
            rear.next = null;
        }
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
        return rear.data;
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
