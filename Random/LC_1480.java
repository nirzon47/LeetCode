// https://leetcode.com/problems/running-sum-of-1d-array/description/

public class LC_1480 {
    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        nums = runningSum(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
