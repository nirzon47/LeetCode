// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/

public class LC_1464 {

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, max2nd = Integer.MIN_VALUE;

        // Taking the two max numbers in one pass
        for (int num : nums) {
            if (num > max) {
                max2nd = max;
                max = num;
            } else if (num > max2nd) {
                max2nd = num;
            }
        }

        // Returning the products
        return (max - 1) * (max2nd - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};

        System.out.println(maxProduct(nums));
    }
}
