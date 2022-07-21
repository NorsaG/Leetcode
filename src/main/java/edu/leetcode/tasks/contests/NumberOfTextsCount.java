package edu.leetcode.tasks.contests;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 2022-05-12
 */
public class NumberOfTextsCount {
    private static final Map<Character, Integer> mapping = new HashMap<Character, Integer>() {{
        put('2', 3);
        put('3', 3);
        put('4', 3);
        put('5', 3);
        put('6', 3);
        put('7', 4);
        put('8', 3);
        put('9', 4);
    }};

    private static final Map<Integer, BigInteger> factorial = new HashMap<>();

    public static BigInteger fact(int n) {
        if (factorial.containsKey(n))
            return factorial.get(n);

        if (n == 1)
            return BigInteger.ONE;

        BigInteger result = BigInteger.valueOf(n).multiply(fact(n - 1));
        factorial.put(n, result);
        return result;
    }

    public int countTexts(String pressedKeys) {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println();

        int n = "222222222222222222222222222222222222".length();
        System.out.println(n);
        System.out.println(fact(12));
        System.out.println(Math.pow(3, 12));
    }
}
