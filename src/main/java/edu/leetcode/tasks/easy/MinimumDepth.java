package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.TreeNode;

public class MinimumDepth {
    private Integer minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        checkAllLeafs(root, depth);
        return minDepth;
    }

    private void checkAllLeafs(TreeNode root, int depth) {
        depth++;
        if (root.left == null && root.right == null) {
            if (depth < minDepth)
                minDepth = depth;
        }
        if (root.left != null)
            checkAllLeafs(root.left, depth);

        if (root.right != null)
            checkAllLeafs(root.right, depth);
    }


}

