package edu.leetcode.tasks.easy;

public class RomanNumber {

    public int romanToInt(String s) {
        int returnNumber = 0;
        int pos = 0;

        final int length = s.length();
        while (pos < length) {
            char c = s.charAt(pos);
            char next = '\u0000';
            if (pos + 1 < s.length()) {
                next = s.charAt(pos + 1);
            }
            switch (c) {
                case 'I': {
                    if (next == 'V') {
                        returnNumber += 4;
                        pos += 2;
                        break;
                    } else if (next == 'X') {
                        returnNumber += 9;
                        pos += 2;
                        break;
                    } else {
                        returnNumber += 1;
                        pos += 1;
                        break;
                    }
                }
                case 'V': {
                    returnNumber += 5;
                    pos += 1;
                    break;
                }
                case 'X':
                    if (next == 'L') {
                        returnNumber += 40;
                        pos += 2;
                        break;
                    } else if (next == 'C') {
                        returnNumber += 90;
                        pos += 2;
                        break;
                    } else {
                        returnNumber += 10;
                        pos += 1;
                        break;
                    }
                case 'L': {
                    returnNumber += 50;
                    pos += 1;
                    break;
                }
                case 'C':
                    if (next == 'D') {
                        returnNumber += 400;
                        pos += 2;
                        break;
                    } else if (next == 'M') {
                        returnNumber += 900;
                        pos += 2;
                        break;
                    } else {
                        returnNumber += 100;
                        pos += 1;
                        break;
                    }
                case 'D': {
                    returnNumber += 500;
                    pos += 1;
                    break;
                }
                case 'M': {
                    returnNumber += 1000;
                    pos += 1;
                    break;
                }
            }
        }
        return returnNumber;
    }


    public static void main(String[] args) {
        System.out.println(new RomanNumber().romanToInt("III"));
        System.out.println(new RomanNumber().romanToInt("XIII"));
        System.out.println(new RomanNumber().romanToInt("VIII"));
        System.out.println(new RomanNumber().romanToInt("IV"));
        System.out.println(new RomanNumber().romanToInt("MIII"));
        System.out.println(new RomanNumber().romanToInt("LVIII"));
        System.out.println(new RomanNumber().romanToInt("MCMXCIV"));
    }
}
