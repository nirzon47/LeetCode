// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.*;

public class LC_442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // We are mapping the numbers to their indexes
            int index = Math.abs(nums[i]) - 1;

            // If the number becomes negative once, we add its parallel index
            if (nums[index] < 0) {
                res.add(index + 1);
            }

            // Unconditionally making the numbers negative
            nums[index] *= -1;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDuplicates(nums));
    }
}
