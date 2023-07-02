// https://leetcode.com/problems/find-target-indices-after-sorting-array/

import java.util.*;

public class LC_2089 {
    public static List<Integer> targetIndices(int[] nums, int target) {
        // Just sort the array and find the indexes that matches the target
        // and them in our res array
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        System.out.println(targetIndices(nums, target));
    }
}