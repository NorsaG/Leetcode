package edu.leetcode.tasks.easy;

import java.util.Arrays;

public class BigIntegerPlusOne {

    public int[] plusOne(int[] digits) {
        if (allNines(digits)) {
            int[] inc = new int[digits.length + 1];
            inc[0] = 1;
            for (int i = 1; i < inc.length ; i++) {
                inc[i] = 0;
            }
            return inc;
        } else {
            int pos = digits.length - 1;
            boolean moreThanNine;
            do {
                digits[pos] = digits[pos] + 1;
                if (digits[pos] > 9) {
                    digits[pos] = 0;
                    moreThanNine = true;
                } else {
                    moreThanNine = false;
                }
                pos--;
            }
            while (moreThanNine);

            return digits;
        }
    }

    private boolean allNines(int[] digits) {
        for (int digit : digits) {
            if (digit != 9) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BigIntegerPlusOne b = new BigIntegerPlusOne();
        System.out.println(Arrays.toString(b.plusOne(new int[]{0})));
    }
}
