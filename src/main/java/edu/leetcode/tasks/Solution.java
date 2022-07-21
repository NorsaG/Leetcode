package edu.leetcode.tasks;

class Solution {
    public double myPow(double x, int n) {
        double result = innerPow(x, n);
        return n < 0 ? 1 / result : result;
    }

    private double innerPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = innerPow(x, n / 2);
        result *= result;
        result *= n % 2 == 0 ? 1 : x;

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(12, -3));
    }
}
