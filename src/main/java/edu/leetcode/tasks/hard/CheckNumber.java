package edu.leetcode.tasks.hard;


import java.util.regex.Pattern;

public class CheckNumber {
    private static final Pattern INT_NUMBER_PATTERN = Pattern.compile("(\\d+)");
    private static final Pattern DECIMAL_NUMBER_PATTERN = Pattern.compile("((\\d+)(\\.?)(\\d*)|(\\d*)(\\.?)(\\d+))");

    public boolean isNumber(String s) {
        if (isExponential(s)) {
            int eIndex = s.indexOf("e");
            if (eIndex == -1) {
                eIndex = s.indexOf("E");
            }
            String p1 = s.substring(0, eIndex);
            String p2 = s.substring(eIndex + 1);

            return !p1.equals("") && !p2.equals("") && isInteger(p2) && isDecimal(p1);
        } else {
            return isInteger(s) || isDecimal(s);
        }
    }

    private boolean isInteger(String s) {
        char sign = s.charAt(0);
        if (sign == '-' || sign == '+') {
            s = s.substring(1);
        }

        return INT_NUMBER_PATTERN.matcher(s).matches();
    }

    private boolean isDecimal(String s) {
        if (isInteger(s)) {
            return true;
        }
        if (!s.contains(".")) {
            return false;
        }
        char sign = s.charAt(0);
        if (sign == '-' || sign == '+') {
            s = s.substring(1);
        }

        return DECIMAL_NUMBER_PATTERN.matcher(s).matches();
    }

    private boolean isExponential(String s) {
        return (s.contains("e") || s.contains("E"));
    }

}
