package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.TreeNode;

public class LowestAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return root;
        int rootValue = root.val;
        int pValue = p.val;
        int vValue = q.val;
        if (pValue < rootValue && vValue > rootValue)
            return root;
        if (pValue > rootValue && vValue < rootValue)
            return root;

        if (root.right != null && rootValue > pValue && rootValue > vValue)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.left != null && rootValue <pValue && rootValue < vValue)
            return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

}
