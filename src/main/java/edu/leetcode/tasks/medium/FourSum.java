package edu.leetcode.tasks.medium;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> al = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int sum = target - (nums[i] + nums[j]);
                int m = j + 1, n = nums.length - 1;

                while (m < n) {
                    if (nums[m] + nums[n] == sum) {
                        if (!al.contains(Arrays.asList(nums[i], nums[j], nums[m], nums[n])))
                            al.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                    }
                    if (nums[m] + nums[n] < sum) m++;

                    if (nums[m] + nums[n] > sum) n--;
                }

            }
        }
        return al;
    }
}
