/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.fund.bagquestack.exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MySteque<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) last = first;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public static void main(String[] args) {
        MySteque<String> s = new MySteque<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!s.isEmpty() && item.equals("-")) StdOut.print(s.pop() + " ");
            else if (item.charAt(0) == 'q') s.enqueue(item);
            else s.push(item);
        }
        StdOut.println("(" + s.size() + " left on steque)");
    }
}
