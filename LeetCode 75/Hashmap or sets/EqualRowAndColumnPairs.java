// https://leetcode.com/problems/equal-row-and-column-pairs/

import java.util.*;

public class EqualRowAndColumnPairs {

    public static int equalPairs(int[][] grid) {
        // Creating two hashmaps to count the number of occurrences of the columns and rows
        HashMap<String, Integer> rowCount = new HashMap<>();
        HashMap<String, Integer> columnCount = new HashMap<>();
        int len = grid.length, count = 0;

        // StringBuilders to form the rows and columns of the grid
        StringBuilder row = new StringBuilder();
        StringBuilder column = new StringBuilder();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // Forming the rows and columns and then storing it in R and C for using it as a key
                column.append(grid[i][j]).append(',');
                row.append(grid[j][i]).append(',');
            }
            String R = row.toString();
            String C = column.toString();

            // If a value associated with the key of the row and column already exists,
            // add 1 to that or add 1 to default value 0.
            columnCount.put(R, columnCount.getOrDefault(R, 0) + 1);
            rowCount.put(C, rowCount.getOrDefault(C, 0) + 1);

            // Resetting the StringBuilder
            row.setLength(0);
            column.setLength(0);
        }

        for (String i : columnCount.keySet()) {
            // If there is a match for the rows and column keys, add the product of their values
            if (rowCount.containsKey(i)) {
                count += columnCount.get(i) * rowCount.get(i);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {13, 13},
                {13, 13}
        };

        System.out.println(equalPairs(grid));
    }
}
