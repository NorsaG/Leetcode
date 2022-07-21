package edu.leetcode.tasks.hard;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testValid() {
        assertTrue(isNumber("2"));
        assertTrue(isNumber("0089"));
        assertTrue(isNumber("-0.1"));
        assertTrue(isNumber("+3.14"));
        assertTrue(isNumber("4."));
        assertTrue(isNumber("-.9"));
        assertTrue(isNumber("2e10"));
        assertTrue(isNumber("-90E3"));
        assertTrue(isNumber("3e+7"));
        assertTrue(isNumber("+6e-1"));
        assertTrue(isNumber("53.5e93"));
        assertTrue(isNumber("-123.456e789"));
    }

    @Test
    public void testInvalid() {
        assertFalse(isNumber("."));
        assertFalse(isNumber("abc"));
        assertFalse(isNumber("1a"));
        assertFalse(isNumber("1e"));
        assertFalse(isNumber("e3"));
        assertFalse(isNumber("99e2.5"));
        assertFalse(isNumber("--6"));
        assertFalse(isNumber("-+3"));
        assertFalse(isNumber("95a54e53"));
    }
}
