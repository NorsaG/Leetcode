package edu.leetcode.tasks.medium;

import edu.leetcode.tasks.help.ListNode;

/**
 * 2022-07-22
 */
public class ReversedLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode newHead = null;
        ListNode reversedList = null;

        ListNode reversedPart = null;
        ListNode cursor = head;

        boolean isReverse = false;
        for (int i = 1; i <= right; i++) {
            if (reversedPart != null && cursor != null) {
                ListNode ln = new ListNode(cursor.val);
                ln.next = reversedPart;
                reversedPart = ln;
            }

            if (i == left) {
                //start reverse
                reversedPart = new ListNode(cursor.val);
                isReverse = true;
            } else if (i == right) {
                //stop reverse
                if (reversedList != null) {
                    ListNode lastNode = reversedList;
                    while (lastNode.next != null) {
                        lastNode = lastNode.next;
                    }
                    lastNode.next = reversedPart;
                } else {
                    reversedList = reversedPart;
                }
                ListNode lastNode = reversedList;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }
                lastNode.next = cursor.next;
                break;
            }
            if (!isReverse) {
                ListNode ln = new ListNode(cursor.val);

                if (reversedList == null) {
                    reversedList = ln;
                    newHead = ln;
                } else {
                    reversedList.next = ln;
                    reversedList = reversedList.next;
                }
            }
            if (cursor != null) {
                cursor = cursor.next;
            }
        }

        return newHead == null ? reversedList : newHead;
    }


    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = l2;

        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);

        ll1.next = ll2;
        ll2.next = ll3;

        System.out.println(new ReversedLinkedList2().reverseBetween(ln1, 2, 4));
        System.out.println(new ReversedLinkedList2().reverseBetween(ln1, 3, 4));
        System.out.println(new ReversedLinkedList2().reverseBetween(ln1, 4, 5));
        System.out.println(new ReversedLinkedList2().reverseBetween(new ListNode(1), 1, 1));
        System.out.println(new ReversedLinkedList2().reverseBetween(l1, 1, 2));
        System.out.println(new ReversedLinkedList2().reverseBetween(ll1, 1, 2));
        System.out.println(new ReversedLinkedList2().reverseBetween(ll1, 1, 3));
        System.out.println(new ReversedLinkedList2().reverseBetween(ll1, 2, 3));
    }
}
