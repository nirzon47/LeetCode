// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

public class LC_128 {
    public static int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        // Adding all the numbers in a set for easier look-ups
        for (int num : nums) {
            set.add(num);
        }

        for (int j : nums) {
            // Each element count as one by themselves, so we start our count at 1
            int count = 1;
            int num = j;

            // If our set contains a number which is just smaller than the current element, we increase our count
            // We also remove it, so we don't get duplicate counting later
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // Reset our number to check if there are elements just bigger than the current element,
            // if it is, we increase the count
            // We also remove it, so we don't get duplicate counting later
            num = j;

            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            // Check for max
            max = Math.max(count, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
