package edu.leetcode.tasks.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-04-28
 */
public class StrStrImpl {

    public int strStr(String haystack, String needle) {
        if (needle.length() < 1)
            return 0;
        if (haystack.length() <= needle.length())
            return -1;

        List<String> possibleValues = new ArrayList<>();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + needle.length(); j++) {
                sb.append(haystack.charAt(j));
            }
            possibleValues.add(sb.toString());
        }
        return possibleValues.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new StrStrImpl().strStr("abc", "c"));
    }
}
