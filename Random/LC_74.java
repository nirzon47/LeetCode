// https://leetcode.com/problems/search-a-2d-matrix/

public class LC_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Starting our position from the top right corner
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // If our current element is larger than the target, we need to decrease our column pointer
                col--;
            } else {
                // If our current element is smaller, we need to increase our row pointer
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}
