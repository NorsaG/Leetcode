package edu.leetcode.tasks.medium;

import edu.leetcode.tasks.help.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(getVal(l1) + getVal(l2));

        ListNode tmp1 = getNextNode(l1);
        ListNode tmp2 = getNextNode(l2);

        ListNode tmpNode;
        while ((tmp1 != null) || (tmp2 != null)) {
            tmpNode = new ListNode(getVal(tmp1) + getVal(tmp2));
            tmp1 = getNextNode(tmp1);
            tmp2 = getNextNode(tmp2);
            getLatestNode(node).next = tmpNode;
        }

        node = recalcNode(node);
        return node;
    }

    private ListNode recalcNode(ListNode node) {
        int add = 0;
        ListNode tmp = node;
        while (tmp != null) {
            tmp.val += add;
            if (tmp.val > 9) {
                tmp.val = tmp.val - 10;
                add = 1;
            } else {
                add = 0;
            }
            tmp = tmp.next;
        }
        if (add == 1)
            getLatestNode(node).next = new ListNode(1);
        return node;
    }

    private ListNode getLatestNode(ListNode node) {
        while (node.next != null)
            node = node.next;
        return node;
    }

    private int getVal(ListNode node) {
        return node != null ? node.val : 0;
    }

    private ListNode getNextNode(ListNode node) {
        return node != null && node.next != null ? node.next : null;
    }

}
