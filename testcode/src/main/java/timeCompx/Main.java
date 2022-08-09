package timeCompx;

import string.MediumEx;

/**
 * @author Arti.Jadhav
 */
public class Main {
    private static int n = 9;

    public static void main(String[] args) {
        System.out.println("main....");
        for (int i = 0; i < n; i++) {
            System.out.println("");
        }
        System.out.println("O(n) times");
        //also
        for (int i = 0; i < n; i += 2) {
            System.out.println("");
        }
        System.out.println("O(n) times");
/////////////////////////////////////////////////////////////////////

        //4 times for will execute
        int p = 1;

        for (int i = 1; p < n; i++) {
            p = p + i;
        }
        for (int i = 0; i * i < n; i++) {
            System.out.println(i);
        }
        System.out.println("o(sqrRootof(n))");

/////////////////////////////////////////////////////////////////////

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(j);
            }
        }
        //also same for
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(j);
            }
        }
        System.out.println("o(n^2)");

        /////////////////////////////////////////////////////////////////////
        for (int i = 0; i < n; i = i * 2) {
            System.out.println(i);
        }
        //also
        for (int i = 0; i < n; i = i / 2) {
            System.out.println(i);
        }


        System.out.println("o(log n base 2)");
    }
}
