package edu.leetcode.tasks.easy;

import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MySQRT {

    private static final NavigableMap<Integer, Integer> power = new ConcurrentSkipListMap<>();

    static {
        for (int i = 0; ; i++) {
            long res = (long) i * i;
            if (res > Integer.MAX_VALUE) {
                break;
            }
            power.put((int) res, i);
        }
    }

    public int mySqrt2(int x) {
        Integer result = power.floorEntry(x).getValue();
        return result == null ? 0 : result;
    }

    public int mySqrt(int x) {
        if (x == Integer.MAX_VALUE) x -= 1;

        double x1 = (x + 1) / 2;
        double x2 = 0;
        do {
            x2 = x1;
            x1 = (x1 + x/x2) / 2;
        } while (x2 - x1 > 0);
        return (int)x1;
    }


    public static void main(String[] args) {
        MySQRT sqrt = new MySQRT();
        System.out.println(sqrt.mySqrt(500));
        System.out.println(sqrt.mySqrt(512));
        System.out.println(sqrt.mySqrt(256));
        System.out.println(sqrt.mySqrt(257));
        System.out.println(sqrt.mySqrt(0));
        System.out.println(sqrt.mySqrt(1));
        System.out.println(sqrt.mySqrt(2));
        System.out.println(sqrt.mySqrt(3));
        System.out.println(sqrt.mySqrt(4));
    }
}
