// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

public class LC_747 {
    public static int dominantIndex(int[] nums) {
        int index = 0;
        // Getting the maximum number in one pass
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[index])
                index = i;
        }

        // Checking for the question condition
        for (int num : nums) {
            // Skipping if they are the same elements, if yes, we continue
            if (num == nums[index])
                continue;
            if (nums[index] < num * 2)
                return -1; // if the condition fails, we return -1
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};

        System.out.println(dominantIndex(nums));
    }
}
