// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

import java.util.*;

public class LC_1877 {
    public static int minPairSum(int[] nums) {
        // Sorting the array and using 2 pointers on it
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        int res = 0;

        while (left < right) {
            // Our minimized maximum pair has to be the largest with the smallest
            // We take the maximum sum like this and get our answer
            res = Math.max(nums[left] + nums[right], res);

            left++;
            right--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 3};

        System.out.println(minPairSum(nums));
    }
}
