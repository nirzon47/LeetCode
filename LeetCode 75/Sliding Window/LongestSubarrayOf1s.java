// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

public class LongestSubarrayOf1s {

    public static int longestSubarray(int[] nums) {
        // Using sliding window with 2 pointers
        int start = 0, end = 0, zeroCount = 0, len = nums.length;

        // If end pointer has a zero, increases zeroCount. If zeroCount exceeds 1,
        // the starting pointer has to be shifted until the starting pointer
        // does not point to a zero. This was done in one pass sliding window,
        // however it can be done with an additional loop as well.
        for (; end < len; end++) {
            if (nums[end] == 0) zeroCount++;
            if (zeroCount > 1) {
                if (nums[start] == 0)
                    zeroCount--;
                start++;
            }
        }

        // Returns the window - 1
        return end - start - 1;

        /* 2ms solution
        int delCount = 0, maxCount = 0, start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                delCount++;
            }
            while (delCount > 1) {
                if (nums[start] == 0) {
                    delCount--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, i - start);
        }

        return maxCount;
         */
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};

        System.out.println(longestSubarray(nums));
    }
}
