// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

public class LC_1351 {

    public static int countNegatives(int[][] grid) {
        int count = 0;
        // Starting from the bottom left corner
        int row = grid.length - 1, col = 0;
        int rLen = grid.length, cLen = grid[0].length;

        while (row >= 0 && col < grid[0].length) {
            // If the current position is negative, that means,
            // all the elements from that position is negative. So we add the rest and go to the row above
            if (grid[row][col] < 0) {
                count += cLen - col;
                row--;
            } else {
                // If the current position is not negative, we move our column pointer to the right
                col++;
            }
        }

        return count;
    }
    // public static int countNegatives(int[][] grid) {
    //     int count = 0;
    //     // Getting the length of the columns
    //     int c = grid[0].length;

    //     for (int[] ints : grid) {
    //         // Using binary search to get the point when we start seeing negative numbers
    //         int left = 0, right = c - 1;

    //         while (left <= right) {
    //             int mid = left + (right - left) / 2;
    //             // The array is sorted in descending order
    //             if (ints[mid] >= 0) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid - 1;
    //             }
    //         }

    //         count += c - left;
    //     }

    //     return count;
    // }

    public static void main(String[] args) {
        int[][] matrix = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        System.out.println(countNegatives(matrix));
    }
}
