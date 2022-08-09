package collection;

/**
 * @author Arti.Jadhav
 */


public class MyQueue<E> {

    Node<E> head;
    Node<E> rear;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
            /*
            Node<E> temp = rear;
            temp.next = newNode;
            rear = newNode;*/
        }

    }

    /*
    remove 1st element fron queue so give header n mv header to next
     */
    public E poll() throws Exception {
        E data = null;
        if (isEmpty())
            return null;
        if (head.next == null) {
            data = head.data;
            rear = head = null;

        } else {
            Node<E> temp = head;
            head = temp.next;
            data = temp.data;
        }
        return data;
    }

    /*
    return top element , return null if list is empty
     */
    public E peek() {

        if (head == null)
            return null;
        else
            return head.data;

    }

    /*
    return top element , throw exception if list is empty
     */
    public E element() throws Exception {

        if (head == null)
            throw new Exception("empty list");
        else
            return head.data;
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }
}
