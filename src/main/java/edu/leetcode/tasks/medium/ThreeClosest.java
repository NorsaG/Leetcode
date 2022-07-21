package edu.leetcode.tasks.medium;

import java.util.Arrays;

/**
 * 2022-04-21
 */
public class ThreeClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;


        int distance = Integer.MAX_VALUE;
        int finalSum = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = value + nums[left] + nums[right];
                int difference = target - sum;

                if (difference == 0) {
                    return sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

                if (Math.abs(difference) < Math.abs(distance)) {
                    distance = difference;
                    finalSum = sum;
                }
            }

        }

        return  finalSum;
    }

    public static void main(String[] args) {
        ThreeClosest closest = new ThreeClosest();
        System.out.println(closest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(closest.threeSumClosest(new int[]{1, 1, 1, 0}, -100));
        System.out.println(closest.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
        System.out.println(closest.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
        System.out.println(closest.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
    }
}
