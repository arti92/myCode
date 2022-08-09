package collection;

/**
 * @author Arti.Jadhav
 */
class LinkedNode {

    Integer data;
    LinkedNode next;

    public LinkedNode(Integer data) {
        this.data = data;
        next = null;
    }

}

public class MyLinkedList {
    /**
     * Input
     * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
     * [[], [1], [3], [1, 2], [1], [1], [1]]
     * Output
     * [null, null, null, null, 2, null, 3]
     * <p>
     * Explanation
     * MyLinkedList myLinkedList = new MyLinkedList();
     * myLinkedList.addAtHead(1);
     * myLinkedList.addAtTail(3);
     * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
     * myLinkedList.get(1);              // return 2
     * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
     * myLinkedList.get(1);              // return 3
     */

    LinkedNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int count = 0;
        LinkedNode temp = head;
        while (temp != null) {
            if (index == count)
                return temp.data;
            else
                count++;
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {

        LinkedNode newNode = new LinkedNode(val);
        if (head == null)
            head = newNode;
        else {
            LinkedNode temp = head;
            newNode.next = temp;
            head = newNode;
        }

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        LinkedNode newNode = new LinkedNode(val);
        if (head == null)
            head = newNode;
        else {
            LinkedNode temp = head;
            while (temp.next != null) {
                temp = temp.next; //will get tail element
            }
            temp.next = newNode;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int count = 1;
        LinkedNode newNode = new LinkedNode(val);
        LinkedNode temp = head;
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
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        int count = 0;
        LinkedNode temp = head;
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
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */