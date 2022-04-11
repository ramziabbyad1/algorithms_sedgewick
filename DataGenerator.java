/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

public class DataGenerator {
    public static void writeInts(int n, String fname) {
        Out out = new Out(fname);
        int MAX = 1000000;
        for (int i = 0; i < n; i++)
            out.println(StdRandom.uniform(-MAX, MAX));
    }

    public static void main(String[] args) {
        String fname = args[0];
        int n = Integer.parseInt(args[1]);
        writeInts(n, fname);
    }
}
