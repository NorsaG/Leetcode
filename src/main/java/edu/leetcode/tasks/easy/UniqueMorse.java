package edu.leetcode.tasks.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2022-04-25
 */
public class UniqueMorse {
    private static final String[] literals = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    private static final Map<Character, String> mapping = new HashMap<>();

    static {
        int aStart = 97;
        for (String str : literals) {
            mapping.put((char) aStart, str);
            aStart++;
        }
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueTransformations = new HashSet<>();
        for (String word : words) {
            StringBuilder representation = new StringBuilder();
            for (char c : word.toCharArray()) {
                representation.append(mapping.get(c));
            }
            uniqueTransformations.add(representation.toString());
        }
        return uniqueTransformations.size();
    }


}
