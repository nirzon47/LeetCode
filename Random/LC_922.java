//https://leetcode.com/problems/sort-array-by-parity-ii/

import java.util.*;

public class LC_922 {
    public static int[] sortArrayByParityII(int[] nums) {
        // Initializing two pointers odd and even
        int odd = 1, even = 0, len = nums.length;
        // Making a new array. This could be done without using a new array, but that would involve
        // swapping and the runtime is higher.
        int[] res = new int[len];

        // Inserting even into even indexes and readying them up for next even element, same for odd
        for (int num : nums) {
            if (num % 2 == 0) {
                res[even] = num;
                even += 2;
            } else {
                res[odd] = num;
                odd += 2;
            }
        }
        // Returning the new array we created.
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};

        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
}
