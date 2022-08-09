package hash;

/**
 * @author Arti.Jadhav
 */
public class MyHashMap {

    int capacity = 16; //initailze capacity of table
    Entry table[]; //array of hash table (which contain LL)

    int length = 1; //as for index 0 it is occupied

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.table = new Entry[capacity]; //array of hash table (which contain LL)
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {


        if (length >= capacity * 0.75) {
            //  printList();
            rehash();
            // System.out.println("after");
            //printList();
        }
        int index = getIndex(key); //will genrate hash and return index
        Entry entry = new Entry(key, value, null);//new node hence null
        //for null it will be at 0th index
       /* if (index == 0) {
            table[0] = entry;  //new value always be overried for null key
        }*/
        //already data present at that node
        //else
        if (table[index] != null) {
            if (table[index].key.equals(key)) { //if keys are same then override value else add in next node
                table[index].value = value;
            } else {
                Entry temp = table[index];
                while (temp.next != null) {
                    temp = temp.next;
                    if (temp.key.equals(key)) { //in node if key present then also override
                        temp.value = value;
                        break;
                    }
                }
                if (!temp.key.equals(key))
                    temp.next = entry; //add new entry at the end of existing node
            }
        } else {
            table[index] = entry; // data add at that node
            length++;
        }
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
                    put(temp2.key, temp2.value);
                    temp2 = temp2.next;
                }
            }
        }

    }

    //hash the key and return index
    //hash code is implemented by each custome class so the unique hashing can perform
    private int getIndex(Integer key) {
        if (key == 0)
            return 0;
        else
            // return Math.abs(key.hashCode() % capacity) == 0 ? 1 : Math.abs(key.hashCode() % capacity);
            return Math.abs(key.hashCode() % capacity);

        // return capacity-1;
    }

    public void printList() {
        int i = 0;
        for (Entry en : table) {
            System.out.print("[" + i + "]" + "{");
            while (en != null) {
                System.out.print(en.key + "=" + en.value);
                en = en.next;
                System.out.print(" ;");
            }
            System.out.print("}");
            i++;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {

        Integer value = -1;
        Integer index = getIndex(key); //get the inde by calculating same hash of the key

        if (table[index] == null)
            return -1;

        //bt if there is ll in that node
        if (table[index].next != null) { //there is next node
            Entry temp = table[index];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = temp.value;
                    break;
                } //check if node key is match then return that value
                temp = temp.next;
            }
        } else {
            if (table[index].key.equals(key)) {
                value = table[index].value;/// from index get val
            }
        }
        return value;

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Integer index = getIndex(key);
        if (get(key) != -1) { //value is present
            //value is present in ll
            if (table[index].next != null) {
                Entry temp = table[index];
                while (temp.next != null) {
                    if (temp.key == key) {
                        table[index] = temp.next;
                        break;
                    } else if (temp.next.key == key) {
                        temp.next = temp.next.next;
                        break;
                    }
                    temp = temp.next;
                }
            } else {
                table[index] = null;
            }
            length--;
        }
    }

    //represetnt node of linked list
    static class Entry {
        Integer key;
        Integer value;
        Entry next;

        public Entry(Integer key, Integer value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }
}
