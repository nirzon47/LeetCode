// https://leetcode.com/problems/smallest-range-i/

public class LC_908 {
    public static int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        // Finding the minimum and the maximum number from the array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // If the min + k is greater than or equal, to the max - k, we return 0
        // If it is not, we return the difference between them
        return (min + k >= max - k) ? 0 : (max - k) - (min + k);
    }

    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{0, 10}, 2));
    }
}
