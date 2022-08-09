package hash;

/**
 * @author Arti.Jadhav
 */
public class MyHashSet {
    /**
     * Initialize your data structure here.
     */

    int capacity = 16;
    int length = 1;
    Entry[] table;

    public MyHashSet() {
        table = new Entry[capacity];
    }

    public void add(int key) {
        if (length >= capacity * 0.75) {
            //  printList();
            rehash();
            // System.out.println("after");
            //printList();
        }
        int index = getIndex(key);
        Entry newEntry = new Entry(key, null);
        if (table[index] != null) {
            Entry temp = table[index];
            while (temp.next != null) {
                if (temp.key == key)
                    break;
                temp = temp.next;
            }
            if (temp.key != key)
                temp.next = newEntry;
        } else {
            table[index] = newEntry;  //for null index new key will added
            length++;
        }


    }

    private int getIndex(Integer key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void remove(int key) {

        int index = getIndex(key);
        if (table[index] != null) {
            if (table[index].next == null) {
                if (table[index].key == key)
                    table[index] = null;
                length--;
            }//for single entry
            else {
                Entry temp = table[index];
                while (temp.next != null) {
                    if (temp.key == key) {
                        table[index] = temp.next;
                        break;
                    }
                    if (temp.next.key == key) {
                        temp.next = temp.next.next;
                        break;
                    }
                    temp = temp.next;
                }
            }//for multiple nodes
        }

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {

        int index = getIndex(key);
        Entry temp = table[index];
        while (temp != null) {
            if (temp.key == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    private void rehash() {
        //rehash all other values
        System.out.println("rehash...");
        //increse the capacity
        capacity = capacity * 2;
        Entry[] temp = table;
        this.table = new Entry[capacity];
        length = 1;
        //rehash all values
        for (Entry t : temp) {
            if (t != null) {
                //1st level checked also checked ll
                Entry temp2 = t;
                while (temp2 != null) {
                    add(temp2.key);
                    temp2 = temp2.next;
                }
            }
        }

    }

    //represetnt node of linked list
    static class Entry {
        Integer key;
        Entry next;

        public Entry(Integer key, Entry next) {
            this.key = key;
            this.next = next;
        }

    }

    public void printList() {
        int i = 0;
        for (Entry en : table) {
            System.out.print("[" + i + "]" + "{");
            while (en != null) {
                System.out.print(en.key);
                en = en.next;
                System.out.print(" ;");
            }
            System.out.print("}");
            i++;
        }
    }
}

