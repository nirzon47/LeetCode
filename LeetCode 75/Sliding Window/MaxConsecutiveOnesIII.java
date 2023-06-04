// https://leetcode.com/problems/max-consecutive-ones-iii/

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, zeros = 0;
        int len = nums.length;

        // Implementing two pointers on sliding window
        while (end < len) {
            // If the last element of the current window is 0, add 1 to zeros.
            if (nums[end] == 0) {
                zeros++;
            }
            // Increase window's size for further calculations
            end++;
            // If zeros is more than k, we have exceeded the limit of how big our window can get,
            // so we shift the first pointer by 1
            if (zeros > k) {
                // If the starting pointer was 0, we can deduct the flipped zero for using it in the next window
                if (nums[start] == 0)
                    zeros--;
                start++;
            }
        }

        // The difference between the end pointer and the starting pointer (the size of the window) is our result
        return end - start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(longestOnes(nums, k));
    }
}
