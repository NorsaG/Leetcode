package edu.leetcode.tasks.easy;

/**
 * 2022-05-28
 */
public class NearestPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < points.length; i++) {
            int distance = getDistance(x, y, points[i]);
            if (distance != -1) {
                if (distance < minDistance) {
                    minDistance = distance;
                    index = i;
                }
            }
        }

        return index;
    }

    private int getDistance(int x, int y, int[] point) {
        if (point[0] == x)
            return Math.abs(y - point[1]);
        if (point[1] == y)
            return Math.abs(x - point[0]);
        return -1;
    }
}
