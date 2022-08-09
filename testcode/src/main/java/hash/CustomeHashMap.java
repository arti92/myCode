package hash;


import java.util.Arrays;

/**
 * @author Arti.Jadhav
 */
public class CustomeHashMap<K, V> {

    int capacity = 16; //initailze capacity of table
    Entry<K, V> table[] = new Entry[capacity]; //array of hash table (which contain LL)

    int length = 1; //as for index 0 it is occupied

    public CustomeHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    public CustomeHashMap() {
    }

    public void put(K key, V value) {

        if (length >= capacity * 0.75) {
            // rehash();
        }
        int index = getIndex(key); //will genrate hash and return index
        Entry<K, V> entry = new Entry<>(key, value, null);//new node hence null
        //for null it will be at 0th index
        //as in 1st index also there can be ll
     /*   if (index == 0) {
            table[0] = entry;  //new value always be overried for null key
        }*/
        //already data present at that node
        if (table[index] != null) {
            if (table[index].key.equals(key)) { //if keys are same then override value else add in next node
                table[index].value = value;
            } else {
                Entry<K, V> temp = table[index];
                while (temp.next != null) {
                    temp = temp.next;
                    if (temp.key.equals(key)) { //in node if key present then also override
                        temp.value = value;
                        break;
                    }
                }
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
        Entry<K, V>[] temp = table;
        this.table = new Entry[capacity];
        length = 1;
        //rehash all values
        for (Entry<K, V> t : temp) {
            if (t != null) {
                //1st level checked also checked ll
                Entry<K, V> temp2 = t;
                while (temp2 != null) {
                    put(temp2.key, temp2.value);
                    temp2 = temp2.next;
                }
            }
        }

    }

    public V get(K key) {
        V value = null;
        Integer index = getIndex(key); //get the inde by calculating same hash of the key

        if (table[index] == null)
            return null;

        //bt if there is ll in that node
        if (table[index].next != null) { //there is next node
            Entry<K, V> temp = table[index];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = temp.value;
                    break;
                } //check if node key is match then return that value
                temp = temp.next;
            }
        } else if (table[index].key.equals(key)) {
            value = table[index].value;/// from index get val
        }
        return value;
    }

    public void remove(K key) {
        Integer index = getIndex(key);

        if (get(key) != null) { //value is present
            //value is present in ll
            if (table[index].next != null) {
                Entry<K, V> temp = table[index];
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

    //hash the key and return index
    //hash code is implemented by each custome class so the unique hashing can perform
    private int getIndex(K key) {
        if (key == null)
            return 0;
        else
            return Math.abs(key.hashCode() % capacity) == 0 ? 1 : Math.abs(key.hashCode() % capacity);

        // return capacity-1;
    }

    @Override
    public String toString() {
        printList();
        System.out.println();
        return "MyHashMap{" +
                "capacity=" + capacity +

                ", length=" + length +
                '}';
    }

    public void printList() {
        int i = 0;
        for (Entry<K, V> en : table) {
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

    //represetnt node of linked list
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

}



