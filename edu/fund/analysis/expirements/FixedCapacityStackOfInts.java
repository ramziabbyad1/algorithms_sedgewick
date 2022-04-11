/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.fund.analysis.expirements;

public class FixedCapacityStackOfInts {
    private int[] a;
    private int n;

    public FixedCapacityStackOfInts(int capacity) {
        a = new int[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(int item) {
        a[n++] = item;
    }

    public int pop() {
        return a[--n];
    }

    public boolean isFull() {
        return a.length == n;
    }

    public static void main(String[] args) {

    }
}
