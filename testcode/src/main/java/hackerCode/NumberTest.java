package hackerCode;

import java.util.Scanner;

/**
 * @author Arti.Jadhav
 */
public class NumberTest {
    public static void main(String args[]) throws Exception {

        //BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String name = br.readLine();                // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
       /* Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        Integer num1 = Integer.valueOf(name.split(" ")[0]);
        Integer num2 = Integer.valueOf(name.split(" ")[1]);        // Reading input from STDIN
        System.out.println("Hi, " + name );    // Writing output to STDOUT
*/
        Integer num1=15;
        Integer num2=10;
        // Write your code here
        //Integer count = NumberTest.getCommonFactCount(num1, num2);
        Integer count = NumberTest.commDiv(num1,num2);
        System.out.println("count, " + count);
    }

    private static Integer getCommonFactCount(Integer num1, Integer num2) {
        Integer count = 1;
        Integer smallNum;
        if (num1 < num2) {
            smallNum = num1;
        }else smallNum = num2;
        for (int i = 2; i <= smallNum; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                ++count;
            }
        }
        return count;

    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
    // method to calculate all common divisors
    // of two given numbers
    // a, b --> input integer numbers
    static int commDiv(int a, int b)
    {
        // find gcd of a, b
        int n = gcd(a, b);

        // Count divisors of n.
        int result = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            // if 'i' is factor of n
            if (n % i == 0) {
                // check if divisors are equal
                if (n / i == i)
                    result += 1;
                else
                    result += 2;
            }
        }
        return result;
    }
}
