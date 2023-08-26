// https://leetcode.com/problems/sign-of-the-product-of-an-array/

public class LC_1822 {
    public static int arraySign(int[] nums) {
        // We are counting the number of negatives in the array, if it is odd, the entire product is negative
        // Otherwise its positive
        // Given there are no zeros
        int negatives = 0;

        for (int num : nums) {
            // If a number is 0, the product of the entire array is 0
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                negatives++;
            }
        }

        return negatives % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
    }
}
