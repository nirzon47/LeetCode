// https://leetcode.com/problems/last-stone-weight/

import java.util.*;

public class LC_1046 {
    public static int lastStoneWeight(int[] stones) {
        // Taking a max heap and adding all the stones in it
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int stone : stones) {
            queue.add(stone);
        }

        // If our queue's size is 2 or above, we keep taking the first 2 elements from the peak
        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            int diff = y - x;

            // If the difference between them is 0, the stones will destroy each other
            // Otherwise we take the difference between them
            if (diff > 0) {
                queue.offer(diff);
            }
        }

        // If the queue is empty, we return 0, otherwise we return the first element in the heap
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println(lastStoneWeight(stones));
    }
}
