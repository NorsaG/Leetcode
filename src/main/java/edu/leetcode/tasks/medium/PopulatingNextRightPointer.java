package edu.leetcode.tasks.medium;

import edu.leetcode.tasks.help.Node;

import java.util.*;

/**
 * 2022-05-13
 */
public class PopulatingNextRightPointer {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> level = new LinkedList<>();

        level.offer(root);
        root.next = null;
        while (level.size() > 0) {
            int size = level.size();
            while (size > 0) {
                Node node = level.poll();

                if (node.left != null)
                    level.offer(node.left);

                if (node.right != null)
                    level.offer(node.right);
                size--;
            }
            if (level.size() > 0) {
                Iterator<Node> reverse = level.descendingIterator();
                Node right = reverse.next();
                right.next = null;
                while (reverse.hasNext()) {
                    Node left = reverse.next();
                    left.next = right;
                    right = left;
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n51 = new Node(51);
        Node n52 = new Node(52);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n5.left = n51;
        n5.right = n52;

        n3.right = n7;

        PopulatingNextRightPointer p = new PopulatingNextRightPointer();
        p.connect(n1);
        System.out.println();
    }
}
