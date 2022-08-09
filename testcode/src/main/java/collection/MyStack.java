package collection;

/**
 * @author Arti.Jadhav
 */
public class MyStack<E> {

    private CustomeLinkedList<E> custLinkList = new CustomeLinkedList<>();

    public void push(E data) {
        custLinkList.add(data);
    }

    public E pop() throws Exception {
        return custLinkList.removeLast();
    }

    public E peek() throws Exception {
        return custLinkList.getLast();
    }

    public void print() {
        custLinkList.printList();
    }

    public Boolean isEmpty() {
        return custLinkList.isEmpty();
    }
}
