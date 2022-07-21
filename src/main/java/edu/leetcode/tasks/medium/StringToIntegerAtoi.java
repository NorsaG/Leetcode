package edu.leetcode.tasks.medium;

/**
 * 2022-04-14
 */
public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        long result = 0;
        s = trimSpaces(s);
        boolean isPositive = true;
        boolean first = true;
        for (char c : s.toCharArray()) {
            if (first) {
                first = false;
                if (c == '-') {
                    isPositive = false;
                    continue;
                } else if (c == '+') {
                    continue;
                }
            }
            if (isCharNumber(c)) {
                result = result * 10 + getInt(c);
                if (result > Integer.MAX_VALUE) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else
                break;
        }

        return isPositive ? (int) result : (int) -result;

    }

    private long getInt(char c) {
        switch (c) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '0':
                return 0;
        }
        return 0;
    }

    private boolean isCharNumber(char c) {
        return c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0';
    }

    private String trimSpaces(String s) {
        return s.trim();
    }

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi("+-42"));
    }
}
