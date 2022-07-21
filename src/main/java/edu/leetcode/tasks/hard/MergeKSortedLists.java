package edu.leetcode.tasks.hard;

import edu.leetcode.tasks.help.ListNode;

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        List<ListNode> l = new ArrayList<>();
        Collections.addAll(l, lists);

        ListNode currentNode = null;
        while (true) {
            int currentStepValue = Integer.MAX_VALUE;
            int pickedIndex = -1;

            for (int i = 0; i < l.size(); i++) {
                ListNode ln = l.get(i);
                if (ln == null) {
                    continue;
                }

                if (ln.val < currentStepValue) {
                    currentStepValue = ln.val;
                    pickedIndex = i;
                }
            }
            if (pickedIndex == -1) {
                break;
            }

            ListNode nextNode = new ListNode(currentStepValue);
            if (result == null) {
                result = nextNode;
                currentNode = result;
            } else {
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
            l.set(pickedIndex, l.get(pickedIndex).next);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln11 = new ListNode(2);
        ln1.next = ln11;
        ln11.next = new ListNode(3);


        ListNode ln2 = new ListNode(-1);
        ln2.next = new ListNode(0);

        System.out.println(new MergeKSortedLists().mergeKLists(new ListNode[]{ln1, ln2}));
    }
}
