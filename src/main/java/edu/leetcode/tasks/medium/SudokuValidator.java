package edu.leetcode.tasks.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022-08-01
 */
public class SudokuValidator {
    private static final Set<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        boolean result;

        for (int i = 0; i < 9; i++) {
            result = validateLine(board[i]);
            if (!result) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            result = validateColumn(i, board);
            if (!result) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result = validateBlock(board, i, j);
                if (!result) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validateBlock(char[][] board, int i, int j) {
        set.clear();
        for (int k = 3 * i; k < (3 * i) + 3; k++) {
            for (int l = 3 * j; l < (3 * j) + 3; l++) {
                char c = board[k][l];
                if (c != '.' && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    private boolean validateColumn(int i, char[][] board) {
        set.clear();
        for (char[] ch : board) {
            char c = ch[i];
            if (c != '.' && set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private boolean validateLine(char[] chars) {
        set.clear();
        for (char c : chars) {
            if (c != '.' && set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuValidator validator = new SudokuValidator();
//
        System.out.println(validator.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(validator.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));

        System.out.println(validator.isValidSudoku(new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        System.out.println(validator.isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}}
        ));
    }
}
