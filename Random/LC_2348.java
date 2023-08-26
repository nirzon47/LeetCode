// https://leetcode.com/problems/number-of-zero-filled-subarrays/

public class LC_2348 {
    public static long zeroFilledSubarray(int[] nums) {
        long res = 0, count;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            count = 0;

            // If the current element is 0, we increase our count and our iterator,
            // we keep doing this until the element is no longer 0
            while (i < len && nums[i] == 0) {
                count++;
                i++;
            }

            // Since we are counting every single zero subarrays,
            // we use the sum of n natural number AP formula to add all the possible subarrays
            res += count * (count + 1) / 2;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }
}
