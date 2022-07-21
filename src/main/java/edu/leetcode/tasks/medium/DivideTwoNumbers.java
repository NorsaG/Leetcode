package edu.leetcode.tasks.medium;

/**
 * 2022-04-29
 */
public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        long d1 = dividend;
        long d2 = divisor;

        if (d1 == 0)
            return 0;
        if (d2 == 1)
            return dividend;

        if (d1 == Integer.MAX_VALUE && d2 == -1)
            return Integer.MIN_VALUE;
        if (d1 == Integer.MIN_VALUE && d2 == -1)
            return Integer.MAX_VALUE;


        if (d2 == -1) {
            return (int)(-1 * d1);
        }

        boolean isPositive = (dividend > 0) ? (divisor > 0) : (divisor < 0);

        long tmp = Math.abs(d1);
        long tmpDivisor = Math.abs(d2);
        if (tmp < tmpDivisor) {
            return 0;
        }

        int result = 0;
        while (tmp >= tmpDivisor) {
            tmp = tmp - tmpDivisor;
            result++;
        }
        return isPositive ? result :  -1 * result;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoNumbers().divide(Integer.MIN_VALUE, 2));
    }
}
