package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth2 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> leafs = new LinkedList<>();
        leafs.offer(root);

        while (leafs.size() > 0) {
            int size = leafs.size();
            depth++;

            while (size > 0) {
                TreeNode node = leafs.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null)
                    leafs.offer(node.left);

                if (node.right != null)
                    leafs.offer(node.right);
                size--;
            }
        }

        return depth;
    }

}
