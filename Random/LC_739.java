// https://leetcode.com/problems/daily-temperatures/

import java.util.*;

public class LC_739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        // Using monotonic stack
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            } else {
                res[i] = 0; // This is redundant because the arrays have 0 as their default value
            }

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }
}
