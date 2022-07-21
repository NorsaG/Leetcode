package edu.leetcode.tasks.easy;

/**
 * 2022-05-13
 */
public class AverageSalary {
    public double average(int[] salary) {
        int count = 0;
        double sum = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int s : salary) {

            if (s > max)
                max = s;

            if (s < min)
                min = s;

            sum+=s;
            count++;
        }
        return (sum - min - max) / (count - 2);
    }

    public static void main(String[] args) {
        AverageSalary s = new AverageSalary();
        System.out.println(s.average(new int[]{4000, 3000, 1000, 2000}));
        System.out.println(s.average(new int[]{3000, 1000, 2000}));
    }
}
