// https://leetcode.com/problems/4sum/

import java.util.*;

public class LC_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        // Sorting the array to do the 2-pointers technique
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        /*
         * Intuition:
         * We are freezing 2 pointers
         * Then taking 2 more pointers that start after the 2nd pointer
         * Now we traverse the array from both sides using the 3rd and 4th pointer
         * Then add them at each step to check if we have the target sum or not
         */

        for (int i = 0; i < n; i++) {
            // Checking if the last value is the same as this value.
            // We move on to the next pointer in this case.
            // If 'i' is 0, there is nothing behind it, so we are also skipping if 'i' is 0
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // j starts after i's pointer
            for (int j = i + 1; j < n; j++) {
                // We also check for duplicates here
                // j cannot be i + 1, because that's our starting value
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Taking a new target by subtracting both nums[i] and nums[j],
                // we need to make sure that the sum of 3rd and 4th pointers is this new target
                long t = (long) target - nums[i] - nums[j];

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    if (sum == t) {
                        // Adding all the values if the sum of the pointers is equal to the new target
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Moving our pointers for potentially more matches
                        left++;
                        right--;

                        // Removing duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > t) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};

        System.out.println(fourSum(nums, 0));
    }
}
