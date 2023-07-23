// https://leetcode.com/problems/concatenation-of-array/

import java.util.*;

public class LC_1929 {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        // Making an array of twice the size of the original
        int[] res = new int[n * 2];

        // Putting i and i + n as nums[i] so it takes half the iterations
        for (int i = 0; i < n; i++) {
            res[i] = res[i + n] = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
