package edu.leetcode.tasks.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-07-23
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if (nums.length == 1) {
            results.add(0);
            return results;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int flag = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                int check = nums[j];
                if (flag > check) {
                    count++;
                }
            }
            results.add(count);
        }
        results.add(0);
        return results;
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
        System.out.println(c.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(c.countSmaller(new int[]{-1, -1}));
        System.out.println(c.countSmaller(new int[]{-1}));
    }
}
