// https://leetcode.com/problems/duplicate-zeros/

import java.util.*;

public class LC_1089 {

    public static void duplicateZeros(int[] nums) {
        int numZeros = 0, len = nums.length;

        // Counting the number of zeros
        for (int num : nums) {
            if (num == 0) numZeros++;
        }

        // Iterating from the end and taking right as the position of
        // the extra zeros + the last index and left as the last index
        for (int left = len - 1; left >= 0; left--) {
            int right = left + numZeros;
            // If the right pointer is less than the length of the array,
            // we put the left index in the right one
            if (right < len) {
                nums[right] = nums[left];
            }
            // If the left index has a 0, we check if the element before the right index is in
            // our limit, if it is, we put the left in that position
            if (nums[left] == 0) {
                if (right - 1 < len) {
                    nums[right - 1] = nums[left];
                }
                // Since we are done handling a zero, we decrement our count
                numZeros--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums);

        System.out.println(Arrays.toString(nums));
    }
}
