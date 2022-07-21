package edu.leetcode.tasks.easy;

/**
 * 2022-05-16
 */
public class OneBitNumber {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        OneBitNumber n = new OneBitNumber();
        System.out.println(n.hammingWeight(1));
        System.out.println(n.hammingWeight(-1));
        System.out.println(n.hammingWeight(2));
        System.out.println(n.hammingWeight(3));
        System.out.println(n.hammingWeight(-3));
        System.out.println(n.hammingWeight(11));
        System.out.println(n.hammingWeight(15));
        System.out.println(n.hammingWeight(16));
    }
}
