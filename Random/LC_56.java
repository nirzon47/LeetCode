// https://leetcode.com/problems/merge-intervals/

import java.util.*;

public class LC_56 {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // If the array has a size less than or equal to 1, we return the array as is
        if (n <= 1) {
            return intervals;
        }

        // We sort the array in regard to the first element in each interval
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // Making a new result array
        List<int[]> res = new ArrayList<>();
        // Storing the previous interval in an array
        int[] newInterval = intervals[0];

        for (int[] interval : intervals) {
            // If the second array's first element ins less than or equal to the previous array's second element,
            // we keep the maximum second element of the interval
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // If we are here, it means we have to take a new interval pair,
                // we also add the previous arrays in the result array
                res.add(newInterval);
                newInterval = interval;
            }
        }

        // The last array does not get entered, so we are doing it separately
        res.add(newInterval);
        
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

        int[][] res = merge(intervals);

        for (int[] rows : res) {
            for (int e : rows) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
