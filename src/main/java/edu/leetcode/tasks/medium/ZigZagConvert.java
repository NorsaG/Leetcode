package edu.leetcode.tasks.medium;

public class ZigZagConvert {

    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1)
            return s;

        StringBuilder[] sbs = new StringBuilder[numRows];

        int index = 0;
        boolean isMoveDown = false;
        for (char c : s.toCharArray()) {
            if (sbs[index] == null)
                sbs[index] = new StringBuilder();
            sbs[index].append(c);

            if (index == (numRows-1) || index == 0)
                isMoveDown = !isMoveDown;
            index += isMoveDown ? 1 : -1;

        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            sb.append(sbs[j].toString());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new ZigZagConvert().convert("PAYPALISHIRING", 4));
        System.out.println(new ZigZagConvert().convert("A", 4));
        System.out.println(new ZigZagConvert().convert("ABC", 1));
        System.out.println(new ZigZagConvert().convert("ABC", 2));
        System.out.println(new ZigZagConvert().convert("ABCD", 2));
        System.out.println(new ZigZagConvert().convert("ABCDE", 2));
        System.out.println(new ZigZagConvert().convert("ABCDE", 3));
        System.out.println(new ZigZagConvert().convert("PAYPALISHIRING", 4));
    }
}
