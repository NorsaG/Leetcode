package edu.leetcode.tasks.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeating {
    List<Character> list = new ArrayList<>();

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;

        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String tmpStr = s.substring(i);
            int tmp = calc(tmpStr);

            if (tmp > res)
                res = tmp;

            if (res > tmpStr.length())
                break;
        }
        return res;
    }

    private int calc(String s) {
        list.clear();

        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            } else {
                break;
            }
        }

        return list.size();
    }
}
