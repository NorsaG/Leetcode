package edu.leetcode.tasks.easy;

/**
 * 2022-08-03
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            if ((n & 1) == 1) {
                res += 1;
            }
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {

        ReverseBits rb = new ReverseBits();
        System.out.println("input:" + 0b00000010100101000001111010011100);
        System.out.println("output:" + 0b00111001011110000010100101000000);
        System.out.printf("%32s%n", Integer.toBinaryString(0b00000010100101000001111010011100));
        System.out.printf("%32s%n", Integer.toBinaryString(rb.reverseBits(0b00000010100101000001111010011100)));
        System.out.println(rb.reverseBits(0b00000010100101000001111010011100));

        System.out.println("input:" + 0b11111111111111111111111111111101);
        System.out.println("output:" + 0b10111111111111111111111111111111);
        System.out.printf("%32s%n", Integer.toBinaryString(0b11111111111111111111111111111101));
        System.out.printf("%32s%n", Integer.toBinaryString(rb.reverseBits(0b11111111111111111111111111111101)));
        System.out.println(rb.reverseBits(0b11111111111111111111111111111101));
    }
}
