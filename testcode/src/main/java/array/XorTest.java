package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class XorTest {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_a = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i_a = 0; i_a < arr_a.length; i_a++) {
            a[i_a] = Integer.parseInt(arr_a[i_a]);
        }
        int q = Integer.parseInt(br.readLine().trim());

        int[] x = new int[q];
        int[] k = new int[q];
        for (int i = 0; i < q; i++) {
            String[] x_k = br.readLine().split(" ");
            x[i] = Integer.parseInt(x_k[0]);
            k[i] = Integer.parseInt(x_k[1]);
        }
        int[] out_ = FindKthMax(a, q, x, k);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
            System.out.println(out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static int[] FindKthMax(int[] a, int q, int[] x, int[] k) {

        int[] opArray = new int[q];
        for (int i = 0; i < q; i++) {
            Integer[] op = new Integer[a.length];
            for (int j = 0; j < a.length; j++) {
                int nn = x[i] ^ a[j];
                op[j] = nn;
            }

            Arrays.sort(op, Collections.reverseOrder());
            opArray[i] = op[k[i] - 1];
        }

        return opArray;
    }
}