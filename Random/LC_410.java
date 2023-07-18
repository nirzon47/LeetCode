// https://leetcode.com/problems/split-array-largest-sum/

public class LC_410 {
    public static boolean isSplit(int[] nums, int limit, int k) {
        // We check if the number of subarrays formed with the limit is less than or equal to k.
        // If it is, this is a potential answer.
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > limit) {
                count++;
                sum = num;
            }
        }

        return count <= k;
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        // The lowest our result can be is the maximum element since at least some subarray has to keep it.
        // The highest our result can be is the sum of all elements in case we can only make one subarray.
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Applying binary search on the result range
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // If the function returns true, we store the potential answer and further decrease our limit
            if (isSplit(nums, mid, k)) {
                res = mid;
                right = mid - 1;
            } else {
                // Else we increase our limit
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        System.out.println(splitArray(nums, k));
    }
}
