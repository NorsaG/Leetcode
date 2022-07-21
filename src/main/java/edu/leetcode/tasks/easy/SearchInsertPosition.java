package edu.leetcode.tasks.easy;

/**
 * 2022-04-22
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            int comp = compare(nums[0], target);
            return comp == -1 || comp == 0 ? 0 : 1;
        }
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int up = nums.length;
        int down = 0;
        int midPoint = (up - down) / 2;

        int previousPoint = midPoint;
        while (true) {
            // value
            int current = nums[midPoint];

            // get direction
            int compareResult = compare(current, target);

            // result there
            if (compareResult == 0) {
                return midPoint;
            }

            if (compareResult == -1) {
                // go down
                up = midPoint;
                midPoint = (up - down) / 2;
            } else {
                // go up
                down = midPoint;
                midPoint = midPoint + (up - down) / 2;
                if (previousPoint == midPoint)
                    return previousPoint + 1;
                previousPoint = midPoint;
            }
        }
    }

    public int compare(int checked, int target) {
        return Integer.compare(target, checked);
    }


    public static void main(String[] args) {
        SearchInsertPosition position = new SearchInsertPosition();
        System.out.println("1 " + position.searchInsert(new int[]{1, 3}, 2));
        System.out.println("3 " + position.searchInsert(new int[]{3, 5, 7, 9, 10}, 8));
        System.out.println("0 " + position.searchInsert(new int[]{3, 5, 7, 9, 10}, -1));
        System.out.println("2 " + position.searchInsert(new int[]{3, 5, 7, 9, 10}, 6));
        System.out.println("4 " + position.searchInsert(new int[]{1, 3, 5, 6}, 10));
        System.out.println("0 " + position.searchInsert(new int[]{1, 3, 5, 6}, -10));
        System.out.println("1 " + position.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("0 " + position.searchInsert(new int[]{2, 3, 5, 6}, 2));
        System.out.println("0 " + position.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println("0 " + position.searchInsert(new int[]{1, 3, 5, 6}, -1));
    }

}
