// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

import java.util.*;

public class LC_1984 {

    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        // Taking two pointers, one that is at the beginning and another that
        // is k distance away from the first one
        int left = 0, right = k - 1;
        int diff, mindiff = Integer.MAX_VALUE;

        // Sorting so we have an easier way of finding the minimum difference
        Arrays.sort(nums);

        // Just finding the difference between the elements at our pointers and
        // checking if they are minimum or not
        for (; right < n; right++, left++) {
            diff = nums[right] - nums[left];
            mindiff = Math.min(mindiff, diff);

        }
        
        return mindiff;

    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;

        System.out.println(minimumDifference(nums, k));

    }
}
