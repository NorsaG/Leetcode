package edu.leetcode.tasks.easy;

/**
 * 2022-04-15
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        String tmp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            tmp = compareStr(tmp, strs[i]);

            if (tmp.length() == 0)
                return "";
        }
        return tmp;
    }

    private String compareStr(String tmp, String str) {
        StringBuilder sb = new StringBuilder();
        int length = tmp.length();
        for (int i = 0; i < str.length(); i++) {
            if (length < i+1)
                break;
            char c = str.charAt(i);
            if (tmp.charAt(i) == c)
                sb.append(c);
            else
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s1));
    }
}
