package edu.leetcode.tasks.easy;

/**
 * 2022-05-05
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;

        int slow = 0;
        int fast = 1;

        while (slow < nums.length - 1) {
            if (nums[slow] == 0) {
                if (nums[fast] == 0 && fast == nums.length - 1) {
                    break;
                }
                if (nums[fast] != 0) {
                    swap(nums, slow, fast);
                    slow++;
                    fast = slow + 1;
                } else {
                    fast++;
                }
            } else {
                slow++;
                fast = slow + 1;
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
