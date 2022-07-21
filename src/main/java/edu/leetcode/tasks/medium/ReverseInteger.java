package edu.leetcode.tasks.medium;


public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE)
            return 0;

        boolean isPositive = x >= 0;
        if (!isPositive)
            x = x * -1;

        if (x < 10)
            return returnNumber(x, isPositive);

        int tmp = x;
        long reverse = 0;
        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            if ( reverse > Integer.MAX_VALUE)
                return 0;
            tmp = tmp / 10;
        }
        return returnNumber((int)reverse, isPositive);
    }

    private int returnNumber(int number, boolean isPositive) {
        return isPositive ? number : number * -1;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }
}
