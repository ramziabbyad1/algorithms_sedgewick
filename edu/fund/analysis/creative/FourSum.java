/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.fund.analysis.creative;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FourSum {
    public static int count(int[] a) {
        //int[] a = { 2, 1, -5, 3, 8, -4, -1, 8, -9, -10, -15 };
        Arrays.sort(a);
        int[] sum2 = new int[a.length * (a.length + 1) / 2];
        int k = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                sum2[k++] = a[i] + a[j];

        //search for each sum in remainder of array
        int count = 0;
        for (int i = 0; i < sum2.length; i++)
            if (BinarySearch.indexOf(sum2, -sum2[i]) > i)
                count++;

        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        
        StdOut.println(count(a));
    }
}
