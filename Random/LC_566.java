// https://leetcode.com/problems/reshape-the-matrix/

public class LC_566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // Making the result array and extracting the length of the rows and columns
        int[][] res = new int[r][c];
        int m = mat.length;
        int n = mat[0].length;

        // If we cannot form the array, we just return the array we gor
        if (m * n != r * c) {
            return mat;
        }

        // We traverse the entire array using the division and modulus operators
        for (int i = 0; i < r * c; i++) {
            // We get the row by dividing with the column,
            // and we get the column by using the modulus operator by column
            res[i / c][i % c] = mat[i / n][i % n];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);

        for (int[] row : grid) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
