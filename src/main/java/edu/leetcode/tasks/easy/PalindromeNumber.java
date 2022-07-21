package edu.leetcode.tasks.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        if (x == 0)
            return true;

        if (x < 10)
            return true;

        int tmp = x;
        List<Integer> numbers = new ArrayList<>();
        while (tmp > 0) {
            numbers.add(tmp % 10);
            tmp = tmp / 10;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if ((int) numbers.get(i) != numbers.get(numbers.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
