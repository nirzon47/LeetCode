// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.*;

public class LC_167 {
    public static int[] twoSum(int[] numbers, int target) {
        // Basic two pointer approach
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];

        while (left < right) {
            // If our sum of the two ends is the target, we return it
            // If it is larger, we reduce our right
            // If it is smaller, we increase our left
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
