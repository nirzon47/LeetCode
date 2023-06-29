// https://leetcode.com/problems/convert-1d-array-into-2d-array/

import java.util.*;

public class LC_2022 {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        // If the resultant array is impossible to make, we return an empty 2D array
        if (m * n != original.length) {
            return new int[][]{};
        }

        // Make the 2D array
        int[][] matrix = new int[m][n];

        for (int j = 0; j < m; j++) {
            // Using Arrays.copyOfRange() to put the elements equal to the column size
            matrix[j] = Arrays.copyOfRange(original, j * n, j * n + n);
            /*

            O(n^2)

            for (int k = 0; k < n; k++) {
                matrix[j][k] = original[i++];
            }
             */
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int m = 2, n = 2;

        int[][] res = construct2DArray(original, m, n);

        for (int[] r : res) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }
}
