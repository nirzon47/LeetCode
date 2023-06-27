// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.*;

public class LC_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        for (int num : nums) {
            // If we already made our number negative, we take the positive of it
            int idx = Math.abs(num);

            // If our number is not negative, we make it negative
            if (nums[idx - 1] > 0) {
                nums[idx - 1] *= -1;
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Add all the positive numbers in our result list
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;

        /*
        This code uses extra space

        int len = nums.length;
        int[] freq = new int[len + 1];
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i < len + 1; i++) {
            if (freq[i] == 0) {
                res.add(i);
            }
        }

        return res;
         */
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDisappearedNumbers(nums));
    }
}
