package edu.leetcode.tasks.medium;

import java.util.*;

/**
 * 2022-08-01
 */
public class FindReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        final int[] etalonPattern = getMask(pattern);

        for (String w : words) {
            int[] tmp = getMask(w);
            if (Arrays.equals(etalonPattern, tmp)) {
                result.add(w);
            }
        }
        return result;
    }

    private int[] getMask(String txt) {
        Map<Character, Integer> map = new HashMap<>();

        int[] mask = new int[txt.length()];
        int start = 0;
        int pos = 0;
        for (char c : txt.toCharArray()) {
            if (!map.containsKey(c)) {
                start++;
                map.putIfAbsent(c, start);
            }

            mask[pos] = map.get(c);
            pos++;
        }

        return mask;
    }

    public static void main(String[] args) {
        FindReplacePattern p = new FindReplacePattern();

//        System.out.println(p.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
//        System.out.println(p.findAndReplacePattern(new String[]{"a", "b", "c", "d"}, "a"));
        System.out.println(p.findAndReplacePattern(new String[]{"abcdefghijklab", "abcdefghijkabl"}, "abcdefghijklab"));
    }
}
