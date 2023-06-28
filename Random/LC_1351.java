// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

public class LC_1351 {
    public static int countNegatives(int[][] grid) {
        int count = 0;
        // Getting the length of the columns
        int c = grid[0].length;

        for (int[] ints : grid) {
            // Using binary search to get the point when we start seeing negative numbers
            int left = 0, right = c - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                // The array is sorted in descending order
                if (ints[mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            count += c - left;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        System.out.println(countNegatives(matrix));
    }
}
