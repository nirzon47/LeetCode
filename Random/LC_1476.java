// https://leetcode.com/problems/subrectangle-queries/

public class LC_1476 {
    class SubrectangleQueries {
        // Make a global matrix
        int[][] matrix;

        public SubrectangleQueries(int[][] rectangle) {
            // Take the 2D array passed in the function in our global variable
            matrix = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            // Updated the rows and columns in the range
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    matrix[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            // Returning our new matrix
            return matrix[row][col];
        }
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */

