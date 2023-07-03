// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

public class LC_2529 {
    public static int bisectLeft(int[] nums, int target) {
        // Binary Search to find the index where 0 or 1 starts
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    public static int maximumCount(int[] nums) {
        int negatives = bisectLeft(nums, 0);
        int positives = nums.length - bisectLeft(nums, 1);

        return Math.max(negatives, positives);
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};

        System.out.println(maximumCount(nums));
    }
}