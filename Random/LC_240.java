// https://leetcode.com/problems/search-a-2d-matrix-ii/

public class LC_240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Starting from the upper right corner,
        // If the number is bigger than the target, we go left
        // If the number is smaller than the target, we go down
        // This only works because the columns and the rows are
        // sorted in a special way (check question)
        int row = 0, column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > target) {
                column--;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;

        System.out.println(searchMatrix(matrix, target));
    }
}