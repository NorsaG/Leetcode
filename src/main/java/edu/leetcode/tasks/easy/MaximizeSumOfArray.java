package edu.leetcode.tasks.easy;

import java.util.Arrays;

public class MaximizeSumOfArray {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] copyArray = Arrays.copyOf(A, A.length);

        Arrays.sort(copyArray);
        for (int i = 0; i < K; i++) {
            if (copyArray[0] == 0)
                break;
            copyArray[0] = -copyArray[0];
            Arrays.sort(copyArray);
        }
        return calcSum(copyArray);
    }

    private int calcSum(int[] arr) {
        int res = 0;
        for (Integer i : arr) {
            res += i;
        }
        return res;
    }
}
