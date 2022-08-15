package edu.leetcode.tasks.medium;

import edu.leetcode.tasks.help.TreeNode;

public class BinarySearchTreeValidator {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTTree(root, null, null);
    }

    private boolean isValidBSTTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)
            return true;

        if (min != null && min.val >= root.val)
            return false;
        if (max != null && max.val <= root.val)
            return false;
        return isValidBSTTree(root.left, min, root) && isValidBSTTree(root.right, root, max);
    }

    public static void main(String[] args) {
        BinarySearchTreeValidator v = new BinarySearchTreeValidator();
        TreeNode node1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(v.isValidBST(node1));


        TreeNode node2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(v.isValidBST(node2));

        TreeNode node3 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println(v.isValidBST(node3));

        TreeNode node4 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(v.isValidBST(node4));

        //[32,26,47,19,null,null,56,null,27]
        TreeNode node5 = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null), new TreeNode(47, null, new TreeNode(56)));
        System.out.println(v.isValidBST(node5));

        TreeNode node6 = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        System.out.println(v.isValidBST(node6));

    }
}
