// https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.*;

public class MaxNumberOfKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        // Using two pointer technique
        int count = 0;
        int left = 0, right = nums.length - 1;

        // Sorting array, so we can increase the pointers individually and not both at the same time in an orderly manner.
        // Increasing both at the same time will result in missed elements.
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (k > sum) // if k is more than the sum, we increase left, otherwise right.
                left++;
            else
                right--;

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(maxOperations(nums, k));
    }
}
