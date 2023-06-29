// https://leetcode.com/problems/two-sum/

import java.util.*;

public class LC_1 {
    public static int[] twoSum(int[] nums, int target) {
        // Map stores the value and the index
        Map<Integer, Integer> seen = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            // If there is a value in the map which is equal to target - nums[i], we have found a pairs
            if (seen.containsKey(target - nums[i])) {
                res[0] = seen.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            seen.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
