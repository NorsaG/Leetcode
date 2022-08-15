package edu.leetcode.tasks.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-08-10
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() < 2) {
            return 0;
        }

        List<Integer> uniqueCount = new ArrayList<>();
        int charCount = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == c) {
                charCount++;
            } else {
                uniqueCount.add(charCount);
                charCount = 1;
                c = tmp;
            }
        }
        uniqueCount.add(charCount);

        int count = 0;
        for (int i = 0; i < uniqueCount.size() - 1; i++) {
            count += Math.min(uniqueCount.get(i), uniqueCount.get(i + 1));
        }

        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings c = new CountBinarySubstrings();
        System.out.println(c.countBinarySubstrings("01"));
        System.out.println(c.countBinarySubstrings("10"));
        System.out.println(c.countBinarySubstrings("00110011"));
        System.out.println(c.countBinarySubstrings("10101"));
        System.out.println(c.countBinarySubstrings("101011"));
        System.out.println(c.countBinarySubstrings("00110"));
    }
}
