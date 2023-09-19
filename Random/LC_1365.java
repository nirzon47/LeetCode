// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

import java.util.*;

public class LC_1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        // Making a frequency array that stores the frequency of the elements
        int[] count = new int[101];
        int[] res = new int[len];

        for (int num : nums) {
            count[num]++;
        }

        // Making a count array that holds the prefix sum
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        // Adding the element before the current number as the number of elements smaller than it before it
        for (int i = 0; i < len; i++) {
            // If nums[i] is 0, we put res[i] as 0 because it would be the lowest and the next statement does not
            // handle index out of bounds
            if (nums[i] == 0) {
                res[i] = 0;
                continue;
            }

            res[i] = count[nums[i] - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}
