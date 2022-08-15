package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.TreeNode;

/**
 * 2022-08-12
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (rootVal > pVal && rootVal > qVal && root.left != null) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (rootVal < pVal && rootVal < qVal && root.right != null) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST l = new LowestCommonAncestorBST();
//        [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        TreeNode tn = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(l.lowestCommonAncestor(tn, new TreeNode(2), new TreeNode(8)).val);
        System.out.println(l.lowestCommonAncestor(tn, new TreeNode(2), new TreeNode(4)).val);
    }
}
