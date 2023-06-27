// https://leetcode.com/problems/contains-duplicate/

import java.util.*;

public class LC_217 {
    public static boolean containsDuplicate(int[] nums) {
        /*
        T: O(n)
        S: O(n)
         */

        // If there is an element that is already in the set, we return true
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;

        /*

        T: O(nlogn)
        S: O(1)

        Arrays.sort(nums);
        If there is an equal element in the index before it, we return true
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;

        */
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums));
    }
}
