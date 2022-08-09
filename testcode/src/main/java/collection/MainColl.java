package collection;

import java.util.LinkedList;

/**
 * @author Arti.Jadhav
 */
public class MainColl {

    public static void main(String[] args) throws Exception {
        /*
            LINKED LIST OPERATION
         */
        // customeList();
        // mylinkList();
        //  rotateList();
        //swapNum(); // not solved
        //  addNumb();

     /* LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.remove();
        System.out.println(ll.element());
        System.out.println("ll:  "+ll);*/

        /*
            STACK OPERATION
         */
        // System.out.println("stack");
      /* Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);//last element which out 1st
       // st.pop();
        //st.pop();
        st.pop();
        System.out.println(st.isEmpty());
        System.out.println("stack:: "+st);*/


        //CUSTOME STACK
        //checkStack();
        // isValid();


         /*
            Queue OPERATION for singular queue
         */
        System.out.println("queue");
      /*  Queue<Integer> q = new LinkedList<>();
        q.add(1);
       // q.add(2);
       // q.add(3);
        q.poll();
        for(Integer q1: q){
            System.out.println(q1);
        }
        System.out.println("peek:: "+q.peek());
        System.out.println("ele:: "+q.element());*/

      /*  MyQueue<Integer> qu = new MyQueue<>();
        qu.add(1);
       qu.add(2);
        //qu.add(3);
       // qu.add(4);
        qu.print();
        //System.out.println( qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        qu.print();*/

        //using singular queue
        //  myCircularQueue();

        mycircularQueue();

    }

    private static void mycircularQueue() {
        MyCircularDeque doubleLl = new MyCircularDeque(8);
        System.out.println(doubleLl.insertFront(1));            // return true
        System.out.println(doubleLl.insertFront(2));
        System.out.println(doubleLl.insertFront(3));
        System.out.println(doubleLl.deleteFront());// return true
        System.out.println("print:: " + doubleLl);

        System.out.println(doubleLl.insertLast(11));            // return true
        System.out.println(doubleLl.insertLast(12));
        System.out.println(doubleLl.insertLast(13));    // return false, the queue is full
        System.out.println(doubleLl.getRear());            // return 2
        System.out.println(doubleLl.isFull());                // return true
        System.out.println(doubleLl.deleteLast());            // return true
        System.out.println(doubleLl.insertFront(4));            // return true
        System.out.println(doubleLl.getFront());            // return 4

        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        //ll.add()
    }

    private static void myCircularQueue() {
        MyCircularDeQueueUsingSingle circularQueue = new MyCircularDeQueueUsingSingle(3);
        //"MycircularQueue","insertFront","getFront","insertLast","deleteLast"
      /*  System.out.println( circularQueue.insertLast(1));			// return true
        System.out.println( circularQueue.insertLast(2));			// return true
        System.out.println( circularQueue.insertFront(3));			// return true
        System.out.println(circularQueue.insertFront(4));			// return false, the queue is full
        System.out.println( circularQueue.getRear());  			// return 2
        System.out.println( circularQueue.isFull());				// return true
        System.out.println( circularQueue.deleteLast());			// return true
        System.out.println( circularQueue.insertFront(4));			// return true
        System.out.println( circularQueue.getFront());			// return 4*/

        System.out.println(circularQueue.insertFront(1));            // return true
        System.out.println(circularQueue.getFront());            // return true
        System.out.println(circularQueue.insertLast(3));            // return true
        System.out.println(circularQueue.deleteLast());
        System.out.println(circularQueue.deleteLast());    // return false, the queue is full
        //  System.out.println( circularQueue.getRear());
        //["MycircularQueue","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
        //[[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
    }

    private static void isValid() throws Exception {
        StackExample se = new StackExample();
        System.out.println("isValid:: " + se.isValid("()"));
        System.out.println("count:: " + se.scoreOfParentheses("(()(()))"));//should return 6
//((()))
        //((((  ))))
    }

    private static void checkStack() throws Exception {
        MyStack<Integer> st = new MyStack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println("removed element:: " + st.pop());
        System.out.println("last element:: " + st.peek());
        st.print();

    }

    private static void addNumb() {

        LLExamples ll = new LLExamples();

        ListNode ln = new ListNode(9);
        //  ListNode ln2 = new ListNode(4,ln);
        //   ListNode ln3 = new ListNode(2,ln2);

        ListNode l2n0 = new ListNode(1);
        ListNode l2n = new ListNode(9, l2n0);
        ListNode l2n2 = new ListNode(9, l2n);

        /*
        [9]
[1,9,9,9,9,9,9,9,9,9]
         */

        ListNode op = ll.addTwoNumbers(ln, l2n2);

        while (op != null) {
            System.out.print(op.val + " ");
            op = op.next;
        }
    }

    private static void swapNum() {

        LLExamples ll = new LLExamples();
        ListNode ln = new ListNode(5);
        ListNode ln2 = new ListNode(4, ln);
        ListNode ln3 = new ListNode(3, ln2);
        ListNode ln4 = new ListNode(2, ln3);
        ListNode ln5 = new ListNode(1, ln4);
        ListNode check = ln5;

        while (check != null) {
            System.out.print(check.val + " ");
            check = check.next;
        }

        ListNode op = ll.swapPairs(ln5);

        while (op != null) {
            System.out.print(op.val + " ");
            op = op.next;
        }
    }

    private static void rotateList() {
        LLExamples ll = new LLExamples();
        ListNode ln = new ListNode(2);
        ListNode ln2 = new ListNode(1, ln);
        ListNode ln3 = new ListNode(3, ln2);
        ListNode ln4 = new ListNode(2, ln3);
        ListNode ln5 = new ListNode(0, ln4);
        ListNode check = ln5;
        while (check != null) {
            System.out.print(check.val + " ");
            check = check.next;
        }

        System.out.println("after rotate");

        ListNode op = ll.rotateRight(ln5, 10);


        while (op != null) {
            System.out.print(op.val + " ");
            op = op.next;
        }

    }

    private static void mylinkList() {
        MyLinkedList myLinkedList = new MyLinkedList();

         /* ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
*/

        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(4);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
/*
        myLinkedList.addAtHead"
        myLinkedList.addAtHead"
        myLinkedList.addAtHead"
        myLinkedList.addAtHead"
        myLinkedList.addAtTail"
        myLinkedList.get"
        myLinkedList.deleteAtIndex"
        myLinkedList.deleteAtIndex"]*/

        //  System.out.println(myLinkedList.get(1));// return 3*/
    }

    private static void customeList() {
        CustomeLinkedList<Integer> cll = new CustomeLinkedList<>();
        // LinkedList<Integer> li = new LinkedList<>();
        //li.add(3);
        cll.add(1);
        cll.add(2);
        //  cll.addAtTail(6);//in linkedlist data is always added at tail
        cll.add(3);

        cll.printList();
        // System.out.println("val at index:: "+cll.get(6));
        // cll.addAtHead(10);
       /* cll.addAtIndex(0,25);
        cll.printList();
        cll.deleteAtIndex(0);
        cll.printList();*/
    }
}
