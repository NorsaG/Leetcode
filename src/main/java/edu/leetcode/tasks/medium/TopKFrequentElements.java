package edu.leetcode.tasks.medium;

import java.util.*;

/**
 * 2022-05-04
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int pos = 0;
        List<Pair> p = new ArrayList<>();
        for (int i : nums) {
            if (mapping.get(i) == null) {
                mapping.put(i, pos);
                p.add(new Pair(i));
                pos++;
            } else {
                int position = mapping.get(i);
                p.get(position).increment();
            }
        }
        p.sort(Comparator.comparingInt(o -> o.counter));
        int[] r = new int[k];
        for (int i = p.size() - 1; i > p.size() - 1 - k; i--) {
            r[p.size() - 1 - i] = p.get(i).value;
        }
        return r;
    }

    private static class Pair {
        int value;
        int counter;

        Pair(int value) {
            this.value = value;
        }

        void increment() {
            counter++;
        }
    }


    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] n = new int[]{1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 6};
        System.out.println(Arrays.toString(t.topKFrequent(n, 2)));
    }
}
