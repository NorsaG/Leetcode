package edu.leetcode.tasks.easy;

import java.util.Stack;

public class ValidParentheses {
    private final Stack<Character> stack = new Stack<>(); // ()

    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        if (s.length() % 2 == 1)
            return false;

        for (char c : s.toCharArray()) {
            if (!checkChar(c))
                return false;

        }

        return stack.size() == 0;
    }

    private boolean checkChar(char c) {
        switch (c) {
            case '(':
            case '[':
            case '{': {
                stack.push(c);
                break;
            }
            case ')': {
                if (stack.size() == 0) {
                    return false;
                }
                Character character = stack.pop();
                if (!character.equals('(')) {
                    return false;
                }
                break;
            }

            case '}': {
                if (stack.size() == 0) {
                    return false;
                }
                Character character = stack.pop();
                if (!character.equals('{')) {
                    return false;
                }
                break;
            }

            case ']': {
                if (stack.size() == 0) {
                    return false;
                }
                Character character = stack.pop();
                if (!character.equals('[')) {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
}
