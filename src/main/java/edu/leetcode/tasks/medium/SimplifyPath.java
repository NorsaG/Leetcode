package edu.leetcode.tasks.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SimplifyPath {
    private static final String ROOT = "/";
    public static void main(String[] args) {
        String input = "/r//n/";
        System.out.println(simplifyPath(input));
    }

    public static String simplifyPath(String path) {
        checkConstraints(path);

        path = path.replace("//", "/");

        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }

        if (!path.startsWith("/")) {
            int index = path.indexOf("/");
            path = path.substring(index);
        }

        String[] parts = path.split("/");

        List<String> elements = new ArrayList<>();
        for (String p : parts) {
            if (p.equals(".")) {
                continue;
            }
            if (p.equals("..")) {
                elements.remove(elements.size() - 1);
                continue;
            }

            elements.add(p);

        }

        return String.join(SEPARATOR, elements);
    }

    private static final String SEPARATOR = "/";

    private static void checkConstraints(String path) {
        if (path == null || path.length() < 1 || path.length() > 3000) {
            throw new RuntimeException();
        }

    }
}
