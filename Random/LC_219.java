// https://leetcode.com/problems/contains-duplicate-ii/description/

import java.util.*;

public class LC_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
