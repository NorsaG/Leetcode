package edu.leetcode.tasks.medium;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        searchLastIndexForSwap(nums);
    }

    private void searchLastIndexForSwap(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverseSubArray(nums, i + 1, nums.length - 1);

    }

    private void reverseSubArray(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
//        int[] nums = new int[]{2, 1, 6, 5, 4, 3};  // 2,3,1,4,5,6
//        int[] nums = new int[]{1,3,2};  // 2,1,3
//        int[] nums = new int[]{1,2,3};  // 1,3,2
//        int[] nums = new int[]{3,2,1};  // 1,2,3
//        int[] nums = new int[]{2,3,1};  //3,1,2
        int[] nums = new int[]{4, 2, 0, 2, 3, 2, 0};  // 4,2,0,3,0,2,2
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    // 1,2,3,4
    // 1,2,4,3
    // 1,3,2,4
    // 1,3,4,2
    // 2,1,3,4
    // 2,1,4,3
    // 2,3,1,4
    // 2,3,4,1
    // 2,4,1,3


    // 2,1,1,3
    // 2,1,3,1
    // 2,1,3,1


    // 2,3,1,6,5,4
    // 2,3,4,1,5,6
    // 2,3,4,1,5,6

    // 2,1,6,5,4,3
    // 2,3,6,5,4,1

    // 2,1,6,5,4,3
    //   -
}

