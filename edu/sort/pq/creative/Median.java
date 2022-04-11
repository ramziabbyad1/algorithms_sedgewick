package edu.sort.pq.creative;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Scanner;

public class Median {
    private Double median;
    private MaxPQ<Integer> maxPQ;
    private MinPQ<Integer> minPQ;
    private int n;

    public Median() {
        n = 0;
        minPQ = new MinPQ<>();
        maxPQ = new MaxPQ<>();
        Scanner sc = new Scanner(System.in);

        //int i = sc.nextInt();
        In in = new In(sc);
        while (in.hasNextLine()) {
            int i = in.readInt();
            insert(i);
            System.out.println("Current median: " + findMedian());
        }

    }

    /*
     * If median is not set, add median to maxheap
     * if median is set add element to appropriate heap and recompute the median
     * if heaps are unbalanced choose unbalanced, otherwise choose average
     * */
    public void insert(int i) {
        if (median == null) {
            median = (double) i;
            minPQ.insert(i);
        }
        else if (i < median) {
            maxPQ.insert(i);
        }
        else {
            minPQ.insert(i);
        }

        if (n % 2 == 0) {
            median = minPQ.size() > maxPQ.size() ? minPQ.delMin().doubleValue() : maxPQ.delMax()
                                                                                       .doubleValue();

        }
        else {
            if (minPQ.size() > maxPQ.size()) {
                maxPQ.insert(median.intValue());
            }
            else {
                minPQ.insert(median.intValue());
            }
            median = (minPQ.min() + maxPQ.max()) / 2.0;
        }

        n++;
    }


    public Double findMedian() {
        return median;
    }

    public static void main(String[] args) {
        Median med = new Median();

    }
}
