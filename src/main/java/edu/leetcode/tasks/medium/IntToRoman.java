package edu.leetcode.tasks.medium;

/**
 * 2022-08-01
 */
public class IntToRoman {

    public String intToRoman(int num) {
        String strNum = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        for (int i = strNum.length() - 1; i >= 0; i--) {
            result.insert(0, getLetter(strNum.length() - i, Integer.parseInt(String.valueOf(strNum.charAt(i)))));
        }
        return result.toString();
    }

    private String getLetter(int i, int c) {
        switch (c) {
            case 0:
                return "";
            case 1:
                switch (i) {
                    case 1:
                        return "I";
                    case 2:
                        return "X";
                    case 3:
                        return "C";
                    case 4:
                        return "M";
                }
            case 2:
                switch (i) {
                    case 1:
                        return "II";
                    case 2:
                        return "XX";
                    case 3:
                        return "CC";
                    case 4:
                        return "MM";
                }
            case 3:
                switch (i) {
                    case 1:
                        return "III";
                    case 2:
                        return "XXX";
                    case 3:
                        return "CCC";
                    case 4:
                        return "MMM";
                }
            case 4:
                switch (i) {
                    case 1:
                        return "IV";
                    case 2:
                        return "XL";
                    case 3:
                        return "CD";
                }
            case 5:
                switch (i) {
                    case 1:
                        return "V";
                    case 2:
                        return "L";
                    case 3:
                        return "D";
                }
            case 6:
                switch (i) {
                    case 1:
                        return "VI";
                    case 2:
                        return "LX";
                    case 3:
                        return "DC";
                }
            case 7:
                switch (i) {
                    case 1:
                        return "VII";
                    case 2:
                        return "LXX";
                    case 3:
                        return "DCC";
                }
            case 8:
                switch (i) {
                    case 1:
                        return "VIII";
                    case 2:
                        return "LXXX";
                    case 3:
                        return "DCCC";
                }
            case 9:
                switch (i) {
                    case 1:
                        return "IX";
                    case 2:
                        return "XC";
                    case 3:
                        return "CM";
                }
        }


        return "";
    }

    public static void main(String[] args) {
        IntToRoman converter = new IntToRoman();
        System.out.println(converter.intToRoman(3));
        System.out.println(converter.intToRoman(58));
        System.out.println(converter.intToRoman(1994));
    }
}
