// https://leetcode.com/problems/3sum/description/

import java.util.*;

public class LC_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Initialize result list and sort array
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;

        // A kind of three-pointer approach, left starts from 0
        // 'mid' starts from left + 1 and right starts from the end
        for (int left = 0; left < len - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) // managing duplicates
                continue;
            for (int mid = left + 1, right = len - 1; mid < right; ) {
                int sum = nums[left] + nums[mid] + nums[right];
                // If our sum is 0, we can change our pointers and manage duplicates
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;
                    while (nums[mid] == nums[mid - 1] && mid < right) mid++; // managing duplicates
                    while (nums[right] == nums[right + 1] && mid < right) right--; // managing duplicates
                }
                // If our sum is higher, we must decrease our upper bound
                else if (sum > 0) {
                    right--;
                }
                // If our sum is lower, we increase our lower bound
                else {
                    mid++;
                }
            }
        }
        
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ArrayList<>(threeSum(nums));
        System.out.println(res);
    }
}
