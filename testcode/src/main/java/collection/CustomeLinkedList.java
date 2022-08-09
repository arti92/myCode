package collection;

import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class CustomeLinkedList<E> {

    Node<E> head;

    public void add(E data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(E val) {
        Node<E> newNode = new Node<>(val);
        if (head == null)
            head = newNode;
        else {
            Node<E> temp = head;
            newNode.next = temp;
            head = newNode;
        }

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(E val) {
        Node<E> newNode = new Node<>(val);
        if (head == null)
            head = newNode;
        else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next; //will get tail element
            }
            System.out.println("tail: " + temp.data);
            temp.next = newNode;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int count = 1;
        Node<E> newNode = new Node(val);
        Node<E> temp = head;
        if (index == 0) {
            if (head != null)
                newNode.next = head.next;
            head = newNode;
        } else {
            while (temp != null) {

                if (count == index) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                } else
                    count++;

                temp = temp.next;
            }
        }
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public E get(int index) {
        int count = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (index == count)
                return temp.data;
            else
                count++;
            temp = temp.next;
        }
        return null;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int count = 0;
        Node<E> temp = head;
        if (index == 0 && head != null) {
            head = temp.next;
        } else {
            while (temp != null) {
                if (count == index - 1 && temp.next != null) {
                    temp.next = temp.next.next;
                    break;
                } else
                    count++;

                temp = temp.next;
            }
        }

    }

    public E removeLast() throws Exception {
        Node<E> lastNode;
        Node<E> temp = head;
        if (head == null)
            throw new Exception("Invalid Operation");
        if (head.next == null) {
            lastNode = head;
            head = null;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            lastNode = temp.next;
            temp.next = null;
        }
        return lastNode.data;
    }

    E getLast() throws Exception {
        Node<E> lastNode;
        Node<E> temp = head;
        if (head == null)
            throw new Exception("Invalid Operation");
        if (head.next == null) {
            lastNode = head;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            lastNode = temp;
        }
        return lastNode.data;
    }
}

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        next = null;
    }


}
