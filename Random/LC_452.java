// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.*;

public class LC_452 {
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;

        // Sorting the points according to their second index
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        // Starting count with 1 because we are already skipping the first point
        int prev = points[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            // If the previous element's 2nd index is greater than or equal to the current element's first index,
            // there is an overlap, and we can just use one arrow to destroy both the balloons, so we skip counting for this one
            if (prev >= points[i][0]) {
                continue;
            }
            // Otherwise, we increase our arrow count and track new prev
            count++;
            prev = points[i][1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        System.out.println(findMinArrowShots(points));
    }
}
