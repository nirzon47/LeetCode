// https://leetcode.com/problems/sort-array-by-parity/

import java.util.*;

public class LC_905 {

    public static int[] sortArrayByParity(int[] nums) {
        int i = 0, len = nums.length;

        // Taking a pointer from the start that moves one position whenever we encounter an even number
        // Basically shifting all the even numbers to the beginning
        for (int j = 0; j < len; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        // The order of the result doesn't matter
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};

        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
}
