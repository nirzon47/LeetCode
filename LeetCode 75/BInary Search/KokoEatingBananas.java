// https://leetcode.com/problems/koko-eating-bananas/

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        // Using binary search to find k in range [1, max element in piles[]]
        int left = 1, right = Integer.MIN_VALUE;

        // Getting the max element in the pile
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // long because of a test case
            long hours = 0;

            // Adding ceil(pile/mid) to hours to know how many hours koko will need to eat the piles
            // Math.ceil doubles the runtime, so we check for the remainder and add 1 to it, manual ceil()
            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0)
                    hours++;
            }

            // If our calculated hours are less than or equal to the hours we require,
            // decrease the upper bound since we have to check the lower side as well
            // else we increase our lower bound
            if (hours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // left are our minimum hours we need to return
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(nums, h));
    }
}
