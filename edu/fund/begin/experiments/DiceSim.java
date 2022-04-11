/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.fund.begin.experiments;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class DiceSim {
    private final double[] probabilities;
    private static final int SIDES = 6;

    DiceSim() {

        int[] frequencies = new int[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++)
                frequencies[i + j]++;
        }

        double[] probabilities = new double[2 * SIDES + 1];
        for (int k = 2; k <= 2 * SIDES; k++)
            probabilities[k] = frequencies[k] / 36.0;

        this.probabilities = probabilities;
    }

    public double[] simulateThrows(int n) {
        double[] probabilities = new double[2 * SIDES + 1];
        for (int i = 0; i < n; i++)
            probabilities[2 + StdRandom.uniform(SIDES) + StdRandom.uniform(SIDES)]++;
        for (int k = 2; k <= 2 * SIDES; k++)
            probabilities[k] /= n;

        return probabilities;
    }

    /*
     * Experimental evidence seems to suggest that n >= 500,000 is sufficient
     * */
    public static void main(String[] args) {
        DiceSim sim = new DiceSim();
        System.out.println(Arrays.toString(sim.probabilities));
        System.out.println(Arrays.toString(sim.simulateThrows(1000000)));
        System.out.println(checkAccuracy(sim.probabilities, sim.simulateThrows(1000000)));
       /* DiceSim sim = new DiceSim();
        int n = 36;
        while (checkAccuracy(sim.probabilities, sim.simulateThrows(n)) >= .001)
            n++;
        System.out.println("3 decimals of accuracy for n: " + n);*/
    }

    private static double checkAccuracy(double[] probabilities, double[] simulateThrows) {
        double MAX_ERROR = -1;
        for (int k = 0; k < probabilities.length; k++)
            MAX_ERROR = Math.max(MAX_ERROR, Math.abs(probabilities[k] - simulateThrows[k]));

        return MAX_ERROR;
    }
}
