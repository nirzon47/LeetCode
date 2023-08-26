// https://leetcode.com/problems/sort-an-array/

import java.util.*;

public class LC_912 {
    public static int[] sortArray(int[] nums) {
        // Taking a min heap and adding all the elements inside it
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
        }

        int pointer = 0;
        // Until the heap is empty, we are polling the element in the array
        while (!heap.isEmpty()) {
            nums[pointer++] = heap.poll();
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));
    }
}
