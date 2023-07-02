// https://leetcode.com/problems/spiral-matrix/

import java.util.*;

public class LC_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();

        while (left <= right && top <= bottom) {
            // First printing the upper column, and since we are done with it, we remove it
            // from our consideration by increasing the top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Printing the right edge, and removing it from our
            // consideration by decreasing the right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // Extra clause added because of rectangle matrices
            // Rest of the code is similar
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            bottom--;

            // Extra clause because of rectangle matrices
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(spiralOrder(matrix));
    }
}