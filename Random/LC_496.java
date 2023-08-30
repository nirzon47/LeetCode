// https://leetcode.com/problems/next-greater-element-i/

import java.util.*;

public class LC_496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // We iterate through the array we have to compare with first, which in this case is nums2
        for (int num : nums2) {
            // If there are elements in the stack that are smaller than num,
            // num is the next largest number for the elements in the stack,
            // So in a map, we associate the numbers smaller than the current element with the current element
            // implying that the largest number after the numbers in the stack is num.
            // num = current element
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            // Pushes new numbers regardless so it can be checked in the future
            stack.push(num);
        }

        // Making the result array
        int[] res = new int[nums1.length];
        int ptr = 0;

        // If there is a key of the numbers in the first array, we put the value in, otherwise we put -1
        // because there were no larger numbers
        for (int num : nums1) {
            res[ptr++] = map.getOrDefault(num, -1);
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
