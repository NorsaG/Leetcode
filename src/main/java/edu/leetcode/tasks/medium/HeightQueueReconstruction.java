package edu.leetcode.tasks.medium;

import java.util.*;

public class HeightQueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        for (int[] p: people) {
            ordered.add(p[1], p);
        }

        return ordered.toArray(new int[people.length][2]);
    }


    public static void main(String[] args) {
        HeightQueueReconstruction p = new HeightQueueReconstruction();
        int[][] people1 = new int[6][2];
        people1[0] = new int[]{6, 0};
        people1[1] = new int[]{5, 0};
        people1[2] = new int[]{4, 0};
        people1[3] = new int[]{3, 2};
        people1[4] = new int[]{2, 2};
        people1[5] = new int[]{1, 4};
        System.out.println(toStr(p.reconstructQueue(people1)));

        int[][] people2 = new int[6][2];
        people2[0] = new int[]{7, 0};
        people2[1] = new int[]{4, 4};
        people2[2] = new int[]{7, 1};
        people2[3] = new int[]{5, 0};
        people2[4] = new int[]{6, 1};
        people2[5] = new int[]{5, 2};
        System.out.println(toStr(p.reconstructQueue(people2)));

        int[][] people3 = new int[10][2];
        people3[0] = new int[]{2,4};
        people3[1] = new int[]{3,4};
        people3[2] = new int[]{9,0};
        people3[3] = new int[]{0,6};
        people3[4] = new int[]{7,1};
        people3[5] = new int[]{6,0};
        people3[6] = new int[]{7,3};
        people3[7] = new int[]{2,5};
        people3[8] = new int[]{1,1};
        people3[9] = new int[]{8,0};

        System.out.println(toStr(p.reconstructQueue(people3)));
    }

    private static String toStr(int[][] reconstructQueue) {
        StringJoiner sj = new StringJoiner(",");

        for (int[] i : reconstructQueue) {
            sj.add(Arrays.toString(i));
        }
        return sj.toString();
    }

}
