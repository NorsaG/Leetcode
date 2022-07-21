package edu.leetcode.tasks.easy;

/**
 * 2022-05-13
 */
public class IntervalOddCounter {
    public int countOdds(int low, int high) {
        if (low == high) {
            return low % 2 == 1 ? 1 : 0;
        }
        boolean oddLow = low % 2 == 1;
        boolean oddHigh = high % 2 == 1;

        int count = 0;
        int distance = high - low;
        if (oddLow) {
            count += distance / 2 + 1;
        } else {
            if (oddHigh) {
                count += distance / 2 + 1;
            } else {
                count += distance / 2 ;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        IntervalOddCounter counter = new IntervalOddCounter();
        System.out.println(counter.countOdds(1, 1));
        System.out.println(counter.countOdds(2, 2));
        System.out.println(counter.countOdds(1, 2));
        System.out.println(counter.countOdds(1, 3));
        System.out.println(counter.countOdds(1, 4));
        System.out.println(counter.countOdds(1, 11));
        System.out.println(counter.countOdds(2, 11));
    }
}
