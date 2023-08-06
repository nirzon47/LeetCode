// https://leetcode.com/problems/jump-game/

public class LC_55 {
    public static boolean canJump(int[] nums) {
        int count = 0;
        /* We are moving from the second last element. If the first jump is more than 0,
         * that means we can reach the end, otherwise we increase our needed steps by 1 and move to the previous element
         * and check if that element can cover for the jumps,
         * we keep doing this until we find a valid jump, and at that point,
         * we reset our jumps needed to 0.
         * If in the end, our needed jumps are 0, we return true. Otherwise, we return false.
         */
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= count) {
                count++;
            } else {
                count = 0;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
