// https://leetcode.com/problems/maximum-subarray/

public class LC_53 {

    public static int maxSubArray(int[] nums) {
        // Using Kadane's algorithm
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
