/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.dataabs.creative;

import edu.princeton.cs.algs4.In;

public class StaticIntReader {
    public static int[] readAllInts(String fname) {
        In in = new In(fname);
        String[] strings = in.readString().split("\\s+");
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    public static void main(String[] args) {

    }
}
