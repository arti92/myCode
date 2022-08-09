package hash;

import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class App {

    public static void main(String[] args) {
        System.out.println("main....");
       /* HashSet<Integer> set = new HashSet<>();

        set.add(1);*/

       /*HashMap<Integer,String> map = new HashMap<>();
        map.put(null,"a");
        map.put(null,"b");
        System.out.println("map:: "+map);*/

        // customeHashMap();
        // myHashMap(myHashMap);
        //makeSqr();

        myHashSet();


    }

    private static void myHashSet() {
        MyHashSet set = new MyHashSet();
        String[] ioArray = {"MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"};

        int[][] inArray = {{}, {1}, {2}, {1}, {3}, {2}, {2}, {2}, {2}};

        List<Boolean> opArray = new ArrayList<>();
        opArray.add(null);

        Boolean[] expectedArray = {null, null, null, true, false, null, true, null, false};

        for (int i = 1; i < ioArray.length; i++) {
            if (ioArray[i].equalsIgnoreCase("add")) {
                opArray.add(null);
                set.add(inArray[i][0]);
            } else if (ioArray[i].equalsIgnoreCase("remove")) {
                // System.out.println(inArray[i][0]);
                opArray.add(null);
                set.remove(inArray[i][0]);
            } else if (ioArray[i].equalsIgnoreCase("contains")) {
                // System.out.println(inArray[i][0]);
                opArray.add(set.contains(inArray[i][0]));
            }
        }

        System.out.println(opArray);
        System.out.println(Arrays.asList(expectedArray));

        System.out.println(Arrays.asList(expectedArray).containsAll(opArray) + " ::pre:: " + opArray.containsAll(Arrays.asList(expectedArray)));

        set.printList();
    }

    private static void customeHashMap() {
        CustomeHashMap<Integer, String> customeHashMap = new CustomeHashMap<>();
        customeHashMap.put(null, "a");
        customeHashMap.put(2, "b");
        customeHashMap.put(3, "c");
        customeHashMap.put(2, "e");

        customeHashMap.put(23, "2c");
        customeHashMap.put(22, "2e");
        customeHashMap.put(33, "3c");
        customeHashMap.put(32, "3e");

        System.out.println("MyHashMap:: " + customeHashMap.toString());
        System.out.println("get:: " + customeHashMap.get(2));
        // customeHashMap.remove(3);
        //   customeHashMap.remove(22);
        customeHashMap.remove(33);
        System.out.println("get:: " + customeHashMap.get(33));
        System.out.println("last:: " + customeHashMap);
    }

    private static void myHashMap() {
        MyHashMap myHashMap = new MyHashMap();

        String[] ioArray = {"MyHashMap", "put", "put", "put", "put", "remove", "put", "put", "put", "put", "remove", "put", "put", "put", "put", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "remove", "put", "put", "get", "put", "put", "get", "get", "get", "put", "get", "get", "put", "remove", "put", "get", "get", "remove", "put", "put", "put", "get", "put", "get", "put", "put", "put", "get", "put", "remove", "put", "get", "get", "remove", "put", "put", "remove", "get", "put", "put", "put", "put", "put", "get", "put", "get", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "get", "put", "put", "put", "put", "put", "get", "remove"};

        int[][] inArray = {{}, {54, 35}, {36, 39}, {63, 9}, {72, 28}, {78}, {84, 88}, {56, 42}, {69, 55}, {4, 47}, {56}, {24, 46}, {5, 18}, {35, 94}, {10, 4}, {50, 67}, {77, 16}, {75, 48}, {7, 80}, {65}, {61, 5}, {52, 32}, {68, 84}, {54, 18}, {44, 41}, {17, 60}, {43, 30}, {30, 49}, {56}, {54}, {20, 52}, {4, 0}, {56}, {98, 51}, {66, 73}, {23}, {72}, {83}, {83, 41}, {13}, {44}, {91, 93}, {33}, {16, 53}, {5}, {77}, {78}, {80, 40}, {1, 92}, {93, 35}, {16}, {86, 60}, {80}, {94, 91}, {69, 23}, {4, 72}, {5}, {53, 15}, {50}, {82, 14}, {69}, {35}, {84}, {82, 44}, {38, 64}, {4}, {46}, {20, 16}, {9, 66}, {15, 64}, {71, 88}, {82, 11}, {46}, {37, 29}, {27}, {80, 78}, {40, 96}, {21, 60}, {22}, {12, 1}, {52, 84}, {44, 56}, {95, 62}, {16, 67}, {71, 13}, {93, 17}, {19, 0}, {61, 13}, {14, 73}, {29, 46}, {13, 61}, {2, 12}, {75}, {60}, {96, 79}, {45, 88}, {67, 92}, {86, 75}, {21, 66}, {91}, {67}};

        List<Integer> opArray = new ArrayList<>();
        opArray.add(null);

        Integer[] expectedArray = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, null, null, null, null, null, null, null, null, null, null, null, null, -1, null, null, -1, 28, -1, null, -1, 41, null, null, null, 18, 16, null, null, null, null, 53, null, 40, null, null, null, 18, null, null, null, 23, 94, null, null, null, null, -1, null, null, null, null, null, -1, null, -1, null, null, null, -1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, null, null, null, null, null, 93, null};

        for (int i = 1; i < ioArray.length; i++) {
            if (ioArray[i].equalsIgnoreCase("get")) {
                System.out.println("get..");
                opArray.add(myHashMap.get(inArray[i][0]));
            } else if (ioArray[i].equalsIgnoreCase("put")) {
                opArray.add(null);
                myHashMap.put(inArray[i][0], inArray[i][1]);
            } else if (ioArray[i].equalsIgnoreCase("remove")) {
                // System.out.println(inArray[i][0]);
                opArray.add(null);
                myHashMap.remove(inArray[i][0]);
            }
        }

        System.out.println(opArray);
        System.out.println(Arrays.asList(expectedArray));

        System.out.println(Arrays.asList(expectedArray).containsAll(opArray) + " ::pre:: " + opArray.containsAll(Arrays.asList(expectedArray)));

        myHashMap.printList();
    }

    private static void makeSqr() {
        HashsetExmaple hse = new HashsetExmaple();
        int[] num = {1, 1, 2, 2, 2};
        System.out.println(hse.makesquare(num));
    }
}
