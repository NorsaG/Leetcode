package edu.leetcode.tasks.medium;

import java.util.Arrays;

/**
 * 2022-05-04
 */
public class MaxNumberOfKSum {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        if (nums.length == 1) {
            return result;
        }
        Arrays.sort(nums);

        int rightPoint = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {

            int fixValue = nums[i];
            for (int j = rightPoint; j > i; j--) {
                if (nums[j] == (k - fixValue)) {
                    result++;
                    rightPoint = j - 1;
                    break;
                }
            }
            if (i >= rightPoint) {
                break;
            }
        }
        return result;
    }

}
