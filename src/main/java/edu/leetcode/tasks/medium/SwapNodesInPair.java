package edu.leetcode.tasks.medium;

import edu.leetcode.tasks.help.ListNode;

public class SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode listNode = head.next;
        if (listNode == null)
            return head;
        ListNode nextNode = listNode.next;

        if (nextNode != null)
            head.next = swapPairs(nextNode);
        else
            head.next = null;
        listNode.next = head;
        return listNode;
    }

}