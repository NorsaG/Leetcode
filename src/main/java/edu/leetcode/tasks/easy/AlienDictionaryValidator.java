package edu.leetcode.tasks.easy;

import java.util.*;

public class AlienDictionaryValidator {

    private static Map<Character, Integer> sorter = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        constructSorter(order);

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currentWord = words[i];
            if (prevWord.equals(currentWord)) {
                continue;
            }
            boolean res = compareWords(prevWord, currentWord);
            if (!res) {
                return false;
            }
        }
        return true;
    }

    private boolean compareWords(String prevWord, String word) {
        for (int i = 0; i < Math.min(prevWord.length(), word.length()); i++) {
            int prevPosSym = sorter.get(prevWord.toCharArray()[i]);
            int currPosSym = sorter.get(word.toCharArray()[i]);
            if (prevPosSym > currPosSym) {
                return false;
            } else if (prevPosSym < currPosSym) {
                return true;
            }
        }

        return prevWord.length() <= word.length();
    }

    private void constructSorter(String order) {
        int i = 0;
        for (char c : order.toCharArray()) {
            sorter.put(c, i);
            i++;
        }
    }

    public static void main(String[] args) {
        AlienDictionaryValidator v = new AlienDictionaryValidator();
        System.out.println(v.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
