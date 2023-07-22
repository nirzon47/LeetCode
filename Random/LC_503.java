// https://leetcode.com/problems/next-greater-element-ii/

import java.util.*;

public class LC_503 {
    public static int[] nextGreaterElements(int[] nums) {
        // Using monotonic stack to get the next greater elements
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // We are rotating through the array twice because this is a circular queue
        for (int i = 2 * n - 1; i >= 0; i--) {
            // We are getting the index my using mod with n
            int idx = i % n;
            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                // If the head of our stack is smaller or equal to our current element,
                // we pop it because we only want bigger numbers
                stack.pop();
            }

            // If our stack is empty, we don't have a bigger element, so we put -1
            // Otherwise, we put the number at the top of the stack
            res[idx] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[idx]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
