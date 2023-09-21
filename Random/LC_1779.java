// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

public class LC_1779 {
    public static int nearestValidPoint(int x1, int y1, int[][] points) {
        // Taking the fallback value inside our result
        // Also taking a min value to compare later
        int idx = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            // Extracting the points
            int x2 = points[i][0];
            int y2 = points[i][1];

            // If any of the ordinates do not match, we move on
            if (!(x1 == x2 || y1 == y2)) {
                continue;
            }

            // Otherwise, we calculate the Manhattan distance
            int temp = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            // If it is the smallest distance, we store its index and make it our new min for future comparisons
            if (temp < min) {
                min = temp;
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
    }
}
