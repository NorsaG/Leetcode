package edu.leetcode.tasks.hard;


public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return getMedian(nums2);
        } else if (nums2.length == 0) {
            return getMedian(nums1);
        } else {
            int[] mergedArray = new int[nums1.length + nums2.length];
            int count1 = 0, count2 = 0;
            for (int i = 0; i < nums1.length + nums2.length; i++) {
                if (count1 == nums1.length) {
                    mergedArray[i] = nums2[count2];
                    count2++;
                } else if (count2 == nums2.length) {
                    mergedArray[i] = nums1[count1];
                    count1++;
                } else {
                    int n1 = nums1[count1];
                    int n2 = nums2[count2];
                    if (n1 > n2) {
                        mergedArray[i] = n2;
                        count2++;
                    } else {
                        mergedArray[i] = n1;
                        count1++;
                    }
                }
            }
            return getMedian(mergedArray);
        }
    }

    private double getMedian(int[] mergedArray) {
        if (mergedArray.length % 2 == 1) {
            return mergedArray[mergedArray.length / 2];
        } else {
            return (double) (mergedArray[mergedArray.length / 2 - 1] + mergedArray[mergedArray.length / 2]) / 2;
        }
    }
}
