// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.*;

public class LC_84 {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // Using monotonic stacks to get the next smaller elements from right and left for each indices
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // If the element in the stack's top is greater than the current number,
            // we remove it because we want smaller numbers
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            // If the stack is empty, we have no choice but to add the highest
            // possible length which is the length of the array
            if (stack.isEmpty()) nsr[i] = n;
                // Otherwise, we print the smallest we have seen so far, i.e., the top of the stack
            else nsr[i] = stack.peek();
            stack.push(i);
        }

        // Resetting the stack and doing the same thing but from the left to right
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) nsl[i] = -1;
            else nsl[i] = stack.peek();
            stack.push(i);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            // Our height is the product of the smallest right and the smallest left at each position because we want the area
            int area = heights[i] * (nsr[i] - nsl[i] - 1);
            res = Math.max(res, area);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(heights));
    }
}
