// https://leetcode.com/problems/check-if-matrix-is-x-matrix/

public class LC_2319 {
    public static boolean checkXMatrix(int[][] grid) {
        int len = grid.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // Checking if the current element is a diagonal or not
                if (i == j || i + j == len - 1) {
                    // If any diagonal is 0, the matrix is not an X matrix
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    // If there is a zero outside the diagonals, we do not have an x matrix
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        System.out.println(checkXMatrix(grid));
    }
}