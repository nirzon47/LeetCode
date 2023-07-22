// https://leetcode.com/problems/squares-of-a-sorted-array/

import java.util.*;

public class LC_977 {
    public static int[] sortedSquares(int[] nums) {
        /*
         * We are using 2 pointers starting at either end;
         * The issue is with the negative numbers, if the negative number has a square bigger than the largest
         * positive number, it will go after the largest element.
         * So, we compare our smallest number with the largest number and check their absolute values,
         * and we add the largest value in the right pointer, and the smallest in the left pointer
         */
        int left = 0, right = nums.length - 1;
        int[] res = new int[right + 1];

        for (int i = right; i >= 0; i--) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[i] = nums[right] * nums[right];
                right--;
            } else {
                res[i] = nums[left] * nums[left];
                left++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
