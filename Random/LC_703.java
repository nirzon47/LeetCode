// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.*;

public class LC_703 {
    // Taking a priority heap to take all the inputs and sort them retroactively
    PriorityQueue<Integer> heap;
    // limit is the global variable that holds k
    int limit;

    public static void main(String[] args) {
        LC_703 obj = new LC_703();
        obj.KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }

    public void KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        limit = k;

        for (int num : nums) {
            // We use the add function to put elements in our heap
            add(num);
        }
    }

    public int add(int val) {
        heap.offer(val);

        // We add elements in our heap as long as its size is less than our limit
        // If a larger value were to be included. We would discard it
        // If a smaller value were to be added, we would discard the largest element
        if (heap.size() > limit) {
            heap.poll();
        }

        // We always return the largest Kth element
        return heap.peek();
    }
}
