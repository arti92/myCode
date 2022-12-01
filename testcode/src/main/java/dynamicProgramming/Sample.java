package dynamicProgramming;

/**
 * @author Arti.Jadhav
 */
//Fibonacci Series
public class Sample {

    /**
     * FAST Approch to solve DP prob
     * F - find recursion solution
     * A - Analysis the solution(lok for overlapping prob)
     * S - Save the result for future (till here it is Memoization approch)
     * T - tweak the solution by elimination recursion overhead (Bottom up approach)
     */

    public static void main(String[] args) {
        System.out.println("main");
        // Given Number N
        int N = 5;
        // Print the first N numbers
        for (int i = 0; i < N; i++) {
            //System.out.print(fibonnaciRecusrion(i) + " ");
            // System.out.print(fibDynamicProgMem(i) + " ");
            System.out.print(fibDynamicProg(i) + " ");
        }
    }

    //Bottom up/Tabulation
    //Time complexity - O(n)
    //Space complexity - O(n)
    private static int fibDynamicProg(int n) {
        int[] cache = new int[n + 2]; //S
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2]; //F //A
        }
        return cache[n]; //T
    }

    //Memoization
    //Time complexity - O(n)
    //Space complexity - O(n)
    private static int fibDynamicProgMem(int n) {
        int[] cache = new int[n + 2];
        if (n < 2)
            return n;
        //memorized in cache
        if (cache[n] > 0) //check in cache , if present then return that , else go and calculate for that number
            return cache[n];
        return cache[n] = fibDynamicProgMem(n - 1) + fibDynamicProgMem(n - 2);
    }

    //Time complexity - O(2^n)
    private static int fibonnaciRecusrion(int n) {
        if (n < 2)
            return n;
        return fibonnaciRecusrion(n - 1) + fibonnaciRecusrion(n - 2);
    }
}
