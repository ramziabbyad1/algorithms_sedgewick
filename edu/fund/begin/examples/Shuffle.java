/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.fund.begin.examples;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {
    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int t = a[i];
            int j = i + StdRandom.uniform(n - i);
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void main(String[] args) {

    }
}
