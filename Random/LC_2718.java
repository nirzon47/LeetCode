// https://leetcode.com/problems/sum-of-matrix-after-queries/

import java.util.*;

public class LC_2718 {
    public static long matrixSumQueries(int n, int[][] queries) {
        long res = 0;
        int row = n;
        int col = n;

        Set<Integer> rowSeen = new HashSet<>();
        Set<Integer> colSeen = new HashSet<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            // We take the type, index and val from the array
            int type = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];

            // If the type is equal to 0 -> column operation
            if (type == 0) {
                // We have to check if we have columns to replace and then check
                // if we have already overwritten the indexes by checking in from the set
                if (col <= 0 || colSeen.contains(index)) {
                    continue;
                }

                // If everything is clear, we multiply the remaining column
                // count by the val and add it to the result, and add the index visited in the set
                res += (long) col * val;
                colSeen.add(index);
                // Lastly, we decrease the row by 1 because we blocked one row from future editing
                row--;
            } else { // 1 -> row operation
                // Doing the same checks
                if (row <= 0 || rowSeen.contains(index)) {
                    continue;
                }

                // Same calculations
                res += (long) row * val;
                rowSeen.add(index);
                // Decreasing the col by 1 because we blocked one column from future editing
                col--;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] queries = {{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}};
        int n = 3;

        System.out.println(matrixSumQueries(n, queries));
    }
}
