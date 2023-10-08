// https://leetcode.com/problems/left-and-right-sum-differences/

import java.util.*;

public class LC_2574 {
    public static int[] leftRightDifference(int[] nums) {
        // Taking two sums that contain the right prefix sum and left prefix sum
        int leftSum = 0;
        int rightSum = 0;
        int n = nums.length;
        int[] res = new int[n];

        // Adding up all numbers in rightSum
        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // Removing the element from left from rightSum
            rightSum -= num;
            // Making the calculation and populating res[]
            res[i] = Math.abs(leftSum - rightSum);
            // Adding the element in rightSum
            leftSum += num;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference(new int[]{10, 4, 8, 3})));
    }
}
