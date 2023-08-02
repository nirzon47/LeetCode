// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

public class LC_1760 {
    public static boolean isPossible(int[] nums, int mid, int maxOperations) {
        int count = 0;
        // Finding the number of operations, we need to have minimum penalty as the one we just assumed
        for (int num : nums) {
            if (num > mid) {
                // Our number of operations the sum of num / mid (mid = assumed penalty)
                count += num / mid;
                if (num % mid == 0) {
                    // If it is a clean division, we decrease our count by 1 because we don't increase our operations for the first division
                    count--;
                }
            }
        }

        // If the count is less than or equal to maxOperation, this is a potential answer and we return true
        return count <= maxOperations;
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        // Using binary search on the penalty (we need to minimize it),
        // which exists between 1 to the max element in the array
        int right = 0, res = -1;
        for (int num : nums) {
            right = Math.max(num, right);
        }

        int left = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the penalty works out to be within our maxOperations,
            // we decrease it, so we can minimize our answer even further
            if (isPossible(nums, mid, maxOperations)) {
                res = mid;
                right = mid - 1;
            } else {
                // If the penalty makes more operations than we require, we make our value larger to maximize the operations
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
    }
}
