package edu.leetcode.tasks.medium;

import java.util.*;

public class RemoveAllAdjacentDuplicatesInString {

    // too slow
    //    public String removeDuplicates(String s, int k) {
//        if (s.length() < 2) {
//            return s;
//        }
//
//        boolean needCheck = true;
//        String tmpResult = s;
//        while (s.length() >= k && needCheck) {
//            tmpResult = removeIteration(s, k);
//            if (s.equals(tmpResult))
//                needCheck = false;
//            s = tmpResult;
//        }
//
//        return s;
//    }
//
//    private String removeIteration(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder tmpSB = new StringBuilder();
//
//        char tmp = s.charAt(0);
//        int counter = 0;
//        for (char c : s.toCharArray()) {
//            if (tmp == c) {
//                tmpSB.append(c);
//                counter++;
//                if (counter == k) {
//                    tmpSB.delete(0, tmpSB.length());
//                    tmp = '\u0000';
//                    counter = 1;
//                }
//            } else {
//                tmp = c;
//                counter = 1;
//                sb.append(tmpSB);
//                tmpSB.delete(0, tmpSB.length());
//                tmpSB.append(c);
//            }
//        }
//        sb.append(tmpSB);
//        return sb.toString();
//    }

    // too slow again :(
//    public String removeDuplicates(String s, int k) {
//        if (s.length() < 2 || s.length() < k) {
//            return s;
//        }
//        Set<Character> uniqueSet = new HashSet<>();
//        List<Character> characters = new ArrayList<>();
//        for (char c : s.toCharArray()) {
//            characters.add(c);
//
//
//            int currentSize = characters.size();
//            if (currentSize >= k) {
//                for (int i = currentSize - 1; i >= currentSize - k; i--) {
//                    Character tmp = characters.get(i);
//                    uniqueSet.add(tmp);
//                    if (uniqueSet.size() > 1) {
//                        break;
//                    }
//                }
//
//                if (uniqueSet.size() == 1) {
//                    for (int i = 0; i < k; i++) {
//                        characters.remove(characters.size() - 1);
//                    }
//                }
//                uniqueSet.clear();
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (char c : characters) {
//            sb.append(c);
//        }
//        return sb.toString();
//    }

    public String removeDuplicates(String s, int k) {
        if (s.length() < 2 || s.length() < k) {
            return s;
        }
        Deque<Pair> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty() || deque.getLast().isNotTheSameChar(c)) {
                deque.add(new Pair(c));
            } else {
                Pair p = deque.getLast();
                p.increment();
                if (p.count == k) {
                    deque.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : deque) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.c);
            }
        }
        return sb.toString();
    }

    private static class Pair {
        char c;
        int count;

        Pair(char c) {
            this.c = c;
            this.count = 1;
        }

        void increment() {
            this.count++;
        }

        boolean isNotTheSameChar(char ch) {
            return this.c != ch;
        }
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString remove = new RemoveAllAdjacentDuplicatesInString();

        System.out.println(remove.removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(remove.removeDuplicates("abcd", 2));
        System.out.println(remove.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(remove.removeDuplicates("baggsfggttciiippooaais", 2));
    }
}
