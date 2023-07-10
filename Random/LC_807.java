// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

public class LC_807 {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        /* Intuition:
         * We take the maximum of every row and column and store it in our arrays
         * The maximum skyline will be the minimum of the maximum rows and columns
         * We take the minimum and then subtract the current grid and add it to our result
         * since that will be the increase in height we need
         */
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                // Row is i and column is j because of the way columns and rows traverse
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(row[i], col[j]) - grid[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }
}
