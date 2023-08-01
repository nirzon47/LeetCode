// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.*;

public class LC_295 {
    // Taking 2 heaps, one min and one max and then add numbers in a balanced way
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    // Also taking a global variable to know when to add elements to which heap
    boolean even = true;

    public LC_295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public static void main(String[] args) {
        LC_295 obj = new LC_295();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

    public void addNum(int num) {
        // If the global variable is even, we add the number to the maxHeap and balance it with minHeap
        if (even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            // If it is odd, we add it to the minHeap and balance it with the maxHeap
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }

        // Changing the even variable
        even = !even;
    }

    public double findMedian() {
        // If even is true, it means we have even number of elements,
        // and we need to get the average between the top elements of both the elements at the top of the heap
        if (even) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            // And if even is false, we just need to get the middle element
            return minHeap.peek();
        }
    }
}
