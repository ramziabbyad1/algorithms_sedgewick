/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.dataabs.exercises;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class MinPointDist {
    private static class Point2DPair implements Comparable<Point2DPair> {
        Point2D p1, p2;
        double dist;

        Point2DPair(Point2D p1, Point2D p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = p1.distanceTo(p2);
        }

        public int compareTo(Point2DPair point2D) {
            if (this.dist > point2D.dist) return +1;
            if (this.dist < point2D.dist) return -1;
            return 0;
        }

        public String toString() {
            return String.valueOf(this.p1.distanceTo(this.p2));
        }
    }

    /* n = 5
     * i=0, j =4 => 3
     * i = 1, j=2 => 4
     * ...
     * i=n-2, j=n-1 = 3 + 3*4 - 3 = 12
     * */
    public static Point2DPair[] getPairs(Point2D[] a) {
        Point2DPair[] pairs = new Point2DPair[(a.length * (a.length - 1)) / 2];
        int offset = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                pairs[j - 1 + offset] = new Point2DPair(a[i], a[j]);
                //System.out.println(a[i].distanceTo(a[j]));
            }
            offset += a.length - (i + 2);
        }
        return pairs;
    }

    public static void printDistances(Point2D[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                System.out.println(a[i].distanceTo(a[j]));
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] randPoints = new Point2D[n];
        for (int i = 0; i < n; i++) {
            randPoints[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            //System.out.print(randPoints[i] + " ");
        }
        System.out.println();
        double minDist = Double.POSITIVE_INFINITY;

        printDistances(randPoints);
        Point2DPair[] pairs = getPairs(randPoints);
        Arrays.sort(pairs);
        System.out.println(Arrays.toString(pairs));
        System.out.println("minDist: " + pairs[0].dist);
    }
}
