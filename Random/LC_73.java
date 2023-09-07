// https://leetcode.com/problems/set-matrix-zeroes/

public class LC_73 {
    public static void setZeroes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean rowZero = false, colZero = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Checking for the first row and column first, if there is any 0 there,
                // we take that information and correspond all the other rows and columns
                // and make changes accordingly
                if (grid[i][j] == 0) {
                    if (i == 0) {
                        // If the element is in the first row, we set our row's flag to true
                        rowZero = true;
                    }
                    if (j == 0) {
                        // If the element is in the first column, we set our column's flag to true
                        colZero = true;
                    }

                    // Sets the first row to zero if the current element is 0
                    grid[0][j] = 0;
                    // Sets the first column to zero if the current element is 0
                    grid[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Since we are mapping our condition to make an element to 0 by the first row and column,
                // that is what we check and if either of them is zero, we have to set the current element to 0
                if (grid[i][0] == 0 || grid[0][j] == 0) {
                    grid[i][j] = 0;
                }
            }
        }

        // These are for changing the entire row and column to 0 if any of them are 0
        if (rowZero) {
            for (int i = 0; i < n; i++) {
                grid[0][i] = 0;
            }
        }

        if (colZero) {
            for (int i = 0; i < m; i++) {
                grid[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes(grid);

        for (int[] rows : grid) {
            for (int e : rows) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
