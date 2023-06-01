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

    /*
    Both the solutions have same time and space time.
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int numZero = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num != 0)
                product *= num;
            else
                numZero++;
            if (numZero > 1)
                break;
        }
        for (int i = 0; i < nums.length; i++) {
            if (numZero == 2)
                res[i] = 0;
            else if (numZero == 1) {
                if (nums[i] == 0)
                    res[i] = product;
                else
                    res[i] = 0;
            } else {
                res[i] = product / nums[i];
            }
        }

        return res;
    } */

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
