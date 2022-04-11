package edu.sort.pq.creative;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;

import java.util.Scanner;

public class MyIndexMinPQ<Key extends Comparable<Key>> {
    private int n;
    private int[] pq; // binary heap with 1 based index
    private int[] qp; // inverse: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // items with priorities

    public MyIndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] == -1;
    }

    public void insert(int i, Key key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public void changeKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public int minIndex() {
        return pq[1];
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public Key keyOf(int i) {
        return keys[i];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, n--);
        sink(1);
        keys[pq[n + 1]] = null;
        qp[pq[n + 1]] = -1;
        return indexOfMin;

    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j + 1, j)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {

        int t = pq[i];
        int q = qp[pq[i]];
        qp[pq[i]] = qp[pq[j]];
        qp[pq[j]] = q;
        pq[i] = pq[j];
        pq[j] = t;

    }

    public static void main(String[] args) {
        int nMax = 10;
        MyIndexMinPQ<Integer> pq = new MyIndexMinPQ<>(nMax);

        In in = new In(new Scanner(System.in));
        int i = 0;
        while (!in.isEmpty() && i < nMax) {
            pq.insert(i, in.readInt());
            System.out.println("index: " + i + " key " + pq.keyOf(i));
            System.out.println("minKey: " + pq.minKey());
            System.out.println("minIndex: " + pq.minIndex());
            System.out.println("Do you wish to change a key?");
            String yesOrNo = in.readString();
            if (yesOrNo.equals("Y")) {
                System.out.print("Enter index: ");
                int index = in.readInt();
                System.out.println("Current key of index: " + pq.keyOf(index));
                System.out.print("Enter new key: ");
                Integer k = in.readInt();
                pq.changeKey(index, k);
            }
            i++;
        }

        System.out.println("mins in sorted order");
        while (!pq.isEmpty()) {
            int minKey = pq.minKey();
            int minIndex = pq.delMin();
            System.out.println("index: " + minIndex);
            System.out.println("key: " + minKey);
        }

    }
}
