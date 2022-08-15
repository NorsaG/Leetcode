package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.TreeNode;

/**
 * 2022-08-10
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length == 2) {
            return new TreeNode(nums[0], null, new TreeNode(nums[1]));
        }
        return makeNode(nums, 0, nums.length - 1);
    }

    private TreeNode makeNode(int[] nums, int left, int right) {
        TreeNode root;
        if (right - left == 0) {
            return new TreeNode(nums[left]);
        } else if (right - left == 1) {
            return new TreeNode(nums[left], null, new TreeNode(nums[right]));
        } else {
            int middle = (right - left) / 2;
            root = new TreeNode(nums[left + middle]);
            root.left = makeNode(nums, left, left + middle - 1);
            root.right = makeNode(nums, left + middle + 1, right);
        }

        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST s = new SortedArrayToBST();

        TreeNode tn1 = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(tn1);
        TreeNode tn2 = s.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6});
        System.out.println(tn2);
    }
}
