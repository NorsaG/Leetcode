package edu.leetcode.tasks.contests;

import java.util.Comparator;
import java.util.TreeSet;
/**
 * 2022-05-12
 */
public class Largest3SameDigitNumber {
    public String largestGoodInteger(String num) {

        TreeSet<String> find = new TreeSet<>(Comparator.comparingInt(Integer::parseInt));
        for (int i = 0; i < num.length() - 2; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);
            if (c1 == c2 && c2 == c3) {
                String tmp = "" + c1 + c2 + c3;
                find.add(tmp);
                if (find.size() == 10)
                    return "999";
            }

        }

        if (find.size() == 0) {
            return "";
        }

        return find.last();
    }

    public static void main(String[] args) {
        Largest3SameDigitNumber l = new Largest3SameDigitNumber();
        System.out.println(l.largestGoodInteger("222"));
        System.out.println(l.largestGoodInteger("111133"));
        System.out.println(l.largestGoodInteger("1333111333"));
        System.out.println(l.largestGoodInteger("1234456789"));
        System.out.println(l.largestGoodInteger("1888234456999789"));
    }
}
