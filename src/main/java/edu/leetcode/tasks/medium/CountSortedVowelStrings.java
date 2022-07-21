package edu.leetcode.tasks.medium;

/**
 * 2022-05-13
 */
public class CountSortedVowelStrings {
    private static final int VOWEL_COUNT = 5;

    public int countVowelStrings(int n) {
        if (n == 1) {
            return VOWEL_COUNT;
        }
        int[][] counter = new int[n][VOWEL_COUNT];

        for (int i = 0; i < VOWEL_COUNT; i++) {
            counter[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = VOWEL_COUNT - 1; j >= 0; j--) {
                int tmp = getPreviousSum(counter, i, j);
                counter[i][j] = tmp;
            }
        }
        int sum = 0;
        for (int i = 0; i < VOWEL_COUNT; i++) {
            sum += counter[n - 1][i];
        }
        return sum;
    }

    private int getPreviousSum(int[][] counter, int currentRow, int currentIndex) {
        int sum = 0;
        int[] row = counter[currentRow - 1];
        for (int i = currentIndex; i < VOWEL_COUNT; i++) {
            sum += row[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        CountSortedVowelStrings c = new CountSortedVowelStrings();
        System.out.println(c.countVowelStrings(33));
    }
    //  a  e  i  o  u

    //  1  1  1  1  1
    //  5  4  3  2  1
    // 15 10  6  3  1

//    iii iio
//    iiu ioo
//    iou iuu
//
//    eee eei
//    eeo eeu
//    eii eio
//    eiu
//    eoo eou
//    euu
//
//
//    aaa aae
//    aai aao
//    aaau
//    aee aei
//    aeo aeu
//    aii aio
//    aiu
//    aoo aou
//    auu
}
