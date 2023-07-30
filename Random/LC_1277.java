// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class LC_1277 {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        /*
         * Intuition:
         * If we come across a square, we check its upper element, left element, and the upper-left diagonal,
         * if all of them are 1s, then we have a square, so we mark it as the size of the square -> 2
         * Then we find the minimum of all the values like this in case we are on a 1
         */

        // Taking the individual square counts from row 1 and column 1 since
        // we will start our checks from row 2, column 2
        for (int i = 0; i < n; i++) {
            res += matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            res += matrix[i][0];
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                // If the current element is 0, it cannot have any squares
                if (matrix[r][c] == 1) {
                    // Find the minimum of all the three elements left, up, and upper-left diagonal
                    int squares = Math.min(matrix[r][c - 1],
                            Math.min(matrix[r - 1][c], matrix[r - 1][c - 1]))
                            + 1;
                    matrix[r][c] = squares; // Marking the size
                    res += squares;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
    }
}
