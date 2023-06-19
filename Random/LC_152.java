// https://leetcode.com/problems/maximum-product-subarray/

public class LC_152 {

    public static int maxProduct(int[] nums) {
        // Taking both min and max products of subarrays because in case of even number of negatives,
        // our product, which we might have discarded, has the possibility to be the largest
        // product in a subarray
        int res = nums[0], maxProd = 1, minProd = 1;

        for (int num : nums) {
            // Saving the maxProd * num since maxProd will be replaced in the next line
            int temp = maxProd * num;
            // Taking the maximum between the products maxProd with the current number,
            // minProd with the current number and just the number itself because
            // the number itself is a subarray
            // Same with the minimum
            maxProd = Math.max(maxProd * num, Math.max(minProd * num, num));
            minProd = Math.min(minProd * num, Math.min(temp, num));

            res = Math.max(res, maxProd);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));
    }
}
