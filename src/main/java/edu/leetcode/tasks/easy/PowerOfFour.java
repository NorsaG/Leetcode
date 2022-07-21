package edu.leetcode.tasks.easy;

/**
 * 2022-04-22
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 4 == 0) {
            return isPowerOfFour(n / 4);
        } else {
            return false;
        }
    }
}
