package edu.leetcode.tasks.easy;

import java.util.ArrayList;

class MyQueue {

    ArrayList<Integer> stack = new ArrayList<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(0);
    }

    public int peek() {
        return stack.get(0);
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}