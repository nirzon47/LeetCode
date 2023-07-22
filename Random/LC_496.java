// https://leetcode.com/problems/next-greater-element-i/

import java.util.*;

public class LC_496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Using the map to store the 
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        int i = 0;
        for (int num : nums1) {
            res[i++] = map.getOrDefault(num, -1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println();
    }
}
