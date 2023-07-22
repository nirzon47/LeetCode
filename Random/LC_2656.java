// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/

public class LC_2656 {
    public static int maximizeSum(int[] nums, int k) {
        /*
         * We use the formula n * (n + 1) / 2 to get the sum of elements till max of the array
         * Then take another range and get their sum from (max + k) * (max + k + 1) / 2
         * We subtract both of them to get our answer
         */
        int max = 0;

        for (int i : nums) {
            max = Math.max(i, max);
        }

        int range1 = (max - 1) * max / 2;
        int range2 = (max + k - 1) * (max + k) / 2;

        return range2 - range1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(maximizeSum(nums, k));
    }
}
