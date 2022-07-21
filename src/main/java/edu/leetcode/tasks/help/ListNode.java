package edu.leetcode.tasks.help;


import java.util.StringJoiner;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        ListNode node = this;
        StringJoiner sj = new StringJoiner(",");
        while (node != null) {
            sj.add(Integer.toString(node.val));
            node = node.next;
        }
        return "[" + sj + "]";
    }
}
