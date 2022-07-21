package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.ListNode;


/**
 * 2022-04-22
 */
public class Merge2SortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        if (list1 == null && list2 == null)
            return null;

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode lnLeft = list1;
        ListNode lnRight = list2;

        ListNode currentNode = null;
        while (true) {

            if (lnLeft == null) {
                currentNode.next = lnRight;
                break;
            }
            if (lnRight == null) {
                currentNode.next = lnLeft;
                break;
            }

            int lValue = lnLeft.val;
            int rValue = lnRight.val;

            ListNode next;
            if (lValue > rValue) {
                next = lnRight;
                lnRight = lnRight.next;
            } else {
                next = lnLeft;
                lnLeft = lnLeft.next;
            }
            if (result == null) {
                result = next;
                currentNode = result;
            } else {
                currentNode.next = next;
                currentNode = next;
            }

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

        System.out.println(new Merge2SortedLists().mergeTwoLists(ln1, ln2));
    }


}
