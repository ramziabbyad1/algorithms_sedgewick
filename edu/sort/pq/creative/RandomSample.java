/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package edu.sort.pq.creative;

import java.util.Arrays;

public class RandomSample {
    private double T;
    /*class Node {

            Node(int data) {
                this.data = data;
            }
        }*/
    private double[] pq;
    private int n;

    //accepts discrete probabilities p
    public RandomSample(double[] p) {
        n = p.length;
        pq = new double[n + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = p[i];


        for (int i = n / 2; i >= 1; i--) {
            pq[i] += 2 * i <= n ? pq[2 * i] : 0;
            pq[i] += 2 * i + 1 <= n ? pq[2 * i + 1] : 0;
        }

        System.out.println("p: " + Arrays.toString(p));
        System.out.println("pq: " + Arrays.toString(pq));

        this.T = pq[1];
    }

    public int random(double t) {
        //double t = StdRandom.uniform() * T;
        int root = 1;
        double leftChild, rightChild, rootVal, leftBnd, rightBnd;
        leftChild = 2 * root <= n ? pq[2 * root] : 0;
        rightChild = 2 * root + 1 <= n ? pq[2 * root + 1] : 0;
        leftBnd = leftChild;
        rightBnd = pq[root] - rightChild;
        //rootVal =
        double EPS = 1.0 / (1 << 32);
        while (root <= n) {

            System.out.println("root: " + root);
            System.out.println("rightBnd: " + rightBnd);
            System.out.println("leftBnd: " + leftBnd);
            if (EPS < leftBnd - t) {//traverse left
                root = 2 * root;
                leftChild = 2 * root <= n ? pq[2 * root] : 0;
                rightChild = 2 * root + 1 <= n ? pq[2 * root + 1] : 0;
                rootVal = pq[root] - leftChild - rightChild;
                rightBnd = leftBnd - rightChild;
                leftBnd = rightBnd - rootVal;

            }
            else if (t - rightBnd >= -EPS) {
                root = 2 * root + 1;
                leftChild = 2 * root <= n ? pq[2 * root] : 0;
                rightChild = 2 * root + 1 <= n ? pq[2 * root + 1] : 0;
                rootVal = pq[root] - leftChild - rightChild;
                leftBnd = rightBnd + leftChild;
                rightBnd = leftBnd + rootVal;

            }
            else {
                break;

            }


        }
        return root;
    }

    public void changeKey(int i, double key) {
        int root = i;
        double leftChild = 2 * root <= n ? pq[2 * root] : 0;
        double rightChild = 2 * root + 1 <= n ? pq[2 * root + 1] : 0;
        double oldRootVal = pq[root] - leftChild - rightChild;
        //double rootVal = key + leftChild + rightChild;
        //pq[root] = key + leftChild + rightChild;
        for (root = i; root >= 1; root /= 2)
            pq[root] -= (oldRootVal - key);
        //System.out.println("p: " + Arrays.toString(p));
        System.out.println("pq: " + Arrays.toString(pq));
    }

    public static void main(String[] args) {
        //In in = new In(new Scanner(System.in));
        double[] p = { 3.5, 2.0, 5.3, .7, .3, 1.9 };
        //System.out.println("p: " + Arrays.toString(p));
        RandomSample rs = new RandomSample(p);
        //System.out.println(rs.random(6.5));
        //System.out.println(rs.random(3));
        System.out.println(rs.random(.7));
        System.out.println(rs.random(2.7));
        rs.changeKey(5, .6);
        //System.out.println(rs.random(.8));
        //System.out.println(rs.random(1));
        //System.out.println(rs.random(2.8));
        //System.out.println(rs.random(3.8));
        //System.out.println(rs.random(4.8));
        //System.out.println(rs.random(5.9));
        //System.out.println(rs.random(6.7));
        //System.out.println(rs.random(7.1));
        //System.out.println(rs.random(8.2));
        //System.out.println(rs.random(9));
        //System.out.println(rs.random(10));
        //System.out.println(rs.random(11));
        //System.out.println(rs.random(12));
        //System.out.println(rs.random(13));
    }
}
