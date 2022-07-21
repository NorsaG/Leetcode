package edu.leetcode.tasks.medium;

import java.util.TreeSet;

public class LongestConsecutiveNumbers {


    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> tree = new TreeSet<>(Integer::compareTo);
        for (int i : nums)
            tree.add(i);
        int max = 0;
        int count = 1;
        int prev = Integer.MAX_VALUE - 1;
        for (Integer i : tree) {
            if (prev + 1 == i) {
                count++;
            } else {
                count = 1;
            }
            prev = i;

            if (count > max)
                max = count;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
