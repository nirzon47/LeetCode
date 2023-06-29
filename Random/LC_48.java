// https://leetcode.com/problems/rotate-image/

public class LC_48 {
    public static void transpose(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseColumn(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void rotate(int[][] matrix) {
        // Rotating the matrix by 90 degrees
        int n = matrix.length;

        // First we transpose
        transpose(matrix, n);
        // Then we reverse the columns
        reverseColumn(matrix, n);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);

        for (int[] r : matrix) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
