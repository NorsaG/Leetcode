package edu.leetcode.tasks.easy;

/**
 * 2022-04-25
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int pos = -1;
        int counter = 0;

        int tmpValue = Integer.MIN_VALUE;
        boolean isDuplicate;
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            isDuplicate = currentValue == tmpValue;
            if (!isDuplicate) {
                tmpValue = currentValue;
                counter++;
                pos++;
            }

            if (!isDuplicate) {
                nums[pos] = currentValue;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
        System.out.println(remove.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
