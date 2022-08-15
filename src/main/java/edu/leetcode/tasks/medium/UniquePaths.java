package edu.leetcode.tasks.medium;

/**
 * 2022-08-01
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for (int i = 1; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            matrix[0][j] = 1;
        }
        int i = 1;
        int j = 1;
        while (i < m && j < n) {
            for (int l = i; l < n; l++) {
                matrix[j][l] = matrix[j][l - 1] + matrix[j - 1][l];
            }
            for (int k = j; k < m; k++) {
                matrix[k][i] = matrix[k - 1][i] + matrix[k][i - 1];
            }
            i++;
            j++;
        }

        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths p = new UniquePaths();
        System.out.println(p.uniquePaths(3, 7));
        System.out.println(p.uniquePaths(3, 2));
        System.out.println(p.uniquePaths(2, 3));
        System.out.println(p.uniquePaths(1,1));
    }
}
