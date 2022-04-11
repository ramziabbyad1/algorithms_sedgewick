/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.fund.analysis.expirements;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class AutoboxPerf {
    private static final int MAX_INT = 1000000;

    public static double timeTrial(int n) {
        FixedCapacityStack<Integer> boxStack = new FixedCapacityStack<>(n);
        //FixedCapacityStackOfInts boxStack = new FixedCapacityStackOfInts(n);
        Stopwatch timer = new Stopwatch();

        for (int i = 0; i < n; i++)
            boxStack.push(StdRandom.uniform(-MAX_INT, MAX_INT));

        while (!boxStack.isEmpty()) boxStack.pop();

        return timer.elapsedTime();
    }


    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f ", n, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
