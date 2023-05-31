// https://leetcode.com/problems/product-of-array-except-self/

import java.util.*;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Makes a result array and fill it with 1
        Arrays.fill(res, 1);

        // Increasing product and storing it in result array
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= curr;
            curr *= nums[i];
        }
        // Decreasing product and storing it in result array.
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
}
