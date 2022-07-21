package edu.leetcode.tasks.contests;

import edu.leetcode.tasks.help.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2022-05-12
 */
public class CountEqualNodesOfSubtree {
    public int averageOfSubtree(TreeNode root) {
        if (root.right == null && root.left == null)
            return 1;

        AtomicInteger result = new AtomicInteger(0);

        Pair p = getPair(root, result);
        return result.get();
    }


    private Pair getPair(TreeNode node, AtomicInteger result) {
        if (node.right == null && node.left == null) {
            result.incrementAndGet();
            return new Pair(1, node.val);
        }

        if (node.right == null) {
            Pair p = getPair(node.left, result);

            if (((node.val + p.value) / (1 + p.count)) == node.val)
                result.incrementAndGet();
            return new Pair(1 + p.count, node.val + p.value);
        }

        if (node.left == null) {
            Pair p = getPair(node.right, result);
            if (((node.val + p.value) / (1 + p.count)) == node.val)
                result.incrementAndGet();
            return new Pair(1 + p.count, node.val + p.value);
        }

        Pair p1 = getPair(node.left, result);
        Pair p2 = getPair(node.right, result);

        if (((p1.value + p2.value + node.val) / (p1.count + p2.count + 1)) == node.val)
            result.incrementAndGet();
        return new Pair(p1.count + p2.count + 1, p1.value + p2.value + node.val);
    }

    private static class Pair {
        int count = 0;
        int value = 0;

        Pair(int count, int value) {
            this.count = count;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        CountEqualNodesOfSubtree c = new CountEqualNodesOfSubtree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        TreeNode l1 = root.left;
        root.right = new TreeNode(5);
        TreeNode l2 = root.right;

        l1.left = new TreeNode(0);
        l1.right = new TreeNode(1);

        l2.right = new TreeNode(6);

        System.out.println(c.averageOfSubtree(root));
        System.out.println(c.averageOfSubtree(new TreeNode(0)));


        TreeNode r1 = new TreeNode(1);
        r1.right = new TreeNode(3);
        TreeNode r11 = r1.right;
        r11.right = new TreeNode(1);
        TreeNode r111 = r11.right;
        r111.right = new TreeNode(3);
        System.out.println(c.averageOfSubtree(r1));

    }
}
