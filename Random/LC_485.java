// https://leetcode.com/problems/max-consecutive-ones/

public class LC_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0, len = nums.length;

        for (int num : nums) {
            // When we encounter a 1, we increase 'count' by 1
            if (num == 1) {
                count++;
            } else {
                // When we are not dealing with a 1, we check if our count is max or not
                max = Math.max(count, max);
                count = 0;
            }
        }

        // If the last elements are 1s, the loop gets cut off without checking the last part
        // so we check it again
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
