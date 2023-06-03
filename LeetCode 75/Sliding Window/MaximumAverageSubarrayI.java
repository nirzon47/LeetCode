public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        // Using sliding window technique
        // Taking double instead of int takes twice as much time
        int sum = 0, maxSum;
        int len = nums.length;

        // Taking the first set of sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Setting maxSum for future comparisons, initializing the first part of the sliding window
        maxSum = sum;
        int start = 0;

        // Doing the rest of the sliding window algorithm
        for (int i = k; i < len; i++) {
            sum -= nums[start];
            sum += nums[i];
            if (sum > maxSum)
                maxSum = sum;
            // Incrementing it in the first line of this loop makes it 1ms slower
            start++;
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 3, 5, 6, 2, 0, 8, 1, 9};
        int k = 6;

        System.out.println(findMaxAverage(nums, k));
    }
}
