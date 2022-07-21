package edu.leetcode.tasks.easy;

import java.util.HashMap;
import java.util.Map;

public class MyHashSet {
    Map<Integer, Object> set = new HashMap<>();

    public MyHashSet() {

    }

    public void add(int key) {
        set.put(key, null);
    }

    public void remove(int key) {
        set.remove(key);
    }

    public boolean contains(int key) {
        return set.containsKey(key);
    }
}
