// https://leetcode.com/problems/partition-array-according-to-given-pivot/

import java.util.*;

public class LC_2161 {
    public static int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] res = new int[len];
        // Taking two pointers at either end
        int left = 0, right = len - 1;

        for (int i = 0; i < len; i++) {
            // If our pointers coincide, we break out of it
            if (left >= right) {
                break;
            }

            // If the first half element is less than pivot, we put the element in left pointer in res
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            }

            // If the second half element is more than pivot, we put the element in right pointer in res
            if (nums[len - 1 - i] > pivot) {
                res[right--] = nums[len - 1 - i];
            }
        }

        // We left out elements that are equal to pivot so we are putting them in
        while (left <= right) {
            res[left++] = pivot;
            res[right--] = pivot;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }
}
