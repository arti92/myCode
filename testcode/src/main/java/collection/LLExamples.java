package collection;

import java.math.BigInteger;

/**
 * @author Arti.Jadhav
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LLExamples {


    public ListNode rotateRightOld(ListNode head, int k) {

        ListNode temp = head;
        if (head != null) {
            for (int i = k; k > 0; k--) {
                while (temp.next != null) {
                    if (temp.next != null && temp.next.next == null) {
                        ListNode newNode = temp.next; //take last node in new
                        temp.next = null; //make 2nd last as null

                        ListNode temp2 = head; // 1st take all data from head
                        newNode.next = temp2; // den assign that data to new node
                        head = newNode; // den declare newnode as head

                        break;
                    }

                    temp = temp.next;
                }
                temp = head;
            }
        }

        return temp;
    }


    public ListNode rotateRightTried(ListNode head, int k) {

        ListNode temp = head;

        int count = 0;
        int length = 2;


        if (head != null) {
          /*  ListNode chekNode = head;
            while (chekNode.next != null) {
                chekNode = chekNode.next;
                length++;
            }
            while (k > length) {
                k = k - length;
            }*/

            for (int i = k; k > 0; k--) {
                //to check length
               /* if (count == 1) {
                   // k = k + 1;
                    while (k > length) {
                        k = k - length;
                    }
                    if (k+1 >= length)
                        break;
                    System.out.println("k:: "+k);
                }*/
                while (temp.next != null) {
                    if (temp.next != null && temp.next.next == null) {
                        while (k > length) {
                            k = k - length;
                        }
                        if (k >= length)
                            break;
                        ListNode newNode = temp.next; //take last node in new
                        temp.next = null; //make 2nd last as null

                        ListNode temp2 = head; // 1st take all data from head
                        newNode.next = temp2; // den assign that data to new node
                        head = newNode; // den declare newnode as head

                        break;
                    }

                    temp = temp.next;
                    length++;
                }
                temp = head;
                count++;

            }
        }
        System.out.println("length:: " + length);
        System.out.println("count:: " + count);
        return temp;
    }


    public ListNode rotateRight(ListNode head, int k) {

        ListNode temp = head;

        int count = 0;
        int length = 1;


        if (head != null) {
            ListNode chekNode = head;
            while (chekNode.next != null) {
                chekNode = chekNode.next;
                length++;
            }
            while (k > length) {
                k = k - length;
            }
            System.out.println("length:: " + length);
            System.out.println("count:: " + k);
            for (int i = k; k > 0; k--) {
                while (temp.next != null) {
                    if (temp.next != null && temp.next.next == null) {

                        ListNode newNode = temp.next; //take last node in new
                        temp.next = null; //make 2nd last as null

                        ListNode temp2 = head; // 1st take all data from head
                        newNode.next = temp2; // den assign that data to new node
                        head = newNode; // den declare newnode as head
                        break;
                    }
                    temp = temp.next;

                }
                temp = head;
            }
        }
        return temp;
    }


    public ListNode swapPairsols(ListNode head) {
        ListNode temp = head;
        int length = 0;
        if (head != null) {
            ListNode prev = null;
            while (temp.next != null) {

                ListNode newNode = temp.next;
                temp.next = temp.next.next;
                newNode.next = temp;
                if (prev != null) {
                    prev.next = newNode;

                }
                temp = temp.next;

            }
        }


        return temp;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode out = head.next;

        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.next == null) {
                prev.next = temp;
                return out;
            }
            ListNode next = temp.next.next;

            ListNode one = temp;
            ListNode two = temp.next;
            two.next = one;
            if (prev != null) {
                prev.next = two;

            }
            prev = one;

            temp = next;
        }
        prev.next = null;
        return out;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        String l1Str = "";
        String l2Str = "";

        while (temp1 != null || temp2 != null) {
            if (temp1 != null) {
                l1Str += temp1.val + "";
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                l2Str += temp2.val + "";
                temp2 = temp2.next;
            }
        }
        l1Str = reverseStr(l1Str);
        l2Str = reverseStr(l2Str);
        BigInteger reallyBig1 = new BigInteger(l1Str);
        BigInteger reallyBig2 = new BigInteger(l2Str);
        String addision = reallyBig1.add(reallyBig2) + "";
        char[] ncr = addision.toCharArray();
        ListNode newNode = new ListNode(Integer.parseInt(ncr[0] + ""));
        for (int i = 1; i < ncr.length; i++) {
            String val = ncr[i] + "";
            newNode = addNode(val, newNode);
        }

        return newNode;
    }

    private ListNode addNode(String addision, ListNode newNode) {

        Integer val = Integer.parseInt(addision);
        ListNode head = new ListNode(val);
        head.next = newNode;
        return head;
    }

    private String reverseStr(String str) {
        String app = "";
        char[] ch = str.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            app += ch[i];
        }
        return app;

    }
}


