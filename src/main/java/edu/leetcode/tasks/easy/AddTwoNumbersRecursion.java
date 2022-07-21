package edu.leetcode.tasks.easy;

import edu.leetcode.tasks.help.ListNode;

public class AddTwoNumbersRecursion {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String val1 = getValue(new StringBuilder(), l1);
        String val2 = getValue(new StringBuilder(), l2);

        ListNode res = null;
        ListNode currentNode = null;

        boolean moreThatTen = false;
        int i = 0;

        while (true) {
            int val = moreThatTen ? 1 : 0;
            if (val1.length() > i) {
                val = val + Integer.parseInt(String.valueOf(val1.charAt(i)));
            }
            if (val2.length() > i) {
                val = val + Integer.parseInt(String.valueOf(val2.charAt(i)));
            }

            moreThatTen = val >= 10;
            val = val >= 10 ? val % 10 : val;
            if (val1.length() <= i && val2.length() <= i && !moreThatTen && val == 0) {
                break;
            }

            if (res == null) {
                res = new ListNode(val);
                currentNode = res;
            } else {
                currentNode.next = new ListNode(val);
                currentNode = currentNode.next;
            }
            i++;
        }
        return res;
    }

    private String getValue(StringBuilder sb, ListNode ln) {
        sb.append(ln.val);
        if (ln.next == null) {
            return sb.toString();
        }
        return getValue(sb, ln.next);
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln11 = new ListNode(2);
        ln1.next = ln11;
        ln11.next = new ListNode(3);


        ListNode ln2 = new ListNode(0);
        ln2.next = new ListNode(2);

        System.out.println(new AddTwoNumbersRecursion().addTwoNumbers(ln1, ln2));
    }


}
