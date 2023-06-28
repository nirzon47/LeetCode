// https://leetcode.com/problems/transpose-matrix/

import java.util.*;

public class LC_867 {
    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        // If the matrix is a square matrix, do in place solution using swaps
        if (r == c) {
            for (int i = 0; i < r; i++) {
                for (int j = i + 1; j < c; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            return matrix;
        } else {
            // Make a new matrix and add it there and just… It's pretty self-explanatory
            int[][] res = new int[c][r];

            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    res[i][j] = matrix[j][i];
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(Arrays.deepToString(transpose(nums)));
    }
}
