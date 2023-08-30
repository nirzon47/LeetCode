// https://leetcode.com/problems/valid-sudoku/

import java.util.*;

public class LC_36 {
    public static boolean isValidSudoku(char[][] board) {
        // Making a set to find the unique occurrences in the rows, columns and the boxes
        Set<String> seen = new HashSet<>();

        // Iterating through the entire array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Extracting the character
                char curr = board[i][j];

                // If the character is a period, '.', we skip it
                if (curr == '.') {
                    continue;
                }

                // We are keying our inputs with specific strings so that if the sudoku is valid, it should not repeat
                // If while adding any of the addition returns false (meaning a similar value already exists),
                // We know that the sudoku is invalid and we return false
                if (!seen.add(curr + " at row " + i) ||
                        !seen.add(curr + " at col " + j) ||
                        !seen.add(curr + " at box " + i / 3 + ", " + j / 3)) {
                    return false;
                }
            }
        }

        // If it goes through all that, we return true
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}}));
    }
}
