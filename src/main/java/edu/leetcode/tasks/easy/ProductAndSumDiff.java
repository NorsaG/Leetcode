package edu.leetcode.tasks.easy;

/**
 * 2022-05-16
 */
public class ProductAndSumDiff {

    public int subtractProductAndSum(int n) {

        int product = -1;
        int sum = 0;

        while (n > 0) {
            int number = n % 10;
            n = n / 10;

            if (product == -1)
                product = number;
            else
                product = product * number;

            sum += number;
        }


        return product - sum;
    }
}
