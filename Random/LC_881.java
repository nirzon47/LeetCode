// https://leetcode.com/problems/boats-to-save-people/

import java.util.*;

public class LC_881 {
    public static int numRescueBoats(int[] people, int limit) {
        // We sort the array so, we can do a modified binary search
        Arrays.sort(people);
        int left = 0, right = people.length - 1, count = 0;

        while (left <= right) {
            // If both the pointers add up to being less than or equal to our
            // limit, we increase our lower bound to the next
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // In case we can only take one, we get the largest value out of the way
            right--;

            // We are guaranteed to take at last one person every iteration
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(nums, limit));
    }
}
