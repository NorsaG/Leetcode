package edu.leetcode.tasks.easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        int flag = 0;
        int i1 = 0;
        int i2 = 0;

        for (int i = nums.length - 1; i >= 2; i--) {
            i1 = i - 1;
            i2 = 0;


            while (i1 > i2) {
                int tmp = getPerimeter(nums[i], nums[i1], nums[i2]);
                flag = tmp;
                if (tmp > res) {
                    res = tmp;
                }

                if (res > flag)
                    return res;
                i2++;
            }
        }

        return res;
    }

    private int getPerimeter(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return 0;
        }
        return a + b + c;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle t = new LargestPerimeterTriangle();
        System.out.println(t.largestPerimeter(new int[]{2, 1, 2}));
    }
}
