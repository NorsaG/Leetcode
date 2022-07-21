package edu.leetcode.tasks.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3)
            return results;

        Arrays.sort(nums);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int remainder = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == remainder) {
                    String newS = nums[i] + "," + nums[left] + "," + nums[right];
                    if (!map.containsKey(newS)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                        results.add(temp);
                        map.put(newS, i);
                    }
                }
                if (nums[left] + nums[right] < remainder) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }


    public static void main(String[] args) {
        int[] mas = new int[]{3, 0, -2, -1, 1, 2};

        ThreeSum s = new ThreeSum();
        System.out.println(s.threeSum(mas));
    }

}
