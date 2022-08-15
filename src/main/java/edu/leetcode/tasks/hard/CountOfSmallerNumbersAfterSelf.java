package edu.leetcode.tasks.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-07-23
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller_simple(int[] nums) {
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

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> results = new ArrayList<>(nums.length);
        if (nums.length == 1) {
            results.add(0);
            return results;
        }
        count(results, nums, 0);
        return results;
    }

    private int count(List<Integer> results, int[] nums, int position) {
        int val = nums[position];

        if (position + 1 == nums.length) {
            results.add(0, 0);
            return 0;
        }
        int next = nums[position + 1];

        int c;
        if (val > next)
            c = count(results, nums, position + 1) + 1;
        else if (val == next)
            c = count(results, nums, position + 1);
        else {
            int fixedPos = -1;
            for (int j = position + 1; j < nums.length; j++) {
                if (val >= nums[j]) {
                    fixedPos = j;
                    break;
                }
            }
            c = fixedPos == -1 ? 0 : count(results, nums, fixedPos);
        }
        results.add(0, c);
        return c;
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
//        System.out.println(c.countSmaller_simple(new int[]{5, 2, 6, 1}));
//        System.out.println(c.countSmaller_simple(new int[]{-1, -1}));
//        System.out.println(c.countSmaller_simple(new int[]{-1}));
//        System.out.println(c.countSmaller_simple(new int[]{0,2,1}));
//
//        System.out.println(c.countSmaller(new int[]{5, 2, 6, 1}));
//        System.out.println(c.countSmaller(new int[]{-1, -1}));
//        System.out.println(c.countSmaller(new int[]{-1}));
        System.out.println(c.countSmaller(new int[]{0, 2, 1}));
    }
}
