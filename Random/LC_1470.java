// https://leetcode.com/problems/shuffle-the-array/description/

import java.util.*;

public class LC_1470 {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];

        int left = 0, right = n;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[left++];
            } else {
                res[i] = nums[right++];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;

        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
}
