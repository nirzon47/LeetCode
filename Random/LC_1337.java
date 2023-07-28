// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.*;

public class LC_1337 {
    public static int binarySearch(int[] nums, int right) {
        int left = 0, res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == 0) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }

        return res + 1;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        // Making a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Using binary search to find the number of 1s in the row matrix
        for (int i = 0; i < m; i++) {
            int strength = binarySearch(mat[i], n - 1);
            // Sending the values of both the index and the strength in a single value, so it sorts easily
            pq.offer(strength * 10000 + i);
        }

        int[] res = new int[k];

        // Inserting the index in the result array by extracting the index from the value
        int i = 0;
        while (i < k) {
            res[i++] = pq.poll() % 10000;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;

        System.out.println(Arrays.toString(kWeakestRows(matrix, k)));
    }
}
