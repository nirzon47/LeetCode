// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.*;

public class LC_435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        if (n <= 1) {
            return 0;
        }

        // Sorting the array by the second element of the intervals
        Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));
        int count = 0;
        int prev = 0;

        // If our previous interval's second element is smaller than the current interval's first element
        // We increase our count, meaning there is no overlap, and we keep counting the remaining ones
        // We set the current element as prev
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                count++;
                prev = i;
            }
        }

        // The number of elements needed to be removed is n - 1 - count
        return n - count - 1;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
