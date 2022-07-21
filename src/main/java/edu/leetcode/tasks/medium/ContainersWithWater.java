package edu.leetcode.tasks.medium;

import java.util.Random;

public class ContainersWithWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxVolume = 0;

        while (left < right) {
            int hL = height[left];
            int hR = height[right];
            int currentVolume = Math.min(hL, hR) * (right - left);
            maxVolume = Math.max(maxVolume, currentVolume);
            if (hL > hR) {
                right--;
            } else {
                left++;
            }
        }
        return maxVolume;

    }


    public static void main(String[] args) {
        ContainersWithWater containersWithWater = new ContainersWithWater();
        System.out.println(containersWithWater.maxArea(new int[]{1, 2, 1, 1, 1, 2, 1, 3, 1, 1}));

        int size = 65536;
        int[] mas = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            mas[i] = r.nextInt(900) + 100;
        }
        System.out.println(containersWithWater.maxArea(mas));
    }
}
